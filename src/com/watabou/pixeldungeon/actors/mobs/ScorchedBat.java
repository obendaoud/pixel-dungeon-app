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
import com.watabou.pixeldungeon.sprites.BatSprite;
import com.watabou.utils.Random;

/** Burning Caves regular mob (Act IV, depths 86-89). */
public class ScorchedBat extends Mob {
	{
		name = "scorched bat";
		HP = HT = 180; defenseSkill = 48; EXP = 24; maxLvl = 34;
		spriteClass = BatSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 28, 46 ); }
	@Override public int attackSkill( Char target ) { return 52; }
	@Override public int dr() { return 7; }
	@Override public String defenseVerb() { return "fluttered past"; }
	@Override public String description() {
		return
			"A bat that hunts in the warm thermals of the Burning Caves. Its " +
			"membrane is leather, blackened and bone-dry.";
	}
}
