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

import java.util.HashSet;

import com.watabou.pixeldungeon.Badges;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.blobs.ToxicGas;
import com.watabou.pixeldungeon.actors.buffs.Blindness;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Sleep;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.EchoChambersBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.SuccubusSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Echo Chambers (Act III, depth 70).
 *
 * Roadmap intent: severely reduced vision, mobs audible elsewhere on the
 * floor. M5 v1 ships the boss with stat-tuned baseline + Blindness/Sleep on
 * hit; the global vision/audio mechanic is a follow-up.
 */
public class TheResonance extends Mob {

	{
		name = "The Resonance";

		HP = HT = 480;
		EXP = 50;
		defenseSkill = 40;

		spriteClass = SuccubusSprite.class;
	}

	@Override public int damageRoll() { return Random.NormalIntRange( 28, 52 ); }
	@Override public int attackSkill( Char target ) { return 46; }
	@Override public int dr() { return 12; }
	@Override public String defenseVerb() { return "echoed" ; }

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) {
			Buff.affect( enemy, Blindness.class, 10f );
		}
		if (Random.Int( 6 ) == 0) {
			Buff.affect( enemy, Sleep.class );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof EchoChambersBossLevel) {
			((EchoChambersBossLevel) Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof EchoChambersBossLevel) {
			((EchoChambersBossLevel) Dungeon.level).unseal();
		}
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...silence. at last." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Listen." );
	}

	@Override
	public String description() {
		return
			"You hear it before you see it. You see it because you heard it. The " +
			"Resonance is the shape your mind gives to the sound it cannot stop.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
