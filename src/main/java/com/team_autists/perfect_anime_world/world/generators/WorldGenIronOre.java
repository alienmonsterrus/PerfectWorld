package com.team_autists.perfect_anime_world.world.generators;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import java.util.Random;

public class WorldGenIronOre extends WorldGenBase {

	private final WorldGenMinable oreGenOverworld;

	public WorldGenIronOre() {
		super(40);

		oreGenOverworld = new WorldGenMinable(BlockRegister.ANIME_IRON_ORE.getDefaultState(), 20,
				BlockMatcher.forBlock(Blocks.STONE));

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator
			chunkGenerator, IChunkProvider chunkProvider) {
		BlockPos chunkPos = new BlockPos(chunkX * 16, 0, chunkZ * 16);

		if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
			for (int i = 0; i < 16; i++) {
				oreGenOverworld.generate(world, random, chunkPos.add(random.nextInt(16),
						random.nextInt(108) + 10, random.nextInt(16)));
			}
		}
	}
}
