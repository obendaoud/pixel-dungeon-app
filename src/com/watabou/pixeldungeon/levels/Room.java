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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import com.watabou.pixeldungeon.PixelDungeon;
import com.watabou.pixeldungeon.levels.painters.*;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.Graph;
import com.watabou.utils.Point;
import com.watabou.utils.Random;
import com.watabou.utils.Rect;

public class Room extends Rect implements Graph.Node, Bundlable {
	
	public HashSet<Room> neigbours = new HashSet<Room>();
	public HashMap<Room, Door> connected = new HashMap<Room, Door>();
	
	public int distance;
	public int price = 1;
	
	public static enum Type {
		NULL,
		STANDARD,
		ENTRANCE,
		EXIT,
		BOSS_EXIT,
		TUNNEL,
		PASSAGE,
		SHOP,
		BLACKSMITH,
		TREASURY,
		ARMORY,
		LIBRARY,
		LABORATORY,
		VAULT,
		TRAPS,
		STORAGE,
		MAGIC_WELL,
		GARDEN,
		CRYPT,
		STATUE,
		POOL,
		RAT_KING,
		WEAK_FLOOR,
		PIT,
		ALTAR;

		// Direct dispatch instead of the original reflective Method.invoke on
		// each painter's static paint(): TeaVM (the web backend) cannot
		// reliably trigger a class's static initializer when its only entry
		// point is a reflective static-method call, which broke level
		// generation in the browser ("$callClinit is not defined"). A plain
		// switch works on every backend and is faster everywhere.
		public void paint( Level level, Room room ) {
			switch (this) {
			case STANDARD:   StandardPainter.paint( level, room );   break;
			case ENTRANCE:   EntrancePainter.paint( level, room );   break;
			case EXIT:       ExitPainter.paint( level, room );       break;
			case BOSS_EXIT:  BossExitPainter.paint( level, room );   break;
			case TUNNEL:     TunnelPainter.paint( level, room );     break;
			case PASSAGE:    PassagePainter.paint( level, room );    break;
			case SHOP:       ShopPainter.paint( level, room );       break;
			case BLACKSMITH: BlacksmithPainter.paint( level, room ); break;
			case TREASURY:   TreasuryPainter.paint( level, room );   break;
			case ARMORY:     ArmoryPainter.paint( level, room );     break;
			case LIBRARY:    LibraryPainter.paint( level, room );    break;
			case LABORATORY: LaboratoryPainter.paint( level, room ); break;
			case VAULT:      VaultPainter.paint( level, room );      break;
			case TRAPS:      TrapsPainter.paint( level, room );      break;
			case STORAGE:    StoragePainter.paint( level, room );    break;
			case MAGIC_WELL: MagicWellPainter.paint( level, room );  break;
			case GARDEN:     GardenPainter.paint( level, room );     break;
			case CRYPT:      CryptPainter.paint( level, room );      break;
			case STATUE:     StatuePainter.paint( level, room );     break;
			case POOL:       PoolPainter.paint( level, room );       break;
			case RAT_KING:   RatKingPainter.paint( level, room );    break;
			case WEAK_FLOOR: WeakFloorPainter.paint( level, room );  break;
			case PIT:        PitPainter.paint( level, room );        break;
			case ALTAR:      AltarPainter.paint( level, room );      break;
			default:
				// NULL and any future type without a painter
				break;
			}
		}
	};
	
	public static final ArrayList<Type> SPECIALS = new ArrayList<Type>( Arrays.asList(
		Type.ARMORY, Type.WEAK_FLOOR, Type.MAGIC_WELL, Type.CRYPT, Type.POOL, Type.GARDEN, Type.LIBRARY,
		Type.TREASURY, Type.TRAPS, Type.STORAGE, Type.STATUE, Type.LABORATORY, Type.VAULT, Type.ALTAR
	) );
	
	public Type type = Type.NULL;
	
	public int random() {
		return random( 0 );
	}
	
	public int random( int m ) {
		int x = Random.Int( left + 1 + m, right - m );
		int y = Random.Int( top + 1 + m, bottom - m );
		return x + y * Level.WIDTH;
	}
	
	public void addNeigbour( Room other ) {
		
		Rect i = intersect( other );
		if ((i.width() == 0 && i.height() >= 3) || 
			(i.height() == 0 && i.width() >= 3)) {
			neigbours.add( other );
			other.neigbours.add( this );
		}
		
	}
	
	public void connect( Room room ) {
		if (!connected.containsKey( room )) {	
			connected.put( room, null );
			room.connected.put( this, null );			
		}
	}
	
	public Door entrance() {
		return connected.values().iterator().next();
	}
	
	public boolean inside( int p ) {
		int x = p % Level.WIDTH;
		int y = p / Level.WIDTH;
		return x > left && y > top && x < right && y < bottom;
	}
	
	public Point center() {
		return new Point( 
			(left + right) / 2 + (((right - left) & 1) == 1 ? Random.Int( 2 ) : 0),
			(top + bottom) / 2 + (((bottom - top) & 1) == 1 ? Random.Int( 2 ) : 0) );
	}
	
	// **** Graph.Node interface ****

	@Override
	public int distance() {
		return distance;
	}

	@Override
	public void distance( int value ) {
		distance = value;
	}
	
	@Override
	public int price() {
		return price;
	}

	@Override
	public void price( int value ) {
		price = value;
	}

	@Override
	public Collection<Room> edges() {
		return neigbours;
	} 
	
	// FIXME: use proper string constants
	
	@Override
	public void storeInBundle( Bundle bundle ) {	
		bundle.put( "left", left );
		bundle.put( "top", top );
		bundle.put( "right", right );
		bundle.put( "bottom", bottom );
		bundle.put( "type", type.toString() );
	}
	
	@Override
	public void restoreFromBundle( Bundle bundle ) {
		left = bundle.getInt( "left" );
		top = bundle.getInt( "top" );
		right = bundle.getInt( "right" );
		bottom = bundle.getInt( "bottom" );		
		type = Type.valueOf( bundle.getString( "type" ) );
	}
	
	public static void shuffleTypes() {
		int size = SPECIALS.size();
		for (int i=0; i < size - 1; i++) {
			int j = Random.Int( i, size );
			if (j != i) {
				Type t = SPECIALS.get( i );
				SPECIALS.set( i, SPECIALS.get( j ) );
				SPECIALS.set( j, t );
			}
		}
	}
	
	public static void useType( Type type ) {
		if (SPECIALS.remove( type )) {
			SPECIALS.add( type );
		}
	}
	
	private static final String ROOMS	= "rooms";
	
	public static void restoreRoomsFromBundle( Bundle bundle ) {
		if (bundle.contains( ROOMS )) {
			SPECIALS.clear();
			for (String type : bundle.getStringArray( ROOMS )) {
				SPECIALS.add( Type.valueOf( type ));
			}
		} else {
			shuffleTypes();
		}
	}
	
	public static void storeRoomsInBundle( Bundle bundle ) {
		String[] array = new String[SPECIALS.size()];
		for (int i=0; i < array.length; i++) {
			array[i] = SPECIALS.get( i ).toString();
		}
		bundle.put( ROOMS, array );
	}
	
	public static class Door extends Point {
		
		public static enum Type {
			EMPTY, TUNNEL, REGULAR, UNLOCKED, HIDDEN, BARRICADE, LOCKED
		}
		public Type type = Type.EMPTY;
		
		public Door( int x, int y ) {
			super( x, y );
		}
		
		public void set( Type type ) {
			if (type.compareTo( this.type ) > 0) {
				this.type = type;
			}
		}
	}
}
