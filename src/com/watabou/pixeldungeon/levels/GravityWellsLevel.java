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
import com.watabou.utils.Random;

/** Gravity Wells regular level (Act III, depths 56-59). Caves tileset placeholder. */
public class GravityWellsLevel extends RegularLevel {

	{
		color1 = 0x1c2233;
		color2 = 0x5a6f9f;
		viewDistance = 6;
	}

	@Override public String tilesTex() { return Assets.TILES_CAVES; }
	@Override public String waterTex() { return Assets.WATER_CAVES; }

	protected boolean[] water() {
		return Patch.generate( feeling == Feeling.WATER ? 0.45f : 0.20f, 5 );
	}
	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.15f : 0.05f, 3 );
	}

	@Override
	protected void decorate() {
		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 6 ) == 0) {
				map[i] = Terrain.WALL_DECO;
			}
		}
		while (true) {
			int pos = roomEntrance.random();
			if (pos != entrance) { map[pos] = Terrain.SIGN; break; }
		}
	}

	@Override public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER: return "Pool of crushed light";
		case Terrain.HIGH_GRASS: return "Patch of suspended dust";
		default: return super.tileName( tile );
		}
	}

	@Override public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.WALL_DECO:
			return "An indentation in the wall, as though something heavy passed through.";
		default: return super.tileDesc( tile );
		}
	}
}
