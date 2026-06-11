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
import com.watabou.pixeldungeon.actors.buffs.Bleeding;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Cripple;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.BloodyPrisonBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.TenguSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Bloody Prison (Act IV, depth 95). Three-in-one Tengu echo.
 *
 * Roadmap intent: 3 Tengus simultaneously. M6 v1 collapses this into a single
 * massively-statted Tengu echo to avoid the multi-spawn AI complexity.
 * The full three-body variant is a v2 task that touches the Mob spawn
 * pipeline and arena placement.
 */
public class TenguTrinity extends Mob {
	{
		name = "Tengu Trinity";
		HP = HT = 740; EXP = 62; defenseSkill = 52;
		spriteClass = TenguSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 38, 64 ); }
	@Override public int attackSkill( Char target ) { return 58; }
	@Override public int dr() { return 14; }
	@Override public String defenseVerb() { return "split"; }
	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 2 ) == 0) Buff.affect( enemy, Cripple.class, Cripple.DURATION );
		if (Random.Int( 2 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) b.set( damage );
		}
		return damage;
	}
	@Override public void move( int step ) {
		if (Dungeon.level instanceof BloodyPrisonBossLevel) ((BloodyPrisonBossLevel) Dungeon.level).seal();
		super.move( step );
	}
	@Override public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof BloodyPrisonBossLevel) ((BloodyPrisonBossLevel) Dungeon.level).unseal();
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...there were... still two... of me..." );
	}
	@Override public void notice() {
		super.notice();
		yell( "Welcome back. We waited together." );
	}
	@Override public String description() {
		return
			"Tengu, killed once, splintered into the Bloody Prison's three " +
			"corners. They have rejoined for this moment, and only this moment.";
	}
	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}
	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
