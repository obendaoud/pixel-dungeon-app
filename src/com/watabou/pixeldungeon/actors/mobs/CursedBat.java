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
import com.watabou.pixeldungeon.sprites.BatSprite;
import com.watabou.utils.Random;

/** Crypt regular mob (Act II, depths 31-34). Fast cursed bat. */
public class CursedBat extends Bat {

	{
		name = "cursed bat";

		HP = HT = 70;
		defenseSkill = 30;

		EXP = 12;
		maxLvl = 25;

		spriteClass = BatSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 10, 22 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 32;
	}

	@Override
	public int dr() {
		return 4;
	}

	@Override
	public String description() {
		return
			"Larger than the cave bats and stained with grave dust, cursed bats " +
			"hang from the Crypt ceilings in restless clusters. Their bite " +
			"weakens muscle and resolve in equal measure.";
	}
}
