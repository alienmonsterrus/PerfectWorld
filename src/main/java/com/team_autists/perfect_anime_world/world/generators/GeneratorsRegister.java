package com.team_autists.perfect_anime_world.world.generators;

import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class GeneratorsRegister {

	public static final List<WorldGenBase> WORLD_GENERATORS = new ArrayList<>();

	public static final WorldGenIronOre WORLD_GEN_IRON_ORE = new WorldGenIronOre();

	public static void register() {
		for (WorldGenBase worldGen : WORLD_GENERATORS) {
			GameRegistry.registerWorldGenerator(worldGen, worldGen.getGenerationWeight());
		}
	}
}
