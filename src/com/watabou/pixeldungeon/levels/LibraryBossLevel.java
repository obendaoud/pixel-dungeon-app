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
package com.watabou.pixeldungeon.levels;

import com.watabou.pixeldungeon.Assets;

/** Library boss arena (Act II, depth 40). Hosts {@code WhisperingTome}. */
public class LibraryBossLevel extends BossArenaLevel {

	{
		color1 = 0x4b3a2a;
		color2 = 0xc9a96e;

		viewDistance = 6;
	}

	@Override
	public String tilesTex() {
		return Assets.TILES_CITY;
	}

	@Override
	public String waterTex() {
		return Assets.WATER_CITY;
	}

	protected boolean[] water() {
		return Patch.generate( 0.25f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( 0.10f, 3 );
	}

	@Override
	public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER:
			return "Pool of spilled ink";
		default:
			return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.WALL_DECO:
			return "The wall is plastered with overlapping pages, edges fluttering even in still air.";
		default:
			return super.tileDesc( tile );
		}
	}
}
