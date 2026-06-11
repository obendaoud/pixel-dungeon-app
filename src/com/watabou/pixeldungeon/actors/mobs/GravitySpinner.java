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
import com.watabou.pixeldungeon.sprites.SpinnerSprite;
import com.watabou.utils.Random;

/** Gravity Wells regular mob (Act III, depths 56-59). Falling spinner. */
public class GravitySpinner extends Mob {

	{
		name = "gravity spinner";

		HP = HT = 140;
		defenseSkill = 36;

		EXP = 18;
		maxLvl = 30;

		spriteClass = SpinnerSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 18, 30 ); }
	@Override public int attackSkill( Char target ) { return 42; }
	@Override public int dr() { return 6; }
	@Override public String defenseVerb() { return "side-stepped"; }

	@Override
	public String description() {
		return
			"A spinner that spins downward instead of side-to-side, its threads " +
			"falling like fishing lines from the ceiling.";
	}
}
