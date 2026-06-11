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
package com.watabou.noosa;

import com.watabou.input.PointerEvent;
import com.watabou.input.Touchscreen.Touch;

/**
 * Compatibility bridge restoring the original TouchArea API on top of the
 * vendored {@link PointerArea}. Legacy game code overrides the
 * Touch-flavoured callbacks; new code should use PointerArea directly.
 */
public class TouchArea extends PointerArea {

	protected Touch touch = null;

	public TouchArea( Visual target ) {
		super( target );
	}

	public TouchArea( float x, float y, float width, float height ) {
		super( x, y, width, height );
	}

	@Override
	protected void onPointerDown( PointerEvent event ) {
		touch = new Touch( event );
		onTouchDown( touch );
	}

	@Override
	protected void onPointerUp( PointerEvent event ) {
		Touch t = touch != null ? touch : new Touch( event );
		touch = null;
		onTouchUp( t );
	}

	@Override
	protected void onClick( PointerEvent event ) {
		onClick( touch != null ? touch : new Touch( event ) );
	}

	@Override
	protected void onDrag( PointerEvent event ) {
		Touch t = touch != null ? touch : new Touch( event );
		t.current = event.current;
		onDrag( t );
	}

	protected void onTouchDown( Touch touch ) { }
	protected void onTouchUp( Touch touch ) { }
	protected void onClick( Touch touch ) { }
	protected void onDrag( Touch touch ) { }
}
