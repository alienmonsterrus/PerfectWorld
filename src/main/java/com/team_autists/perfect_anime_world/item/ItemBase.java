package com.team_autists.perfect_anime_world.item;

import com.team_autists.perfect_anime_world.Main;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	public ItemBase(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Main.CREATIVE_TAB);
		ItemRegister.ITEMS.add(this);
	}
}
