package com.team_autists.perfect_anime_world.world.blocks_structure_manager;

import net.minecraft.block.Block;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;

public class BlockNeighborsFinder {

	public static ArrayList<ExpectedBlockInfo> Find(World worldIn, BlockPos pos, Block... blocks) {

		HashSet<BlockPos> validPositions = new HashSet<>();
		HashSet<BlockPos> testPositions = new HashSet<>();

		ArrayList<ExpectedBlockInfo> blocksInfos = new ArrayList<>();

		blocksInfos.add(new ExpectedBlockInfo(worldIn.getBlockState(pos).getBlock(), pos));

		if (blocks.length < 1)
			return new ArrayList<>();

		validPositions.add(pos);

		for (int i = 0; i < 6; i++)
			testPositions.add(pos.add(EnumFacing.VALUES[i].getDirectionVec()));

		while (testPositions.size() > 0) {
			HashSet<BlockPos> newTestPosition = new HashSet<>();

			for (BlockPos nextPos : testPositions) {
				if (getIsValidBlock(worldIn, nextPos, blocks)) {

					blocksInfos.add(new ExpectedBlockInfo(worldIn.getBlockState(nextPos)
							.getBlock(), nextPos));

					validPositions.add(nextPos);
					for (int i = 0; i < 6; i++) {
						BlockPos pp = nextPos.add(EnumFacing.VALUES[i].getDirectionVec());
						if (!validPositions.contains(pp))
							newTestPosition.add(pp);
					}
				}
				newTestPosition.remove(nextPos);
			}
			testPositions = newTestPosition;
		}

		return blocksInfos;
	}

	private static boolean getIsValidBlock(World world, BlockPos pos, Block[] blocks) {
		Block block = world.getBlockState(pos).getBlock();
		for (Block validBlock : blocks) {
			if (block == validBlock)
				return true;
		}

		return false;
	}
}
