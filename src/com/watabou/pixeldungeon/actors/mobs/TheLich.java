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
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.CryptBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.WraithSprite;
import com.watabou.utils.Random;

/** Boss of the Crypt zone (Act II, depth 35). */
public class TheLich extends Mob {

	{
		name = "The Lich";

		HP = HT = 260;
		EXP = 32;
		defenseSkill = 28;

		spriteClass = WraithSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 18, 32 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 34;
	}

	@Override
	public int dr() {
		return 8;
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Weakness.class, Weakness.duration( enemy ) );
		}
		if (Random.Int( 3 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) {
				b.set( damage );
			}
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof CryptBossLevel) {
			((CryptBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		if (Dungeon.level instanceof CryptBossLevel) {
			((CryptBossLevel) Dungeon.level).unseal();
		}

		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();

		Badges.validateBossSlain();

		yell( "Death is... not... an ending..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Who walks the Crypt unwelcome?" );
	}

	@Override
	public String description() {
		return
			"The Lich was once the Crypt's archivist, then its first inhabitant, " +
			"then its keeper. Its body has shrunk to robes and a memory of bone; " +
			"its will has only grown.";
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
