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
import com.watabou.pixeldungeon.sprites.WraithSprite;
import com.watabou.utils.Random;

/** Time Loop regular mob (Act III, depths 61-64). Repeating echo of motion. */
public class ChronoEcho extends Mob {

	{
		name = "chrono echo";

		HP = HT = 150;
		defenseSkill = 38;

		EXP = 20;
		maxLvl = 32;

		spriteClass = WraithSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 24, 42 ); }
	@Override public int attackSkill( Char target ) { return 44; }
	@Override public int dr() { return 7; }
	@Override public String defenseVerb() { return "rewound" ; }

	@Override
	public String description() {
		return
			"A chrono echo is the same swing, struck minutes earlier, arriving " +
			"now. The thing inside it has been dying for a long time.";
	}
}
