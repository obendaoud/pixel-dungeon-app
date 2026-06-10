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
import com.watabou.pixeldungeon.sprites.WraithSprite;
import com.watabou.utils.Random;

/** Mirror Halls regular mob (Act III, depths 51-54). */
public class MirrorWalker extends Mob {

	{
		name = "mirror walker";

		HP = HT = 130;
		defenseSkill = 34;

		EXP = 18;
		maxLvl = 30;

		spriteClass = WraithSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 22, 38 ); }
	@Override public int attackSkill( Char target ) { return 40; }
	@Override public int dr() { return 6; }
	@Override public String defenseVerb() { return "evaded"; }

	@Override
	public String description() {
		return
			"A walker through reflections. It strikes from the angle you are not " +
			"watching, in the moment between two glances.";
	}
}
