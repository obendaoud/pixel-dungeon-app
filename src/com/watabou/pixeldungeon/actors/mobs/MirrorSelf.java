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
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.blobs.ToxicGas;
import com.watabou.pixeldungeon.actors.buffs.Bleeding;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Cripple;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.MirrorHallsBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.MirrorSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Mirror Halls (Act III, depth 55).
 *
 * Roadmap intent: a copy of the player wielding a portion of their
 * inventory. M5 v1 ships the boss with stat-tuned baseline only; the
 * inventory-mirroring AI hook is a follow-up because it touches the Mob
 * spawn pipeline.
 */
public class MirrorSelf extends Mob {

	{
		name = "Mirror Self";

		HP = HT = 380;
		EXP = 44;
		defenseSkill = 34;

		spriteClass = MirrorSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 26, 48 ); }
	@Override public int attackSkill( Char target ) { return 40; }
	@Override public int dr() { return 12; }
	@Override public String defenseVerb() { return "parried"; }

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Cripple.class, Cripple.DURATION );
		}
		if (Random.Int( 2 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) {
				b.set( damage );
			}
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof MirrorHallsBossLevel) {
			((MirrorHallsBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		if (Dungeon.level instanceof MirrorHallsBossLevel) {
			((MirrorHallsBossLevel) Dungeon.level).unseal();
		}
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...you go on... I stay..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Hello." );
	}

	@Override
	public String description() {
		return
			"It wears your face. It walks your walk. It strikes with the same hand " +
			"you are about to raise. Killing it is the only honest thing left in " +
			"the Halls.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
