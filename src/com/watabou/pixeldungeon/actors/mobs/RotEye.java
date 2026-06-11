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

/** Corrupted Halls regular mob (Act IV, depths 76-79). */
public class RotEye extends Mob {
	{
		name = "rot eye";
		HP = HT = 200; defenseSkill = 42; EXP = 23; maxLvl = 34;
		spriteClass = EyeSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 32, 52 ); }
	@Override public int attackSkill( Char target ) { return 46; }
	@Override public int dr() { return 11; }
	@Override public String defenseVerb() { return "withered"; }
	@Override public String description() {
		return
			"An eye crusted shut with old viewing. When it opens, the air it sees " +
			"begins to spoil.";
	}
}
