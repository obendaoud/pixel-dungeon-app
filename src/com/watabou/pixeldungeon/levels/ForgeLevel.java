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

import com.watabou.noosa.Scene;
import com.watabou.pixeldungeon.Assets;
import com.watabou.utils.Random;

/**
 * Forge zone regular level (Act II, depths 26-29).
 *
 * Implementation notes for M2:
 * - Visuals reuse the Caves tileset (tiles2.png / water2.png) as a placeholder.
 *   A dedicated Forge tileset will replace these in a later milestone.
 * - The {@link com.watabou.pixeldungeon.actors.mobs.npcs.Blacksmith} quest is
 *   intentionally NOT spawned here, so Forge is distinct from Caves narratively.
 * - Tile naming and descriptions are reworked to fit the Forge theme even
 *   though the underlying terrain types are unchanged.
 */
public class ForgeLevel extends RegularLevel {

	{
		// Warmer palette tint for level minimap; visual tiles still use Caves
		// until a dedicated tileset is provided.
		color1 = 0x6b3a1a;
		color2 = 0xe57b1f;

		viewDistance = 5;
	}

	@Override
	public String tilesTex() {
		return Assets.TILES_CAVES;
	}

	@Override
	public String waterTex() {
		return Assets.WATER_CAVES;
	}

	protected boolean[] water() {
		return Patch.generate( feeling == Feeling.WATER ? 0.45f : 0.20f, 5 );
	}

	protected boolean[] grass() {
		// "grass" patches stand in for ember / soot ground until a forge-specific
		// blob is introduced.
		return Patch.generate( feeling == Feeling.GRASS ? 0.30f : 0.15f, 3 );
	}

	@Override
	protected void decorate() {

		for (int i=0; i < LENGTH; i++) {
			if (map[i] == Terrain.WALL && Random.Int( 10 ) == 0) {
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
			return "Smouldering embers";
		case Terrain.HIGH_GRASS:
			return "Dense soot cloud";
		case Terrain.WATER:
			return "Pool of slag";
		default:
			return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.ENTRANCE:
			return "The shaft leads up to the upper depth.";
		case Terrain.EXIT:
			return "The shaft leads down deeper into the Forge.";
		case Terrain.HIGH_GRASS:
			return "Soot hangs in the air thick enough to block your view.";
		case Terrain.WALL_DECO:
			return "A vein of ore glows softly with residual heat.";
		case Terrain.BOOKSHELF:
			return "A rack of half-finished blades and bent ingots.";
		default:
			return super.tileDesc( tile );
		}
	}

	@Override
	public void addVisuals( Scene scene ) {
		super.addVisuals( scene );
		// Reuse the Caves vein sparkle effect on WALL_DECO tiles. Visually
		// passable for now; will be replaced when a Forge ember particle is
		// produced.
		CavesLevel.addVisuals( this, scene );
	}
}
