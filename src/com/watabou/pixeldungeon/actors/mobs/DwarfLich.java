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
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.TaintedCityBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.KingSprite;
import com.watabou.utils.Random;

/** Boss of the Tainted City (Act IV, depth 85). Echo of the King of Dwarves. */
public class DwarfLich extends Mob {
	{
		name = "Dwarf Lich";
		HP = HT = 660; EXP = 58; defenseSkill = 46;
		spriteClass = KingSprite.class;
	}
	@Override public int damageRoll() { return Random.NormalIntRange( 40, 66 ); }
	@Override public int attackSkill( Char target ) { return 52; }
	@Override public int dr() { return 18; }
	@Override public String defenseVerb() { return "warded"; }
	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 3 ) == 0) Buff.affect( enemy, Cripple.class, Cripple.DURATION );
		if (Random.Int( 3 ) == 0) Buff.affect( enemy, Weakness.class, Weakness.duration( enemy ) );
		if (Random.Int( 4 ) == 0) {
			Bleeding b = Buff.affect( enemy, Bleeding.class );
			if (b != null) b.set( damage );
		}
		return damage;
	}
	@Override public void move( int step ) {
		if (Dungeon.level instanceof TaintedCityBossLevel) ((TaintedCityBossLevel) Dungeon.level).seal();
		super.move( step );
	}
	@Override public void die( Object cause ) {
		super.die( cause );
		if (Dungeon.level instanceof TaintedCityBossLevel) ((TaintedCityBossLevel) Dungeon.level).unseal();
		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();
		Badges.validateBossSlain();
		yell( "...the throne... was already... empty..." );
	}
	@Override public void notice() {
		super.notice();
		yell( "You came back to a city of corpses, thief." );
	}
	@Override public String description() {
		return
			"The King of Dwarves, slain by the hero once, raised by the City " +
			"itself. He no longer needs an army; he is one.";
	}
	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}
	@Override public HashSet<Class<?>> resistances() { return RESISTANCES; }
}
