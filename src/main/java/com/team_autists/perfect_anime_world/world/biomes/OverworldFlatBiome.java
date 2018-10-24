package com.team_autists.perfect_anime_world.world.biomes;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import net.minecraft.world.biome.Biome;

public class OverworldFlatBiome extends Biome {
	public OverworldFlatBiome() {
		super(getProperties());

		topBlock = BlockRegister.ANIME_GRASS.getDefaultState();
		fillerBlock = BlockRegister.ANIME_STONE.getDefaultState();
		decorator.treesPerChunk = 2;
		decorator.decorating = true;
		decorator.generateFalls = true;
	}

	private static BiomeProperties getProperties() {
		BiomeProperties properties = new BiomeProperties("Anime OverWorld Flat").setRainDisabled()
				.setHeightVariation(1.2f).setBaseHeight(0.95f).setTemperature(1f).setWaterColor(10711680);
		return properties;
	}
}
