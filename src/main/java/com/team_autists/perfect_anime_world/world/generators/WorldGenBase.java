package com.team_autists.perfect_anime_world.world.generators;

import net.minecraftforge.fml.common.IWorldGenerator;

public abstract class WorldGenBase implements IWorldGenerator {
	public final int generationWeight;

	public WorldGenBase(int generationWeight) {
		this.generationWeight = generationWeight;
		GeneratorsRegister.WORLD_GENERATORS.add(this);
	}

	public int getGenerationWeight() {
		return this.generationWeight;
	}
}
