package com.team_autists.perfect_anime_world;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {
	public CreativeTab(String name) {
		super(name);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(BlockRegister.ANIME_DIRT);
	}
}
