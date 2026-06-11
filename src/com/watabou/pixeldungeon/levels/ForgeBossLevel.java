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

import java.util.List;

import com.watabou.noosa.Scene;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.Bones;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.Actor;
import com.watabou.pixeldungeon.actors.mobs.Bestiary;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.items.Heap;
import com.watabou.pixeldungeon.items.Item;
import com.watabou.pixeldungeon.levels.Room.Type;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.utils.Bundle;
import com.watabou.utils.Graph;
import com.watabou.utils.Random;

/**
 * Boss arena for the Forge zone (Act II), encountered at depth 30.
 *
 * Structure modeled after {@link SewerBossLevel}: a regular layout reduced to
 * an entrance room and a larger boss room, with a seal/unseal mechanism that
 * locks the entrance once the player engages the {@link
 * com.watabou.pixeldungeon.actors.mobs.FurnaceKing}.
 */
public class ForgeBossLevel extends RegularLevel {

	{
		color1 = 0x6b3a1a;
		color2 = 0xe57b1f;

		viewDistance = 5;
	}

	private int stairs = 0;

	@Override
	public String tilesTex() {
		return Assets.TILES_CAVES;
	}

	@Override
	public String waterTex() {
		return Assets.WATER_CAVES;
	}

	@Override
	protected boolean build() {

		initRooms();

		int distance;
		int retry = 0;
		int minDistance = (int)Math.sqrt( rooms.size() );
		do {
			int innerRetry = 0;
			do {
				if (innerRetry++ > 10) {
					return false;
				}
				roomEntrance = Random.element( rooms );
			} while (roomEntrance.width() < 4 || roomEntrance.height() < 4);

			innerRetry = 0;
			do {
				if (innerRetry++ > 10) {
					return false;
				}
				roomExit = Random.element( rooms );
			} while (roomExit == roomEntrance || roomExit.width() < 6 || roomExit.height() < 6 || roomExit.top == 0);

			Graph.buildDistanceMap( rooms, roomExit );
			distance = roomEntrance.distance();

			if (retry++ > 10) {
				return false;
			}

		} while (distance < minDistance);

		roomEntrance.type = Type.ENTRANCE;
		roomExit.type = Type.BOSS_EXIT;

		Graph.buildDistanceMap( rooms, roomExit );
		List<Room> path = Graph.buildPath( rooms, roomEntrance, roomExit );

		Graph.setPrice( path, roomEntrance.distance );

		Graph.buildDistanceMap( rooms, roomExit );
		path = Graph.buildPath( rooms, roomEntrance, roomExit );

		Room room = roomEntrance;
		for (Room next : path) {
			room.connect( next );
			room = next;
		}

		room = (Room)roomExit.connected.keySet().toArray()[0];
		if (roomExit.top == room.bottom) {
			return false;
		}

		for (Room r : rooms) {
			if (r.type == Type.NULL && r.connected.size() > 0) {
				r.type = Type.TUNNEL;
			}
		}

		paint();

		paintWater();
		paintGrass();

		placeTraps();

		return true;
	}

	protected boolean[] water() {
		return Patch.generate( 0.40f, 5 );
	}

	protected boolean[] grass() {
		return Patch.generate( 0.20f, 3 );
	}

	@Override
	protected void decorate() {
		while (true) {
			int pos = roomEntrance.random();
			if (pos != entrance) {
				map[pos] = Terrain.SIGN;
				break;
			}
		}
	}

	@Override
	public void addVisuals( Scene scene ) {
		super.addVisuals( scene );
		CavesLevel.addVisuals( this, scene );
	}

	@Override
	protected void createMobs() {
		Mob mob = Bestiary.mob( Dungeon.depth );
		mob.pos = roomExit.random();
		mobs.add( mob );
	}

	public Actor respawner() {
		return null;
	}

	@Override
	protected void createItems() {
		Item item = Bones.get();
		if (item != null) {
			int pos;
			do {
				pos = roomEntrance.random();
			} while (pos == entrance || map[pos] == Terrain.SIGN);
			drop( item, pos ).type = Heap.Type.SKELETON;
		}
	}

	public void seal() {
		if (entrance != 0) {

			set( entrance, Terrain.WATER_TILES );
			GameScene.updateMap( entrance );
			GameScene.ripple( entrance );

			stairs = entrance;
			entrance = 0;
		}
	}

	public void unseal() {
		if (stairs != 0) {

			entrance = stairs;
			stairs = 0;

			set( entrance, Terrain.ENTRANCE );
			GameScene.updateMap( entrance );
		}
	}

	private static final String STAIRS = "stairs";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( STAIRS, stairs );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		stairs = bundle.getInt( STAIRS );
	}

	@Override
	public String tileName( int tile ) {
		switch (tile) {
		case Terrain.WATER:
			return "Pool of slag";
		default:
			return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc( int tile ) {
		switch (tile) {
		case Terrain.EMPTY_DECO:
			return "Soot has settled over the stone floor.";
		case Terrain.WALL_DECO:
			return "A vein of ore glows softly with residual heat.";
		default:
			return super.tileDesc( tile );
		}
	}
}
