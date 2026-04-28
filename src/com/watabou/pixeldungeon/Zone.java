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

import com.watabou.pixeldungeon.levels.Level;

/**
 * Immutable description of a dungeon zone (a contiguous range of depths sharing
 * a theme). Subclasses provide the {@link #createLevel(int)} factory.
 *
 * The depth range is inclusive on both ends. {@link #bossDepth} must be inside
 * the range (or equal to {@link #NO_BOSS} when the zone has no boss floor).
 */
public abstract class Zone {

	public static final int NO_BOSS = -1;

	public final String  id;
	public final Act     act;
	public final int     firstDepth;
	public final int     lastDepth;
	public final int     bossDepth;
	public final boolean shopOnFirstFloor;

	protected Zone( String id, Act act,
	                int firstDepth, int lastDepth,
	                int bossDepth, boolean shopOnFirstFloor ) {

		this.id               = id;
		this.act              = act;
		this.firstDepth       = firstDepth;
		this.lastDepth        = lastDepth;
		this.bossDepth        = bossDepth;
		this.shopOnFirstFloor = shopOnFirstFloor;
	}

	public boolean contains( int depth ) {
		return depth >= firstDepth && depth <= lastDepth;
	}

	public boolean isBossDepth( int depth ) {
		return bossDepth != NO_BOSS && depth == bossDepth;
	}

	/**
	 * Builds the {@link Level} instance for {@code depth}. Implementations
	 * decide whether to return a regular or boss level by checking against
	 * {@link #bossDepth}.
	 */
	public abstract Level createLevel( int depth );
}
