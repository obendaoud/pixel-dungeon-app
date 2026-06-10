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

import com.watabou.pixeldungeon.sprites.GolemSprite;
import com.watabou.utils.Random;

/**
 * Forge zone heavy mob (Act II, depths 26-29).
 *
 * Stronger variant of {@link Golem} stoked by the Forge heat. Reuses the
 * standard golem sprite as a visual placeholder until a dedicated Molten
 * Golem sprite atlas is produced.
 */
public class MoltenGolem extends Golem {

	{
		name = "molten golem";

		HP = HT = 110;
		defenseSkill = 22;

		EXP = 15;
		maxLvl = 26;

		spriteClass = GolemSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 24, 44 );
	}

	@Override
	public int attackSkill( com.watabou.pixeldungeon.actors.Char target ) {
		return 30;
	}

	@Override
	public String description() {
		return
			"A golem of slag and cooling rock, dragged out of the foundry to walk " +
			"on legs of its own weight. Veins of molten metal still pulse beneath " +
			"its surface; every strike releases a wave of heat.";
	}
}
