package com.team_autists.perfect_anime_world.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeRegister {
	public static final Biome LIBRARY_DIMENSION = new BiomeLibrary();
	public static final Biome OVERWORLD_FLAT_BIOME = new OverworldFlatBiome();

	public static void register() {
		initBiome(LIBRARY_DIMENSION, "Library", BiomeType.WARM, Type.COLD);
		initBiome(OVERWORLD_FLAT_BIOME, "OverworldFlat", BiomeType.WARM,
				Type.BEACH, Type.DRY, Type.HILLS);
	}

	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.print("Biome register");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
