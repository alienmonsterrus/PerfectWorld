package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AnimeDirt extends BlockBase {
	public AnimeDirt(String name) {
		super(Material.GROUND, SoundType.GROUND, name);
		setHarvestLevel("shovel", 0);
		setHardness(0.5f);
	}
}