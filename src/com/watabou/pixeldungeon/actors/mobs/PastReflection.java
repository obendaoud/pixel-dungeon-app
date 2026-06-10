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

/** Time Loop regular mob (Act III, depths 61-64). Past warrior in repeat. */
public class PastReflection extends Mob {

	{
		name = "past reflection";

		HP = HT = 175;
		defenseSkill = 34;

		EXP = 21;
		maxLvl = 33;

		spriteClass = SkeletonSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 28, 48 ); }
	@Override public int attackSkill( Char target ) { return 40; }
	@Override public int dr() { return 9; }
	@Override public String defenseVerb() { return "stepped through" ; }

	@Override
	public String description() {
		return
			"An adventurer that died here, looping through the last hour of their " +
			"life. Strike them in any minute of it; they remember.";
	}
}
