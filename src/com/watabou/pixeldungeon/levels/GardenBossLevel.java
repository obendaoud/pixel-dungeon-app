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

/** Garden boss arena (Act II, depth 45). Hosts {@code VerdantHeart}. */
public class GardenBossLevel extends BossArenaLevel {

	{
		color1 = 0x2f4a1c;
		color2 = 0x88b04b;

		viewDistance = 7;
	}

	@Override
	public String tilesTex() {
		return Assets.TILES_SEWERS;
	}

	@Override
	public String waterTex() {
		return Assets.WATER_SEWERS;
	}

	protected boolean[] water() {
		return Patch.generate( 0.45f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( 0.55f, 4 );
	}

	@Override
	public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER:
			return "Sap-thick stream";
		default:
			return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.WALL_DECO:
			return "Roots grow through the wall, knotting it shut.";
		default:
			return super.tileDesc( tile );
		}
	}
}
