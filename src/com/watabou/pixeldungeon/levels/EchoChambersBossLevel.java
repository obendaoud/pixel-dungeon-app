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

/** Echo Chambers boss arena (Act III, depth 70). Hosts {@code TheResonance}. */
public class EchoChambersBossLevel extends BossArenaLevel {
	{
		color1 = 0x2a2230; color2 = 0x9a6cb0; viewDistance = 4;
	}
	@Override public String tilesTex() { return Assets.TILES_CAVES; }
	@Override public String waterTex() { return Assets.WATER_CAVES; }

	protected boolean[] water() { return Patch.generate( 0.30f, 5 ); }
	protected boolean[] grass() { return Patch.generate( 0.10f, 3 ); }

	@Override public String tileName( int tile ) {
		if (tile == Terrain.WATER) return "Pool of resonance";
		return super.tileName( tile );
	}
}
