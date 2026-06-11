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
package com.watabou.gltextures;

import com.badlogic.gdx.graphics.Pixmap;

/** 1D gradient texture, ported from the original android.graphics version to Pixmap. */
public class Gradient extends SmartTexture {

	public Gradient( int colors[] ) {

		super( create( colors ) );

		filter( LINEAR, LINEAR );
		wrap( CLAMP, CLAMP );

		TextureCache.add( Gradient.class, this );
	}

	private static Pixmap create( int[] colors ) {
		Pixmap bmp = new Pixmap( colors.length, 1, Pixmap.Format.RGBA8888 );
		for (int i = 0; i < colors.length; i++) {
			// ARGB -> RGBA
			int c = colors[i];
			bmp.drawPixel( i, 0, (c << 8) | (c >>> 24) );
		}
		return bmp;
	}
}
