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
package com.watabou.pixeldungeon;

/**
 * High-level grouping of dungeon depths into narrative acts.
 *
 * Currently only ONE is populated with content (depths 1-25, the original
 * Pixel Dungeon zones). TWO, THREE and FOUR are reserved for the 100-floor
 * expansion described in {@code docs/ROADMAP-100-floors.md}.
 */
public enum Act {

	ONE  ( 1,  25),
	TWO  (26,  50),
	THREE(51,  75),
	FOUR (76, 100);

	public final int firstDepth;
	public final int lastDepth;

	Act( int firstDepth, int lastDepth ) {
		this.firstDepth = firstDepth;
		this.lastDepth  = lastDepth;
	}

	public boolean contains( int depth ) {
		return depth >= firstDepth && depth <= lastDepth;
	}

	/**
	 * Returns the act containing {@code depth}, or {@code null} if the depth
	 * falls outside every act range.
	 */
	public static Act forDepth( int depth ) {
		for (Act a : values()) {
			if (a.contains( depth )) {
				return a;
			}
		}
		return null;
	}
}
