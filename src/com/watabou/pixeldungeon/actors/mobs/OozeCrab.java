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
import com.watabou.pixeldungeon.sprites.CrabSprite;
import com.watabou.utils.Random;

/** Final Sewer regular mob (Act IV, depths 96-99). */
public class OozeCrab extends Mob {
	{
		name = "ooze crab";
		HP = HT = 260; defenseSkill = 46; EXP = 27; maxLvl = 36;
		spriteClass = CrabSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 40, 64 ); }
	@Override public int attackSkill( Char target ) { return 50; }
	@Override public int dr() { return 14; }
	@Override public String defenseVerb() { return "carapaced"; }
	@Override public String description() {
		return
			"A sewer crab grown to enormous size, shell dripping with the runoff " +
			"of every act below. Its claws sing when they meet steel.";
	}
}
