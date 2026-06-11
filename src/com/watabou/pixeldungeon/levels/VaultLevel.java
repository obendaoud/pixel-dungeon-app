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

/** Vault zone regular level (Act II, depths 46-49). City tileset placeholder. */
public class VaultLevel extends RegularLevel {

	{
		color1 = 0x6b4f1c;
		color2 = 0xf2c14e;

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
		return Patch.generate( feeling == Feeling.WATER ? 0.30f : 0.10f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.15f : 0.05f, 3 );
	}

	@Override
	protected void decorate() {

		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 5 ) == 0) {
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
			return "Tarnished gold dust";
		case Terrain.HIGH_GRASS:
			return "Heap of coins reaching the ceiling";
		case Terrain.WATER:
			return "Molten gold runoff";
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
			return "The stairs lead down deeper into the Vault.";
		case Terrain.WALL_DECO:
			return "An ornamental gold inlay traces the wall in a closed pattern.";
		default:
			return super.tileDesc( tile );
		}
	}
}
