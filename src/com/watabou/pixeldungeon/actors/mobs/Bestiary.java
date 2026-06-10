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
package com.watabou.pixeldungeon.actors.mobs;

import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.mobs.Yog.BurningFist;
import com.watabou.pixeldungeon.actors.mobs.Yog.RottingFist;
import com.watabou.utils.Random;

public class Bestiary {

	public static Mob mob( int depth ) {
		@SuppressWarnings("unchecked")
		Class<? extends Mob> cl = (Class<? extends Mob>)mobClass( depth );
		try {
			return cl.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Mob mutable( int depth ) {
		@SuppressWarnings("unchecked")
		Class<? extends Mob> cl = (Class<? extends Mob>)mobClass( depth );
		
		if (Random.Int( 30 ) == 0) {
			if (cl == Rat.class) {
				cl = Albino.class;
			} else if (cl == Thief.class) {
				cl = Bandit.class;
			} else if (cl == Brute.class) {
				cl = Shielded.class;
			} else if (cl == Monk.class) {
				cl = Senior.class;
			} else if (cl == Scorpio.class) {
				cl = Acidic.class;
			}
		}
		
		try {
			return cl.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	private static Class<?> mobClass( int depth ) {
		
		float[] chances;
		Class<?>[] classes;
		
		switch (depth) {
		case 1:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ Rat.class };
			break;
		case 2:
			chances = new float[]{ 1, 1 };
			classes = new Class<?>[]{ Rat.class, Gnoll.class };
			break;
		case 3:
			chances = new float[]{ 1, 2, 1,   0.02f };
			classes = new Class<?>[]{ Rat.class, Gnoll.class, Crab.class,   Swarm.class };
			break;
		case 4:
			chances = new float[]{ 1, 2, 3,   0.02f, 0.01f, 0.01f };
			classes = new Class<?>[]{ Rat.class, Gnoll.class, Crab.class,   Swarm.class, Skeleton.class, Thief.class };
			break;
			
		case 5:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ Goo.class };
			break;
			
		case 6:
			chances = new float[]{ 4, 2, 1,   0.2f };
			classes = new Class<?>[]{ Skeleton.class, Thief.class, Swarm.class,   Shaman.class };
			break;
		case 7:
			chances = new float[]{ 3, 1, 1, 1 };
			classes = new Class<?>[]{ Skeleton.class, Shaman.class, Thief.class, Swarm.class };
			break;
		case 8:
			chances = new float[]{ 3, 2, 1, 1, 1,   0.02f };
			classes = new Class<?>[]{ Skeleton.class, Shaman.class, Gnoll.class, Thief.class, Swarm.class,   Bat.class };
			break;
		case 9:
			chances = new float[]{ 3, 3, 1, 1,   0.02f, 0.01f };
			classes = new Class<?>[]{ Skeleton.class, Shaman.class, Thief.class, Swarm.class,   Bat.class, Brute.class };
			break;
			
		case 10:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ Tengu.class };
			break;
			
		case 11:
			chances = new float[]{ 1,   0.2f };
			classes = new Class<?>[]{ Bat.class,   Brute.class };
			break;
		case 12:
			chances = new float[]{ 1, 1,   0.2f };
			classes = new Class<?>[]{ Bat.class, Brute.class,   Spinner.class };
			break;
		case 13:
			chances = new float[]{ 1, 3, 1, 1,   0.02f };
			classes = new Class<?>[]{ Bat.class, Brute.class, Shaman.class, Spinner.class,    Elemental.class };
			break;
		case 14:
			chances = new float[]{ 1, 3, 1, 4,    0.02f, 0.01f };
			classes = new Class<?>[]{ Bat.class, Brute.class, Shaman.class, Spinner.class,    Elemental.class, Monk.class };
			break;
			
		case 15:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ DM300.class };
			break;
			
		case 16:
			chances = new float[]{ 1, 1,   0.2f };
			classes = new Class<?>[]{ Elemental.class, Warlock.class,    Monk.class };
			break;
		case 17:
			chances = new float[]{ 1, 1, 1 };
			classes = new Class<?>[]{ Elemental.class, Monk.class, Warlock.class };
			break;
		case 18:
			chances = new float[]{ 1, 2, 1, 1 };
			classes = new Class<?>[]{ Elemental.class, Monk.class, Golem.class, Warlock.class };
			break;
		case 19:
			chances = new float[]{ 1, 2, 3, 1,    0.02f };
			classes = new Class<?>[]{ Elemental.class, Monk.class, Golem.class, Warlock.class,    Succubus.class };
			break;
			
		case 20:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ King.class };
			break;
			
		case 22:
			chances = new float[]{ 1, 1 };
			classes = new Class<?>[]{ Succubus.class, Eye.class };
			break;
		case 23:
			chances = new float[]{ 1, 2, 1 };
			classes = new Class<?>[]{ Succubus.class, Eye.class, Scorpio.class };
			break;
		case 24:
			chances = new float[]{ 1, 2, 3 };
			classes = new Class<?>[]{ Succubus.class, Eye.class, Scorpio.class };
			break;
			
		case 25:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ Yog.class };
			break;

