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
import com.watabou.pixeldungeon.levels.CryptBossLevel;
import com.watabou.pixeldungeon.levels.CryptLevel;
import com.watabou.pixeldungeon.levels.DeadEndLevel;
import com.watabou.pixeldungeon.levels.ForgeBossLevel;
import com.watabou.pixeldungeon.levels.ForgeLevel;
import com.watabou.pixeldungeon.levels.GardenBossLevel;
import com.watabou.pixeldungeon.levels.GardenLevel;
import com.watabou.pixeldungeon.levels.HallsBossLevel;
import com.watabou.pixeldungeon.levels.HallsLevel;
import com.watabou.pixeldungeon.levels.LastShopLevel;
import com.watabou.pixeldungeon.levels.Level;
import com.watabou.pixeldungeon.levels.LibraryBossLevel;
import com.watabou.pixeldungeon.levels.LibraryLevel;
import com.watabou.pixeldungeon.levels.PrisonBossLevel;
import com.watabou.pixeldungeon.levels.PrisonLevel;
import com.watabou.pixeldungeon.levels.SewerBossLevel;
import com.watabou.pixeldungeon.levels.SewerLevel;
import com.watabou.pixeldungeon.levels.VaultBossLevel;
import com.watabou.pixeldungeon.levels.VaultLevel;

/**
 * Central registry of dungeon zones and the depth-to-level dispatcher.
 *
 * Every numbered floor depth resolves through {@link #levelForDepth(int)}.
 * The dispatcher first handles the utility LastShop at depth 21, then walks
 * the zone table.
 *
 * Out-of-range depths (below 1 or beyond every registered zone) produce a
 * {@link DeadEndLevel}.
 *
 * Note (M2): the original LastLevel at depth 26 has been removed from the
 * dispatcher to make room for the Forge zone (26-30). The
 * {@code com.watabou.pixeldungeon.levels.LastLevel} class and the
 * {@code com.watabou.pixeldungeon.items.Amulet} item still exist but are no
 * longer reachable through normal play; the amulet-as-Act-II-trigger
 * rework belongs to a follow-up milestone.
 */
public final class Zones {

	private Zones() {}

	public static final int LAST_SHOP_DEPTH = 21;

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

	private static final Zone FORGE = new Zone(
			"forge", Act.TWO, 26, 30, 30, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new ForgeBossLevel() : new ForgeLevel();
		}
	};

	private static final Zone CRYPT = new Zone(
			"crypt", Act.TWO, 31, 35, 35, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new CryptBossLevel() : new CryptLevel();
		}
	};

	private static final Zone LIBRARY = new Zone(
			"library", Act.TWO, 36, 40, 40, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new LibraryBossLevel() : new LibraryLevel();
		}
	};

	private static final Zone GARDEN = new Zone(
			"garden", Act.TWO, 41, 45, 45, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new GardenBossLevel() : new GardenLevel();
		}
	};

	private static final Zone VAULT = new Zone(
			"vault", Act.TWO, 46, 50, 50, false ) {
		@Override public Level createLevel( int depth ) {
			return isBossDepth( depth ) ? new VaultBossLevel() : new VaultLevel();
		}
	};

	private static final Zone[] ALL = {
			SEWERS, PRISON, CAVES, CITY, HALLS,
			FORGE, CRYPT, LIBRARY, GARDEN, VAULT
	};

	public static Zone forDepth( int depth ) {
		for (Zone z : ALL) {
			if (z.contains( depth )) {
				return z;
			}
		}
		return null;
	}

	public static boolean isOutOfRange( int depth ) {
		if (depth < 1) {
			return true;
		}
		if (depth == LAST_SHOP_DEPTH) {
			return false;
		}
		return forDepth( depth ) == null;
	}

	public static Level levelForDepth( int depth ) {
		if (depth == LAST_SHOP_DEPTH) {
			return new LastShopLevel();
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
