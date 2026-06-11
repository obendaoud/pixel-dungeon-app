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
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Paralysis;
import com.watabou.pixeldungeon.actors.buffs.Slow;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.TimeLoopBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.WraithSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Time Loop (Act III, depth 65).
 *
 * Roadmap intent: floor resets every N rounds, partial progress persists.
 * M5 v1 ships baseline stats + Slow/Paralysis on hit; the level-reset
 * mechanic is a follow-up because it touches the level save/restore
 * pipeline.
 */
public class TheWatcher extends Mob {

	{
		name = "The Watcher";

		HP = HT = 460;
		EXP = 48;
		defenseSkill = 38;

		spriteClass = WraithSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 30, 56 ); }
	@Override public int attackSkill( Char target ) { return 44; }
	@Override public int dr() { return 14; }
	@Override public String defenseVerb() { return "stepped aside" ; }

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Slow.class, Slow.duration( enemy ) );
		}
		if (Random.Int( 5 ) == 0) {
			Buff.affect( enemy, Paralysis.class, 3 );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof TimeLoopBossLevel) {
			((TimeLoopBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof TimeLoopBossLevel) {
			((TimeLoopBossLevel) Dungeon.level).unseal();
		}
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...the loop... breaks..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "You have done this before. So have I." );
	}

	@Override
	public String description() {
		return
			"The Watcher has counted every step the Crypt's dead ever took. Now " +
			"it counts yours. Its measure is the moment between two ticks.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
