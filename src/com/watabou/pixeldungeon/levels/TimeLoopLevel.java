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

/** Time Loop regular level (Act III, depths 61-64). Halls tileset placeholder. */
public class TimeLoopLevel extends RegularLevel {

	{
		color1 = 0x1a3a3a;
		color2 = 0x7be0e0;
		viewDistance = 6;
	}

	@Override public String tilesTex() { return Assets.TILES_HALLS; }
	@Override public String waterTex() { return Assets.WATER_HALLS; }

	protected boolean[] water() {
		return Patch.generate( feeling == Feeling.WATER ? 0.40f : 0.18f, 5 );
	}
	protected boolean[] grass() {
		return Patch.generate( feeling == Feeling.GRASS ? 0.20f : 0.08f, 3 );
	}

	@Override
	protected void decorate() {
		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 7 ) == 0) {
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
		case Terrain.WATER: return "Pool of paused water";
		case Terrain.HIGH_GRASS: return "Thicket of frozen leaves";
		default: return super.tileName( tile );
		}
	}

	@Override public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.WALL_DECO:
			return "A clockface set into the wall. The hands are missing.";
		default: return super.tileDesc( tile );
		}
	}
}
