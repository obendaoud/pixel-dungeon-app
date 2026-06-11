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
package com.watabou.input;

import com.watabou.utils.PointF;

/**
 * Compatibility bridge for the original 2012-era input API. The vendored
 * noosa-gdx replaced Touchscreen with {@link PointerEvent}; this shim keeps
 * the legacy {@code Touchscreen.Touch} type alive for game code that still
 * declares callbacks in terms of it (via {@link com.watabou.noosa.TouchArea}).
 */
public class Touchscreen {

	public static class Touch {

		public PointF start;
		public PointF current;
		public boolean down;

		public Touch( PointerEvent event ) {
			start = event.start;
			current = event.current;
			down = event.type == PointerEvent.Type.DOWN;
		}
	}
}
