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
import com.watabou.pixeldungeon.sprites.GolemSprite;
import com.watabou.utils.Random;

/** Gravity Wells regular mob (Act III, depths 56-59). Mass-bound sentinel. */
public class WellGuard extends Mob {

	{
		name = "well guard";

		HP = HT = 200;
		defenseSkill = 30;

		EXP = 20;
		maxLvl = 32;

		spriteClass = GolemSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 30, 52 ); }
	@Override public int attackSkill( Char target ) { return 38; }
	@Override public int dr() { return 14; }
	@Override public String defenseVerb() { return "blocked"; }

	@Override
	public String description() {
		return
			"A creature so dense it bends the floor beneath its feet. It moves " +
			"slowly, and the air thickens as it approaches.";
	}
}
