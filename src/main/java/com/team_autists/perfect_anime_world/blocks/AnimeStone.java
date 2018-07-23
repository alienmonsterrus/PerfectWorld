package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AnimeStone extends BlockBase {
	public AnimeStone(String name) {
		super(Material.ROCK, SoundType.STONE, name);
		setHardness(1.5f);
		setHarvestLevel("pickaxe", 1);
	}
}
