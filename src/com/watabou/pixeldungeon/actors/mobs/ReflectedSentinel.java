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
import com.watabou.pixeldungeon.sprites.StatueSprite;
import com.watabou.utils.Random;

/** Mirror Halls regular mob (Act III, depths 51-54). Reflective sentinel. */
public class ReflectedSentinel extends Mob {

	{
		name = "reflected sentinel";

		HP = HT = 160;
		defenseSkill = 30;

		EXP = 19;
		maxLvl = 31;

		spriteClass = StatueSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 26, 44 ); }
	@Override public int attackSkill( Char target ) { return 36; }
	@Override public int dr() { return 10; }
	@Override public String defenseVerb() { return "deflected"; }

	@Override
	public String description() {
		return
			"A statue of mirrored stone, taking the shape of whoever sees it. " +
			"It stops moving the instant you look away.";
	}
}
