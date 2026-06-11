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
import com.watabou.pixeldungeon.sprites.ThiefSprite;
import com.watabou.utils.Random;

/** Bloody Prison regular mob (Act IV, depths 91-94). */
public class BloodThief extends Mob {
	{
		name = "blood thief";
		HP = HT = 200; defenseSkill = 50; EXP = 25; maxLvl = 34;
		spriteClass = ThiefSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 30, 50 ); }
	@Override public int attackSkill( Char target ) { return 54; }
	@Override public int dr() { return 9; }
	@Override public String defenseVerb() { return "vanished"; }
	@Override public String description() {
		return
			"A thief that learned, here, to steal warmth itself. The pockets on " +
			"its tunic are stuffed with someone else's pulse.";
	}
}
