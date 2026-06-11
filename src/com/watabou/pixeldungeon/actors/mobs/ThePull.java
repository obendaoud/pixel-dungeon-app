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
import com.watabou.pixeldungeon.actors.buffs.Roots;
import com.watabou.pixeldungeon.actors.buffs.Vertigo;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.GravityWellsBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.GolemSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Gravity Wells (Act III, depth 60).
 *
 * Roadmap intent: gravity direction rotates every N turns. M5 v1 ships
 * the boss with stat-tuned baseline + Vertigo/Roots on hit; the global
 * gravity rotation hook is a follow-up because it touches the movement
 * pipeline.
 */
public class ThePull extends Mob {

	{
		name = "The Pull";

		HP = HT = 420;
		EXP = 46;
		defenseSkill = 32;

		spriteClass = GolemSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 32, 54 ); }
	@Override public int attackSkill( Char target ) { return 40; }
	@Override public int dr() { return 16; }
	@Override public String defenseVerb() { return "grounded the strike" ; }

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Roots.class, 4 );
		}
		if (Random.Int( 2 ) == 0) {
			Buff.affect( enemy, Vertigo.class, Vertigo.duration( enemy ) );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof GravityWellsBossLevel) {
			((GravityWellsBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof GravityWellsBossLevel) {
			((GravityWellsBossLevel) Dungeon.level).unseal();
		}
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...down... down at last..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "All things fall." );
	}

	@Override
	public String description() {
		return
			"A creature of mass and intent, hanging where no thing of its weight " +
			"should hang. The floor reaches for it; the ceiling shies away.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
