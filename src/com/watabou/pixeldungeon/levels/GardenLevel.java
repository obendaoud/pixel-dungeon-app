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

/** Garden zone regular level (Act II, depths 41-44). Sewer tileset placeholder. */
public class GardenLevel extends RegularLevel {

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
		return Patch.generate( feeling == Feeling.WATER ? 0.55f : 0.30f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.70f : 0.45f, 4 );
	}

	@Override
	protected void decorate() {

		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.EMPTY && Random.Int( 5 ) == 0) {
				map[i] = Terrain.EMPTY_DECO;
			}
			if (map[i] == Terrain.WALL && Random.Int( 6 ) == 0) {
				map[i] = Terrain.WALL_DECO;
			}
		}

		while (true) {
			int pos = roomEntrance.random();
			if (pos != entrance) {
				map[pos] = Terrain.SIGN;
				break;
			}
		}
	}

	@Override
	public String tileName( int tile ) {
		switch (tile) {
		case Terrain.GRASS:
			return "Choking weeds";
		case Terrain.HIGH_GRASS:
			return "Wall of carnivorous flowers";
		case Terrain.WATER:
			return "Sap-thick stream";
		default:
			return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.ENTRANCE:
			return "The stairs lead up to the upper depth.";
		case Terrain.EXIT:
			return "The stairs lead down deeper into the Garden.";
		case Terrain.WALL_DECO:
			return "Roots grow through the wall stones, knotting them in place.";
		case Terrain.EMPTY_DECO:
			return "A bed of soft moss, dotted with spore caps.";
		default:
			return super.tileDesc( tile );
		}
	}
}
