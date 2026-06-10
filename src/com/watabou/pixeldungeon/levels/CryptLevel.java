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

/**
 * Crypt zone regular level (Act II, depths 31-34).
 *
 * Visuals reuse the Halls tileset (tiles4.png) as a placeholder. View
 * distance is reduced to evoke perpetual darkness.
 */
public class CryptLevel extends RegularLevel {

	{
		color1 = 0x2c1c2e;
		color2 = 0x6b4a78;

		viewDistance = 4;
	}

	@Override
	public String tilesTex() {
		return Assets.TILES_HALLS;
	}

	@Override
	public String waterTex() {
		return Assets.WATER_HALLS;
	}

	protected boolean[] water() {
		return Patch.generate( feeling == Feeling.WATER ? 0.45f : 0.20f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.25f : 0.10f, 3 );
	}

	@Override
	protected void decorate() {

		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 8 ) == 0) {
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
			return "Burial moss";
		case Terrain.HIGH_GRASS:
			return "Thicket of grave thorns";
		case Terrain.WATER:
			return "Stagnant black water";
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
			return "The stairs lead down deeper into the Crypt.";
		case Terrain.WALL_DECO:
			return "An engraved name. The carving is worn smooth.";
		case Terrain.BOOKSHELF:
			return "An ossuary niche. Bones are stacked like cordwood.";
		default:
			return super.tileDesc( tile );
		}
	}
}
