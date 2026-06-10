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
import com.watabou.pixeldungeon.actors.buffs.Poison;
import com.watabou.pixeldungeon.actors.buffs.Roots;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.GardenBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.ScorpioSprite;
import com.watabou.utils.Random;

/** Boss of the Garden zone (Act II, depth 45). */
public class VerdantHeart extends Mob {

	{
		name = "Verdant Heart";

		HP = HT = 320;
		EXP = 36;
		defenseSkill = 28;

		spriteClass = ScorpioSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 18, 36 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 34;
	}

	@Override
	public int dr() {
		return 10;
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Roots.class, 5 );
		}
		if (Random.Int( 2 ) == 0) {
			Buff.affect( enemy, Poison.class ).set( Poison.durationFactor( enemy ) * (3 + Dungeon.depth / 10) );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof GardenBossLevel) {
			((GardenBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		if (Dungeon.level instanceof GardenBossLevel) {
			((GardenBossLevel) Dungeon.level).unseal();
		}

		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();

		Badges.validateBossSlain();

		yell( "...root and rot... root and..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Walker. Trespasser. You will feed the Garden." );
	}

	@Override
	public String description() {
		return
			"At the core of the Garden grows a single immense bloom, ringed by " +
			"vines that twist and grasp. Strikes that find its flesh make the " +
			"whole chamber shudder.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Poison.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override
	public HashSet<Class<?>> resistances() {
		return RESISTANCES;
	}
}
