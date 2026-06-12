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

		// TeaVM's default uncaught-exception handler calls printStackTrace
		// on the throwable, and the stdlib StringBuilder.append path can
		// itself NPE on null-valued stack frames or messages, producing the
		// confusing "Cannot read properties of undefined (reading '$toString')"
		// that masks the actual error. Install a defensive handler before
		// any other code so root causes always surface.
		Thread.setDefaultUncaughtExceptionHandler( ( t, e ) -> {
			Throwable cur = e;
			int depth = 0;
			while (cur != null && depth < 8) {
				String prefix = depth == 0 ? "UNCAUGHT" : "  caused by";
				try {
					System.err.println( prefix + ": " + cur.getClass().getName() );
				} catch (Throwable ignored) { }
				try {
					String m = cur.getMessage();
					if (m != null) System.err.println( "  message: " + m );
				} catch (Throwable ignored) { }
				try {
					StackTraceElement[] st = cur.getStackTrace();
					if (st != null) {
						for (StackTraceElement el : st) {
							if (el != null) {
								try { System.err.println( "    at " + el.toString() ); }
								catch (Throwable ignored) { }
							}
						}
					}
				} catch (Throwable ignored) { }
				cur = cur.getCause();
				depth++;
			}
		} );

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
