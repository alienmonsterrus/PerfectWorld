package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AnimeIronOre extends BlockBase {
	public AnimeIronOre(String name) {
		super(Material.IRON, SoundType.STONE, name);
		setHardness(1.8f);
		setHarvestLevel("pickaxe", 1);
	}
}
