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

/** Void Reach regular mob (Act III, depths 71-74). Hunger of the deep void. */
public class StarvedEye extends Mob {

	{
		name = "starved eye";

		HP = HT = 180;
		defenseSkill = 38;

		EXP = 22;
		maxLvl = 33;

		spriteClass = EyeSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 30, 50 ); }
	@Override public int attackSkill( Char target ) { return 44; }
	@Override public int dr() { return 10; }
	@Override public String defenseVerb() { return "swallowed the swing" ; }

	@Override
	public String description() {
		return
			"An eye that has not blinked since the last star burned out. It looks " +
			"at you the way a fire looks at fuel.";
	}
}
