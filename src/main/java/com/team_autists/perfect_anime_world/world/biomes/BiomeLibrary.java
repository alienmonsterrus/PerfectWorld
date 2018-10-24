package com.team_autists.perfect_anime_world.world.biomes;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import net.minecraft.world.biome.Biome;

public class BiomeLibrary extends Biome {
	public BiomeLibrary() {
		super(new BiomeProperties("Anime Hills").setBaseHeight(0.75f).setHeightVariation(1.2f)
			.setRainDisabled().setWaterColor(16711680));

		topBlock = BlockRegister.ANIME_GRASS.getDefaultState();
		fillerBlock = BlockRegister.ANIME_DIRT.getDefaultState();

		decorator.treesPerChunk = 1;
		decorator.decorating = true;
		decorator.generateFalls = true;
	}
}
