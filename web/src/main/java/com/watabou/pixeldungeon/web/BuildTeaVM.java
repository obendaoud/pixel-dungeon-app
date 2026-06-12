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

import com.github.xpenatan.gdx.backends.teavm.config.AssetFileHandle;
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuildConfiguration;
import com.github.xpenatan.gdx.backends.teavm.config.TeaBuilder;
import com.github.xpenatan.gdx.backends.teavm.config.plugins.TeaReflectionSupplier;
import java.io.File;
import java.io.IOException;
import org.teavm.tooling.TeaVMTool;
import org.teavm.vm.TeaVMOptimizationLevel;

/**
 * Runs TeaVM to compile :web (and its transitive :core / :noosa-gdx) to
 * JavaScript. Output: web/build/dist/{index.html, app.js, assets/}.
 *
 * The game uses reflection on {@link com.watabou.utils.Bundle.Bundlable}
 * subclasses (instantiation by name when loading a save). We register
 * the whole watabou tree so every mob/item/level/buff/blob/plant/heap
 * implementation is reachable at runtime.
 */
public class BuildTeaVM {

	public static void main( String[] args ) throws IOException {

		// Reflection roots
		TeaReflectionSupplier.addReflectionClass( "com.watabou" );
		TeaReflectionSupplier.addReflectionClass( "com.badlogic.gdx.math" );

		TeaBuildConfiguration cfg = new TeaBuildConfiguration();
		cfg.assetsPath.add( new AssetFileHandle( "../assets" ) );
		cfg.webappPath = new File( "build/dist" ).getCanonicalPath();
		cfg.mainClass = WebLauncher.class.getName();
		cfg.htmlTitle = "Pixel Dungeon: 100 Floors";
		cfg.htmlWidth = 960;
		cfg.htmlHeight = 640;

		TeaVMTool tool = TeaBuilder.config( cfg );
		tool.setObfuscated( false );
		tool.setOptimizationLevel( TeaVMOptimizationLevel.SIMPLE );
		tool.setMainClass( WebLauncher.class.getName() );

		TeaBuilder.build( tool );
	}
}
