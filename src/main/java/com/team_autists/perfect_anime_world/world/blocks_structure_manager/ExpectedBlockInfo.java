package com.team_autists.perfect_anime_world.world.blocks_structure_manager;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;

public class ExpectedBlockInfo {
	private Block block;
	private BlockPos blockPos;

	public ExpectedBlockInfo(Block blockState, BlockPos blockPos) {
		this.blockPos = blockPos;
		this.block = blockState;
	}

	public Block getBlock() {
		return block;
	}

	public BlockPos getBlockOffset() {
		return blockPos;
	}
}
