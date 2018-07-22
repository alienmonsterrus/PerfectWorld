package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBase extends Block {
	public BlockBase(Material material, SoundType soundType, String name) {
		super(material);
		this.setSoundType(soundType);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.REDSTONE);
		BlockRegister.BLOCKS.add(this);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return true;
	}
}
