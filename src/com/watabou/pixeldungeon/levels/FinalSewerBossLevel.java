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

/**
 * Final Sewer boss arena (Act IV, depth 100). Hosts {@code TheFirstGoo}.
 *
 * M6 ships the arena with a placeholder boss. M7 will replace the boss
 * with the proper run-ending confrontation and wire up the ending
 * cinematic.
 */
public class FinalSewerBossLevel extends BossArenaLevel {
	{ color1 = 0x102818; color2 = 0x2e5a3a; viewDistance = 6; }
	@Override public String tilesTex() { return Assets.TILES_SEWERS; }
	@Override public String waterTex() { return Assets.WATER_SEWERS; }
	protected boolean[] water() { return Patch.generate( 0.40f, 5 ); }
	protected boolean[] grass() { return Patch.generate( 0.20f, 3 ); }
}
