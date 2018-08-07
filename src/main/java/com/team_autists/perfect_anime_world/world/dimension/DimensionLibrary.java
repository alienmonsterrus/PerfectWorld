package com.team_autists.perfect_anime_world.world.dimension;

import com.team_autists.perfect_anime_world.world.biomes.BiomeRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorFlat;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibrary extends WorldProvider {

    public DimensionLibrary() {
		this.biomeProvider = new BiomeProviderSingle(BiomeRegister.LIBRARY_DIMENSION);
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
        return new ChunkGeneratorFlat(world, world.getSeed(), true,
				"village");
    }

    @Override
    public DimensionType getDimensionType() {
        return DimensionRegister.LIBRARY;
    }
}
