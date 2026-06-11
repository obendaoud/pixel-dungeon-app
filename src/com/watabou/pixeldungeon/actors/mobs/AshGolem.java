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
import com.watabou.pixeldungeon.sprites.GolemSprite;
import com.watabou.utils.Random;

/** Burning Caves regular mob (Act IV, depths 86-89). */
public class AshGolem extends Mob {
	{
		name = "ash golem";
		HP = HT = 260; defenseSkill = 44; EXP = 26; maxLvl = 35;
		spriteClass = GolemSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 38, 62 ); }
	@Override public int attackSkill( Char target ) { return 50; }
	@Override public int dr() { return 16; }
	@Override public String defenseVerb() { return "endured"; }
	@Override public String description() {
		return
			"A golem of cooled ash held together by the heat that made it. Every " +
			"step leaves a black footprint that smoulders for a moment.";
	}
}
