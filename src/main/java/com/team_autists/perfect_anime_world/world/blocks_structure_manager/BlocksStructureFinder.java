package com.team_autists.perfect_anime_world.world.blocks_structure_manager;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlocksStructureFinder {

	private ArrayList<ArrayList<ExpectedBlockInfo>> offsets;
	private World worldIn;
	private Block relative;
	private CoordinatesConverter coordinatesConverter;

	public BlocksStructureFinder(Block relative, ArrayList<ExpectedBlockInfo> offsets, World worldIn) {
		this.worldIn = worldIn;
		this.relative = relative;
		this.coordinatesConverter = new CoordinatesConverter();
		this.offsets = coordinatesConverter.getCoordinates(offsets);
	}

	public boolean findStructure(BlockPos centerBlock) {

		if (worldIn.getBlockState(centerBlock).getBlock() != relative) {
			return false;
		}

		boolean finded;

		for (ArrayList<ExpectedBlockInfo> list : offsets) {

			finded = true;

			for (ExpectedBlockInfo blockInfo : list) {
				BlockPos offset = blockInfo.getBlockOffset();

				Block block = getBlock(centerBlock, offset);

				if (blockInfo.getBlock() != block) {
					finded = false;
				}
			}

			if (finded)
				return true;
		}
		return false;
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
