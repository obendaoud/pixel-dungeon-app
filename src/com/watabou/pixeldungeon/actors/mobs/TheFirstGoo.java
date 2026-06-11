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
import com.watabou.pixeldungeon.actors.buffs.Ooze;
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.FinalSewerBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.GooSprite;
import com.watabou.utils.Random;

/**
 * Placeholder final-floor boss (Act IV, depth 100).
 *
 * Ships as a heavily-statted Goo echo so the dungeon is completable end
 * to end. M7 will replace this implementation with the proper run-ending
 * confrontation, ending cinematic, and New-Game-Plus hook.
 */
public class TheFirstGoo extends Mob {
	{
		name = "The First Goo";
		HP = HT = 900; EXP = 80; defenseSkill = 50;
		spriteClass = GooSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 48, 80 ); }
	@Override public int attackSkill( Char target ) { return 60; }
	@Override public int dr() { return 20; }
	@Override public String defenseVerb() { return "absorbed"; }
	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 2 ) == 0) Buff.affect( enemy, Ooze.class );
		if (Random.Int( 2 ) == 0) Buff.affect( enemy, Weakness.class, Weakness.duration( enemy ) );
		if (Random.Int( 3 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) b.set( damage * 2 );
		}
		return damage;
	}
	@Override public void move( int step ) {
		if (Dungeon.level instanceof FinalSewerBossLevel) ((FinalSewerBossLevel) Dungeon.level).seal();
		super.move( step );
	}
	@Override public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof FinalSewerBossLevel) ((FinalSewerBossLevel) Dungeon.level).unseal();
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "glurp... GLURP... at last..." );
	}
	@Override public void notice() {
		super.notice();
		yell( "GLURP. GLURP. GLURP." );
	}
	@Override public String description() {
		return
			"You met it at depth 5, smaller and singular. You learn here that it " +
			"was never alone, and that the floors you have walked were its " +
			"slow, terrible breath in.";
	}
	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}
	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
