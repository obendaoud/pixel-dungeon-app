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

/** Burning Caves regular level (Act IV, depths 86-89). Mirror of Caves. */
public class BurningCavesLevel extends RegularLevel {
	{ color1 = 0x5a1a0a; color2 = 0xf25a1a; viewDistance = 5; }
	@Override public String tilesTex() { return Assets.TILES_CAVES; }
	@Override public String waterTex() { return Assets.WATER_CAVES; }
	protected boolean[] water() { return Patch.generate( feeling == Feeling.WATER ? 0.30f : 0.10f, 5 ); }
	protected boolean[] grass() { return Patch.generate( feeling == Feeling.GRASS ? 0.20f : 0.08f, 3 ); }
	@Override protected void decorate() {
		for (int i = 0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 4 ) == 0) map[i] = Terrain.WALL_DECO;
		}
		while (true) {
			int pos = roomEntrance.random();
			if (pos != entrance) { map[pos] = Terrain.SIGN; break; }
		}
	}
	@Override public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER: return "Stream of liquid fire";
		case Terrain.HIGH_GRASS: return "Wall of perpetual flame";
		default: return super.tileName( tile );
		}
	}
	@Override public String tileDesc( int tile ) {
		if (tile == Terrain.WALL_DECO) return "The cave wall is webbed with cracks that glow from inside.";
		return super.tileDesc( tile );
	}
}
