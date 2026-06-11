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
package com.watabou.pixeldungeon;

/**
 * Centralised difficulty and economy scaling constants used by the 100-floor
 * expansion.
 *
 * Original Pixel Dungeon scattered tuning numbers across every Mob / Item
 * class. As the dungeon stretches to 100 floors, that approach becomes
 * unworkable: there is no single place to read or rebalance the global curve.
 * This class collects the per-act scalars and the depth-driven curves so that
 * tuning is a one-file job.
 *
 * The values here are NOT applied automatically to existing classes. They are
 * read by new content (Act II zones onward) and by future hooks added during
 * M5/M6. The Act I content (depths 1-25) continues to use its original hand-
 * tuned stats so the early game stays identical to vanilla.
 *
 * All methods are pure functions of depth; no global state.
 */
public final class Balance {

	private Balance() {}

	/* ---------- act multipliers ---------- */

	/**
	 * Coarse damage multiplier per act, baselined on Act I = 1.0.
	 * Used as a hint by content authors when stat-tuning new mobs.
	 */
	public static float actDamageMultiplier( Act act ) {
		if (act == null) return 1.0f;
		switch (act) {
		case ONE:   return 1.0f;
		case TWO:   return 1.6f;
		case THREE: return 2.2f;
		case FOUR:  return 3.0f;
		default:    return 1.0f;
		}
	}

	/** Coarse HP multiplier per act, baselined on Act I = 1.0. */
	public static float actHpMultiplier( Act act ) {
		if (act == null) return 1.0f;
		switch (act) {
		case ONE:   return 1.0f;
		case TWO:   return 1.8f;
		case THREE: return 2.6f;
		case FOUR:  return 3.6f;
		default:    return 1.0f;
		}
	}

	/* ---------- per-depth curves ---------- */

	/**
	 * Returns a relative difficulty score in [0, 1] for the given depth.
	 *
	 * The curve is piecewise:
	 *  - Act I (1-25)    : linear, 0.00 -> 0.25
	 *  - Act II (26-50)  : steeper, 0.25 -> 0.55
	 *  - Act III (51-75) : plateau (mechanics carry the difficulty), 0.55 -> 0.70
	 *  - Act IV (76-100) : exponential, 0.70 -> 1.00
	 */
	public static float difficulty( int depth ) {
		if (depth <= 0) return 0f;
		if (depth <= 25) {
			return depth * 0.01f;
		}
		if (depth <= 50) {
			return 0.25f + (depth - 25) * 0.012f;
		}
		if (depth <= 75) {
			return 0.55f + (depth - 50) * 0.006f;
		}
		if (depth <= 100) {
			float t = (depth - 75) / 25f;
			return 0.70f + t * t * 0.30f;
		}
		return 1.0f;
	}

	/* ---------- economy hints ---------- */

	/**
	 * Drop chance modifier for items at the given depth, baselined on Act I = 1.0.
	 * Slightly negative scaling in later acts to keep the loot dilution under
	 * control as the run length triples.
	 */
	public static float lootChanceModifier( int depth ) {
		if (depth <= 25) return 1.0f;
		if (depth <= 50) return 0.95f;
		if (depth <= 75) return 0.90f;
		return 0.85f;
	}
}
