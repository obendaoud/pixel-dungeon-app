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
import com.watabou.pixeldungeon.sprites.ShamanSprite;
import com.watabou.utils.Random;

/** Garden regular mob (Act II, depths 41-44). Spore-spitting shaman. */
public class RotShaman extends Shaman {

	{
		name = "rot shaman";

		HP = HT = 100;
		defenseSkill = 28;

		EXP = 15;
		maxLvl = 27;

		spriteClass = ShamanSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 16, 30 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 32;
	}

	@Override
	public String description() {
		return
			"The rot shamans tend the Garden's worst growth, midwiving fungal " +
			"blossoms from corpses. They carry the spores in their breath.";
	}
}
