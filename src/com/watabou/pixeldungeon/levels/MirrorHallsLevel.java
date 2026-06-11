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

/** Mirror Halls regular level (Act III, depths 51-54). Halls tileset placeholder. */
public class MirrorHallsLevel extends RegularLevel {

	{
		color1 = 0x3a4456;
		color2 = 0xc6cdd8;

		viewDistance = 6;
	}

	@Override public String tilesTex() { return Assets.TILES_HALLS; }
	@Override public String waterTex() { return Assets.WATER_HALLS; }

	protected boolean[] water() {
		return Patch.generate( feeling == Feeling.WATER ? 0.40f : 0.18f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.20f : 0.05f, 3 );
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
			if (pos != entrance) { map[pos] = Terrain.SIGN; break; }
		}
	}

	@Override public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER: return "Quicksilver pool";
		case Terrain.HIGH_GRASS: return "Cracked glass thicket";
		default: return super.tileName( tile );
		}
	}

	@Override public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.WALL_DECO:
			return "A panel of polished silver, showing only what is not there.";
		default: return super.tileDesc( tile );
		}
	}
}
