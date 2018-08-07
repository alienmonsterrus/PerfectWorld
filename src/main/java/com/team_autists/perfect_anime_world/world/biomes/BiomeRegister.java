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

	public static void register() {
		initBiome(LIBRARY_DIMENSION, "Library", BiomeType.WARM, Type.COLD);
	}

	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types) {
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.print("Biome register");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 80));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
}
