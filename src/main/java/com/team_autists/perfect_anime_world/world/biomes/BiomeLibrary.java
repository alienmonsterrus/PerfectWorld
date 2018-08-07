package com.team_autists.perfect_anime_world.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeLibrary extends Biome {
	public BiomeLibrary() {
		super(new BiomeProperties("Library").setBaseHeight(75).setHeightVariation(1.2f)
			.setRainDisabled().setWaterColor(16711680));
	}
}
