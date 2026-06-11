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

/** Void Reach regular mob (Act III, depths 71-74). Drinker of substance. */
public class VoidWraith extends Mob {

	{
		name = "void wraith";

		HP = HT = 165;
		defenseSkill = 42;

		EXP = 22;
		maxLvl = 33;

		spriteClass = WraithSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 26, 46 ); }
	@Override public int attackSkill( Char target ) { return 46; }
	@Override public int dr() { return 8; }
	@Override public String defenseVerb() { return "unmade the swing" ; }

	@Override
	public String description() {
		return
			"Less than a ghost, more than a shadow, the void wraiths feed by " +
			"unmaking the air in front of them. What they eat does not come back.";
	}
}
