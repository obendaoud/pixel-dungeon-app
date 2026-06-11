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

/** Library regular mob (Act II, depths 36-39). Bound book swarm. */
public class PaperGolem extends Golem {

	{
		name = "paper golem";

		HP = HT = 130;
		defenseSkill = 24;

		EXP = 16;
		maxLvl = 28;

		spriteClass = GolemSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 22, 42 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 32;
	}

	@Override
	public String description() {
		return
			"A walking sheaf of pages glued and stitched into limbs. Where its " +
			"hands strike, the ink runs and the text rearranges itself.";
	}
}