		// --- Forge zone (Act II, depths 26-30) ---
		case 26:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ LavaImp.class, MoltenGolem.class };
			break;
		case 27:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ LavaImp.class, MoltenGolem.class };
			break;
		case 28:
			chances = new float[]{ 1, 2 };
			classes = new Class<?>[]{ LavaImp.class, MoltenGolem.class };
			break;
		case 29:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ LavaImp.class, MoltenGolem.class };
			break;

		case 30:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ FurnaceKing.class };
			break;

		// --- Crypt zone (Act II, depths 31-35) ---
		case 31:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ GhoulRaiser.class, CursedBat.class };
			break;
		case 32:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ GhoulRaiser.class, CursedBat.class };
			break;
		case 33:
			chances = new float[]{ 1, 2 };
			classes = new Class<?>[]{ GhoulRaiser.class, CursedBat.class };
			break;
		case 34:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ GhoulRaiser.class, CursedBat.class };
			break;
		case 35:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ TheLich.class };
			break;

		// --- Library zone (Act II, depths 36-40) ---
		case 36:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ PaperGolem.class, InkSpinner.class };
			break;
		case 37:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ PaperGolem.class, InkSpinner.class };
			break;
		case 38:
			chances = new float[]{ 1, 2 };
			classes = new Class<?>[]{ PaperGolem.class, InkSpinner.class };
			break;
		case 39:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ PaperGolem.class, InkSpinner.class };
			break;
		case 40:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ WhisperingTome.class };
			break;

		// --- Garden zone (Act II, depths 41-45) ---
		case 41:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ RotShaman.class, SporeSwarm.class };
			break;
		case 42:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ RotShaman.class, SporeSwarm.class };
			break;
		case 43:
			chances = new float[]{ 1, 2 };
			classes = new Class<?>[]{ RotShaman.class, SporeSwarm.class };
			break;
		case 44:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ RotShaman.class, SporeSwarm.class };
			break;
		case 45:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ VerdantHeart.class };
			break;

		// --- Vault zone (Act II, depths 46-50) ---
		case 46:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ GoldGuardian.class, GildedEye.class };
			break;
		case 47:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ GoldGuardian.class, GildedEye.class };
			break;
		case 48:
			chances = new float[]{ 1, 2 };
			classes = new Class<?>[]{ GoldGuardian.class, GildedEye.class };
			break;
		case 49:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ GoldGuardian.class, GildedEye.class };
			break;
		case 50:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ TheGoldsmith.class };
			break;

		// --- Mirror Halls (Act III, depths 51-55) ---
		case 51:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ MirrorWalker.class, ReflectedSentinel.class };
			break;
		case 52:
		case 53:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ MirrorWalker.class, ReflectedSentinel.class };
			break;
		case 54:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ MirrorWalker.class, ReflectedSentinel.class };
			break;
		case 55:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ MirrorSelf.class };
			break;

		// --- Gravity Wells (Act III, depths 56-60) ---
		case 56:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ WellGuard.class, GravitySpinner.class };
			break;
		case 57:
		case 58:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ WellGuard.class, GravitySpinner.class };
			break;
		case 59:
			chances = new float[]{ 3, 1 };
			classes = new Class<?>[]{ WellGuard.class, GravitySpinner.class };
			break;
		case 60:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ ThePull.class };
			break;

		// --- Time Loop (Act III, depths 61-65) ---
		case 61:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ ChronoEcho.class, PastReflection.class };
			break;
		case 62:
		case 63:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ ChronoEcho.class, PastReflection.class };
			break;
		case 64:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ ChronoEcho.class, PastReflection.class };
			break;
		case 65:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ TheWatcher.class };
			break;

		// --- Echo Chambers (Act III, depths 66-70) ---
		case 66:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ EchoStalker.class, ResonantSwarm.class };
			break;
		case 67:
		case 68:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ EchoStalker.class, ResonantSwarm.class };
			break;
		case 69:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ EchoStalker.class, ResonantSwarm.class };
			break;
		case 70:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ TheResonance.class };
			break;

		// --- Void Reach (Act III, depths 71-75) ---
		case 71:
			chances = new float[]{ 2, 1 };
			classes = new Class<?>[]{ VoidWraith.class, StarvedEye.class };
			break;
		case 72:
		case 73:
			chances = new float[]{ 2, 2 };
			classes = new Class<?>[]{ VoidWraith.class, StarvedEye.class };
			break;
		case 74:
			chances = new float[]{ 1, 3 };
			classes = new Class<?>[]{ VoidWraith.class, StarvedEye.class };
			break;
		case 75:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ TheEater.class };
			break;

		default:
			chances = new float[]{ 1 };
			classes = new Class<?>[]{ Eye.class };
		}
		
		return classes[ Random.chances( chances )];
	}
	
	public static boolean isBoss( Char mob ) {
		return
			mob instanceof Goo ||
			mob instanceof Tengu ||
			mob instanceof DM300 ||
			mob instanceof King ||
			mob instanceof Yog || mob instanceof BurningFist || mob instanceof RottingFist ||
			mob instanceof FurnaceKing ||
			mob instanceof TheLich ||
			mob instanceof WhisperingTome ||
			mob instanceof VerdantHeart ||
			mob instanceof TheGoldsmith ||
			mob instanceof MirrorSelf ||
			mob instanceof ThePull ||
			mob instanceof TheWatcher ||
			mob instanceof TheResonance ||
			mob instanceof TheEater;
	}
}
