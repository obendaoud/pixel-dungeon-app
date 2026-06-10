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
import com.watabou.pixeldungeon.actors.buffs.Terror;
import com.watabou.pixeldungeon.actors.buffs.Vertigo;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.LibraryBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.WarlockSprite;
import com.watabou.utils.Random;

/** Boss of the Library zone (Act II, depth 40). */
public class WhisperingTome extends Mob {

	{
		name = "Whispering Tome";

		HP = HT = 290;
		EXP = 34;
		defenseSkill = 30;

		spriteClass = WarlockSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 16, 34 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 36;
	}

	@Override
	public int dr() {
		return 9;
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Vertigo.class, Vertigo.duration( enemy ) );
		}
		if (Random.Int( 4 ) == 0) {
			Buff.affect( enemy, Terror.class, Terror.DURATION ).object = id();
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof LibraryBossLevel) {
			((LibraryBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		if (Dungeon.level instanceof LibraryBossLevel) {
			((LibraryBossLevel) Dungeon.level).unseal();
		}

		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();

		Badges.validateBossSlain();

		yell( "...let the silence read me..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Who dares interrupt the reading?" );
	}

	@Override
	public String description() {
		return
			"A bound book the size of a man, hovering in mid-air, pages flipping " +
			"on their own. Every page bears a passage you have heard somewhere " +
			"before, in a voice you cannot place.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override
	public HashSet<Class<?>> resistances() {
		return RESISTANCES;
	}
}
