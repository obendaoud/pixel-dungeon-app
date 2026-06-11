/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.actors.mobs;

import java.util.HashSet;

import com.watabou.pixeldungeon.Badges;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.Statistics;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.blobs.ToxicGas;
import com.watabou.pixeldungeon.actors.buffs.Bleeding;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Burning;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.items.Amulet;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.FinalSewerBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.KingSprite;
import com.watabou.utils.Random;

/**
 * Final boss of the 100-floor dungeon (Act IV, depth 100).
 *
 * The Architect is the run-ending confrontation. It echoes the player's own
 * shape and intent: it was here when the run started, watched every choice,
 * and is the dungeon thinking back. On death it drops the Amulet of Yendor,
 * which triggers the existing {@link com.watabou.pixeldungeon.scenes.AmuletScene}
 * on pickup, and flips {@link Statistics#finalBossSlain} for the run-completion
 * counter / New-Game-Plus hook.
 *
 * Mechanically: highest HP / damage in the dungeon, regenerates 5 HP per
 * turn, has a chance to apply Burning + Weakness + Bleeding + Paralysis on
 * any hit.
 */
public class TheArchitect extends Mob {

	private static final int SELF_HEAL = 5;

	{
		name = "The Architect";

		HP = HT = 1000;
		EXP = 100;
		defenseSkill = 56;

		spriteClass = KingSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 50, 84 ); }
	@Override public int attackSkill( Char target ) { return 64; }
	@Override public int dr() { return 22; }
	@Override public String defenseVerb() { return "anticipated" ; }

	@Override
	public boolean act() {
		if (HP < HT) {
			HP = Math.min( HT, HP + SELF_HEAL );
		}
		return super.act();
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Burning.class ).reignite( enemy );
		}
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Weakness.class, Weakness.duration( enemy ) );
		}
		if (Random.Int( 3 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) {
				b.set( damage );
			}
		}
		if (Random.Int( 8 ) == 0) {
			Buff.affect( enemy, Paralysis.class, 2 );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof FinalSewerBossLevel) {
			((FinalSewerBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		if (Dungeon.level instanceof FinalSewerBossLevel) {
			((FinalSewerBossLevel) Dungeon.level).unseal();
		}

		GameScene.bossSlain();

		// Drop the Amulet of Yendor. Picking it up triggers the existing
		// AmuletScene ending (Amulet.doPickup -> showAmuletScene). This
		// reuses the original ending pipeline that was orphaned by the
		// removal of LastLevel in M2.
		Dungeon.level.drop( new Amulet(), pos ).sprite.drop();

		Badges.validateBossSlain();

		// Mark run completion for New-Game-Plus and end-of-run statistics.
		Statistics.finalBossSlain = true;

		yell( "you... built me... by walking here." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "I have been waiting. The dungeon has been waiting." );
	}

	@Override
	public String description() {
		return
			"The Architect designed every floor you crossed by watching how you " +
			"walked across the previous one. It wears no face of its own. It " +
			"borrows yours.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Burning.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
