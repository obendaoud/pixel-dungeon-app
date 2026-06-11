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
package com.watabou.pixeldungeon.desktop;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.watabou.utils.PlatformSupport;

/**
 * Minimal desktop PlatformSupport. The game renders text through the legacy
 * BitmapText fonts (font1x.png etc.), not FreeType, so the font-generator
 * hooks are inert stubs.
 */
public class DesktopPlatformSupport extends PlatformSupport {

	@Override
	public void updateDisplaySize() {
		// Window size persistence is a later polish task.
	}

	@Override
	public void updateSystemUI() {
		// No system chrome to manage on desktop yet (no fullscreen toggle).
	}

	@Override
	public boolean connectedToUnmeteredNetwork() {
		return true;
	}

	@Override
	public boolean supportsVibration() {
		return false;
	}

	@Override
	public void setupFontGenerators( int pageSize, boolean systemFont ) {
		// BitmapText fonts only; FreeType unused.
	}

	@Override
	protected FreeTypeFontGenerator getGeneratorForString( String input ) {
		return null;
	}

	@Override
	public String[] splitforTextBlock( String text, boolean multiline ) {
		return multiline ? text.split( "\\r?\\n" ) : new String[]{ text };
	}
}
