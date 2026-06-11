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
package com.watabou.pixeldungeon;

import com.watabou.pixeldungeon.levels.CavesBossLevel;
import com.watabou.pixeldungeon.levels.CavesLevel;
import com.watabou.pixeldungeon.levels.CityBossLevel;
import com.watabou.pixeldungeon.levels.CityLevel;
import com.watabou.pixeldungeon.levels.DeadEndLevel;
import com.watabou.pixeldungeon.levels.HallsBossLevel;
import com.watabou.pixeldungeon.levels.HallsLevel;
import com.watabou.pixeldungeon.levels.LastLevel;
import com.watabou.pixeldungeon.levels.LastShopLevel;
import com.watabou.pixeldungeon.levels.Level;
import com.watabou.pixeldungeon.levels.PrisonBossLevel;
import com.watabou.pixeldungeon.levels.PrisonLevel;
import com.watabou.pixeldungeon.levels.SewerBossLevel;
import com.watabou.pixeldungeon.levels.SewerLevel;

/**
 * Central registry of dungeon zones and the depth-to-level dispatcher.
 *
 * Every numbered floor depth resolves through {@link #levelForDepth(int)}.
 * The dispatcher first checks for utility floors (currently the LastShop at
 * depth 21 and the LastLevel at depth 26), then walks the zone table.
 *
 * Out-of-range depths produce a {@link DeadEndLevel}.
 */
public final class Zones {

	private Zones() {}

	public static final int LAST_SHOP_DEPTH = 21;
	public static final int LAST_LEVEL_DEPTH = 26;

	private static final Zone SEWERS = new Zone(
			"sewers", Act.ONE, 1, 5, 5, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new SewerBossLevel() : new SewerLevel();
		}
	};

	private static final Zone PRISON = new Zone(
			"prison", Act.ONE, 6, 10, 10, true ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new PrisonBossLevel() : new PrisonLevel();
		}
	};

	private static final Zone CAVES = new Zone(
			"caves", Act.ONE, 11, 15, 15, true ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new CavesBossLevel() : new CavesLevel();
		}
	};

	private static final Zone CITY = new Zone(
			"city", Act.ONE, 16, 20, 20, true ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new CityBossLevel() : new CityLevel();
		}
	};

	private static final Zone HALLS = new Zone(
			"halls", Act.ONE, 22, 25, 25, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new HallsBossLevel() : new HallsLevel();
		}
	};

	private static final Zone[] ALL = { SEWERS, PRISON, CAVES, CITY, HALLS };

	public static Zone forDepth( int depth ) {
		for (Zone z : ALL) {
			if (z.contains( depth )) {
				return z;
			}
		}
		return null;
	}

	public static boolean isOutOfRange( int depth ) {
		return depth < 1 || depth > LAST_LEVEL_DEPTH;
	}

	public static Level levelForDepth( int depth ) {
		if (depth == LAST_SHOP_DEPTH) {
			return new LastShopLevel();
		}
		if (depth == LAST_LEVEL_DEPTH) {
			return new LastLevel();
		}
		if (isOutOfRange( depth )) {
			return new DeadEndLevel();
		}

		Zone z = forDepth( depth );
		if (z == null) {
			return new DeadEndLevel();
		}
		return z.createLevel( depth );
	}

	public static boolean isBoss( int depth ) {
		Zone z = forDepth( depth );
		return z != null && z.isBossDepth( depth );
	}

	public static boolean hasShop( int depth ) {
		Zone z = forDepth( depth );
		return z != null && z.shopOnFirstFloor && depth == z.firstDepth;
	}
}
