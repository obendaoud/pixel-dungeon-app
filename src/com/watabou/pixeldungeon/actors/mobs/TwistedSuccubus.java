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
import com.watabou.pixeldungeon.sprites.SuccubusSprite;
import com.watabou.utils.Random;

/** Corrupted Halls regular mob (Act IV, depths 76-79). */
public class TwistedSuccubus extends Mob {
	{
		name = "twisted succubus";
		HP = HT = 220; defenseSkill = 44; EXP = 24; maxLvl = 34;
		spriteClass = SuccubusSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 34, 56 ); }
	@Override public int attackSkill( Char target ) { return 48; }
	@Override public int dr() { return 12; }
	@Override public String defenseVerb() { return "shrugged off"; }
	@Override public String description() {
		return
			"A succubus that has lived too long with itself. Whatever it once " +
			"seduced, it now strangles instead.";
	}
}
