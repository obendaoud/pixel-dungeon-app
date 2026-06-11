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
import com.watabou.pixeldungeon.sprites.ShopkeeperSprite;
import com.watabou.utils.Random;

/** Tainted City regular mob (Act IV, depths 81-84). Once-friendly merchant turned hostile. */
public class HostileMerchant extends Mob {
	{
		name = "hostile merchant";
		HP = HT = 210; defenseSkill = 40; EXP = 24; maxLvl = 34;
		spriteClass = ShopkeeperSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 30, 50 ); }
	@Override public int attackSkill( Char target ) { return 44; }
	@Override public int dr() { return 10; }
	@Override public String defenseVerb() { return "appraised"; }
	@Override public String description() {
		return
			"The shopkeepers of the upper City have moved down to the Tainted " +
			"levels. They no longer bargain. They settle accounts.";
	}
}
