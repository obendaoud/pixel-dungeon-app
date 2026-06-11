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

import com.watabou.pixeldungeon.sprites.ElementalSprite;
import com.watabou.utils.Random;

/**
 * Forge zone regular mob (Act II, depths 26-29).
 *
 * Stronger variant of {@link Elemental} fitted for the higher-depth Forge
 * encounters. Reuses the fire elemental sprite as a visual placeholder until
 * a dedicated Lava Imp sprite atlas is produced.
 */
public class LavaImp extends Elemental {

	{
		name = "lava imp";

		HP = HT = 80;
		defenseSkill = 24;

		EXP = 13;
		maxLvl = 24;

		spriteClass = ElementalSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 18, 26 );
	}

	@Override
	public int attackSkill( com.watabou.pixeldungeon.actors.Char target ) {
		return 28;
	}

	@Override
	public int dr() {
		return 8;
	}

	@Override
	public String description() {
		return
			"Smaller and faster than the fire elementals of the city, lava imps " +
			"have wormed their way up from the cracks of the Forge. Their skin is " +
			"a moving crust over a core of liquid fire.";
	}
}
