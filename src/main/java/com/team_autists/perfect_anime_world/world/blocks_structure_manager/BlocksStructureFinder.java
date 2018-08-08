package com.team_autists.perfect_anime_world.world.blocks_structure_manager;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class BlocksStructureFinder {

	private List<ExpectedBlockInfo> offsets;
	private World worldIn;
	private Block relative;

	public BlocksStructureFinder(Block relative, List<ExpectedBlockInfo> offsets, World worldIn) {
		this.offsets = offsets;
		this.worldIn = worldIn;
		this.relative = relative;
	}

	public boolean findStructure(BlockPos centerBlock) {

		if (worldIn.getBlockState(centerBlock).getBlock() != relative) {
			return false;
		}

		for (ExpectedBlockInfo blockInfo : offsets) {
			BlockPos offset = blockInfo.getBlockOffset();

			Block block = getBlock(centerBlock, offset);

			if (blockInfo.getBlock() != block) {
				return false;
			}
		}
		return true;
	}

	private Block getBlock(BlockPos relative, BlockPos offset) {
		return getBlockStateFromRelative(this.worldIn, relative, offset).getBlock();
	}

	private IBlockState getBlockStateFromRelative(World world, BlockPos relative, BlockPos offset) {
		return world.getBlockState(getPosFromRelativePos(relative, offset));
	}

	private BlockPos getPosFromRelativePos(BlockPos relative, BlockPos offset) {
		int absX = relative.getX() + offset.getX();
		int absY = relative.getY() + offset.getY();
		int absZ = relative.getZ() + offset.getZ();

		return new BlockPos(absX, absY, absZ);
	}
}
