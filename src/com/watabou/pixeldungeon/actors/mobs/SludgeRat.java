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
import com.watabou.pixeldungeon.sprites.RatSprite;
import com.watabou.utils.Random;

/** Final Sewer regular mob (Act IV, depths 96-99). The first enemy, returned. */
public class SludgeRat extends Mob {
	{
		name = "sludge rat";
		HP = HT = 220; defenseSkill = 50; EXP = 27; maxLvl = 36;
		spriteClass = RatSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 38, 58 ); }
	@Override public int attackSkill( Char target ) { return 54; }
	@Override public int dr() { return 12; }
	@Override public String defenseVerb() { return "slipped"; }
	@Override public String description() {
		return
			"The rats of the upper Sewers, ninety floors later. They have learned " +
			"a great deal about you on the way down.";
	}
}
