package com.team_autists.perfect_anime_world.world.dimension;

import com.team_autists.perfect_anime_world.world.biomes.BiomeRegister;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorOverworld;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionOverworldFlat extends WorldProvider {

	public DimensionOverworldFlat() {
		this.biomeProvider = new BiomeProviderSingle(BiomeRegister.OVERWORLD_FLAT_BIOME);
	}

	@Override
	public boolean isSurfaceWorld() {
		return false;
	}

	@Override
	public boolean canRespawnHere() {
		return false;
	}

	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkGeneratorOverworld(world, world.getSeed(), true,
				"village");
	}

	@Override
	public DimensionType getDimensionType() {
		return DimensionRegister.OVERWORLD_FLAT;
	}
}
