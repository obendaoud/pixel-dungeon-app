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

import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.sprites.SkeletonSprite;
import com.watabou.utils.Random;

/** Crypt regular mob (Act II, depths 31-34). Stronger Skeleton variant. */
public class GhoulRaiser extends Skeleton {

	{
		name = "ghoul raiser";

		HP = HT = 95;
		defenseSkill = 26;

		EXP = 14;
		maxLvl = 26;

		spriteClass = SkeletonSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 14, 28 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 30;
	}

	@Override
	public int dr() {
		return 9;
	}

	@Override
	public String description() {
		return
			"A ghoul raiser is what remains of a Crypt priest. It chants under " +
			"breath in a language no living tongue speaks, and the dead within " +
			"reach of its voice begin to stir.";
	}
}
