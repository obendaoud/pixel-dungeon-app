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
import com.watabou.pixeldungeon.actors.buffs.Burning;
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.CorruptedHallsBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.YogSprite;
import com.watabou.utils.Random;

/** Boss of the Corrupted Halls (Act IV, depth 80). Echo of Yog-Dzewa. */
public class YogReborn extends Mob {
	{
		name = "Yog Reborn";
		HP = HT = 620; EXP = 56; defenseSkill = 44;
		spriteClass = YogSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 38, 64 ); }
	@Override public int attackSkill( Char target ) { return 50; }
	@Override public int dr() { return 16; }
	@Override public String defenseVerb() { return "absorbed"; }
	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) Buff.affect( enemy, Burning.class ).reignite( enemy );
		if (Random.Int( 3 ) == 0) Buff.affect( enemy, Weakness.class, Weakness.duration( enemy ) );
		if (Random.Int( 4 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) b.set( damage );
		}
		return damage;
	}
	@Override public void move( int step ) {
		if (Dungeon.level instanceof CorruptedHallsBossLevel) ((CorruptedHallsBossLevel) Dungeon.level).seal();
		super.move( step );
	}
	@Override public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof CorruptedHallsBossLevel) ((CorruptedHallsBossLevel) Dungeon.level).unseal();
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...it... was not... me..." );
	}
	@Override public void notice() {
		super.notice();
		yell( "You buried me. I dug." );
	}
	@Override public String description() {
		return
			"What Yog-Dzewa was before, refined by the Halls' corruption into " +
			"something that no longer needs to wait.";
	}
	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Burning.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}
	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
