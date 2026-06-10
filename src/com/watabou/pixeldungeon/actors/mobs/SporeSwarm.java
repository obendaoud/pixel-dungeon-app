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

/** Garden regular mob (Act II, depths 41-44). Spore cloud variant of swarm. */
public class SporeSwarm extends Swarm {

	{
		name = "spore swarm";

		HP = HT = 75;
		defenseSkill = 26;

		EXP = 13;
		maxLvl = 26;

		spriteClass = SwarmSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 12, 22 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 30;
	}

	@Override
	public String description() {
		return
			"A drifting cloud of spores that thinks, and feeds. Striking it scatters " +
			"smaller clouds in every direction, only for them to gather again.";
	}
}
