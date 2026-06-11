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
import com.watabou.pixeldungeon.sprites.MonkSprite;
import com.watabou.utils.Random;

/** Tainted City regular mob (Act IV, depths 81-84). */
public class HollowMonk extends Mob {
	{
		name = "hollow monk";
		HP = HT = 230; defenseSkill = 46; EXP = 25; maxLvl = 35;
		spriteClass = MonkSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 36, 58 ); }
	@Override public int attackSkill( Char target ) { return 50; }
	@Override public int dr() { return 13; }
	@Override public String defenseVerb() { return "redirected"; }
	@Override public String description() {
		return
			"A monk with nothing inside the robe but the discipline. Where its " +
			"hand passes, an afterimage of devotion lingers.";
	}
}
