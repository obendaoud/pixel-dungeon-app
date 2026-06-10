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
import com.watabou.pixeldungeon.sprites.SwarmSprite;
import com.watabou.utils.Random;

/** Echo Chambers regular mob (Act III, depths 66-69). Self-reinforcing sound cluster. */
public class ResonantSwarm extends Mob {

	{
		name = "resonant swarm";

		HP = HT = 120;
		defenseSkill = 36;

		EXP = 19;
		maxLvl = 31;

		spriteClass = SwarmSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 18, 32 ); }
	@Override public int attackSkill( Char target ) { return 40; }
	@Override public int dr() { return 6; }
	@Override public String defenseVerb() { return "absorbed" ; }

	@Override
	public String description() {
		return
			"A cloud of sound made flesh; or possibly flesh made of sound. Each " +
			"sting reproduces the noise that produced it.";
	}
}
