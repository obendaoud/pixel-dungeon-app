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
package com.watabou.pixeldungeon.web;

import com.badlogic.gdx.Files;
import com.github.xpenatan.gdx.backends.teavm.TeaApplication;
import com.github.xpenatan.gdx.backends.teavm.TeaApplicationConfiguration;
import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.utils.FileUtils;

/** Browser entry point. Invoked by the bundled index.html. */
public class WebLauncher {

	public static void main( String[] args ) {
		TeaApplicationConfiguration config = new TeaApplicationConfiguration( "canvas" );
		config.width = 0;
		config.height = 0;
		config.showDownloadLogs = true;
		config.useGL30 = false;
		config.storagePrefix = "pixel-dungeon-100";

		// Saves / badges / rankings live in browser storage, which gdx-teavm
		// maps to the Local file type.
		FileUtils.setDefaultFileProperties( Files.FileType.Local, "" );

		new TeaApplication( new PixelDungeon( new WebPlatformSupport() ), config );
	}
}
