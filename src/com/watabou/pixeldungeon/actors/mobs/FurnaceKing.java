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
import com.watabou.pixeldungeon.actors.buffs.Burning;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.weapon.enchantments.Death;
import com.watabou.pixeldungeon.levels.ForgeBossLevel;
import com.watabou.pixeldungeon.scenes.GameScene;
import com.watabou.pixeldungeon.sprites.ElementalSprite;
import com.watabou.utils.Random;

/**
 * Boss of the Forge zone (Act II), encountered at depth 30.
 *
 * Stat tuning aims at the gap between the King of Dwarves (depth 20) and
 * Yog-Dzewa (depth 25), reflecting that depth 30 sits one tier deeper than
 * Halls. Uses the fire elemental sprite as a placeholder until a dedicated
 * Furnace King sprite atlas is produced.
 */
public class FurnaceKing extends Mob {

	{
		name = "Furnace King";

		HP = HT = 220;
		EXP = 30;
		defenseSkill = 26;

		spriteClass = ElementalSprite.class;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 22, 38 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 32;
	}

	@Override
	public int dr() {
		return 10;
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		if (Random.Int( 2 ) == 0) {
			com.watabou.pixeldungeon.actors.buffs.Buff.affect( enemy, Burning.class ).reignite( enemy );
		}
		return damage;
	}

	@Override
	public void move( int step ) {
		if (Dungeon.level instanceof ForgeBossLevel) {
			((ForgeBossLevel)Dungeon.level).seal();
		}
		super.move( step );
	}

	@Override
	public void die( Object cause ) {

		super.die( cause );

		if (Dungeon.level instanceof ForgeBossLevel) {
			((ForgeBossLevel)Dungeon.level).unseal();
		}

		GameScene.bossSlain();
		Dungeon.level.drop( new SkeletonKey(), pos ).sprite.drop();

		Badges.validateBossSlain();

		yell( "the fire... never dies..." );
	}

	@Override
	public void notice() {
		super.notice();
		yell( "Welcome to the Furnace, intruder!" );
	}

	@Override
	public String description() {
		return
			"The Furnace King rules a realm of perpetual heat and metal. His body " +
			"is a vessel for the fire of the Forge itself; striking him is like " +
			"striking an anvil. Where he walks, the stone glows.";
	}

	private static final HashSet<Class<?>> RESISTANCES = new HashSet<Class<?>>();
	static {
		RESISTANCES.add( Burning.class );
		RESISTANCES.add( ToxicGas.class );
		RESISTANCES.add( Death.class );
		RESISTANCES.add( ScrollOfPsionicBlast.class );
	}

	@Override
	public HashSet<Class<?>> resistances() {
		return RESISTANCES;
	}
}
