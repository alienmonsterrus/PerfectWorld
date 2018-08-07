package com.team_autists.perfect_anime_world.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionLibrary extends WorldProvider {

    public DimensionLibrary() {

    }

    @Override
    public boolean isSurfaceWorld() {
        return super.isSurfaceWorld();
    }

    @Override
    public boolean canRespawnHere() {
        return super.canRespawnHere();
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return super.createChunkGenerator();
    }

    @Override
    public DimensionType getDimensionType() {
        return null;
    }
}
