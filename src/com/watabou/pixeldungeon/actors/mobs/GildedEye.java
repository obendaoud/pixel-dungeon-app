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
import com.watabou.pixeldungeon.sprites.EyeSprite;
import com.watabou.utils.Random;

/** Vault regular mob (Act II, depths 46-49). Gilded sentry eye. */
public class GildedEye extends Eye {

	{
		name = "gilded eye";

		HP = HT = 110;
		defenseSkill = 32;

		EXP = 16;
		maxLvl = 28;

		spriteClass = EyeSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 16, 32 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 34;
	}

	@Override
	public String description() {
		return
			"A floating sphere of gold, ringed by closed eyelids on every face. " +
			"At least one of them is always watching.";
	}
}
