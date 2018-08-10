package com.team_autists.perfect_anime_world.world.blocks_structure_manager;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class CoordinatesConverter {

	private IReshuffler XtoZ = this::reshuffleXtoZ;
	private IReshuffler frontToBack = this::reshuffleFrontToBack;

	public ArrayList<ArrayList<ExpectedBlockInfo>> getCoordinates(ArrayList<ExpectedBlockInfo> blocks) {
		ArrayList<ArrayList<ExpectedBlockInfo>> blockslist = new ArrayList<>();

		blockslist.add(blocks);
		blockslist.add(modify(blocks, XtoZ));
		blockslist.add(modify(blocks, frontToBack));
		blockslist.add(modify(modify(blocks, XtoZ), frontToBack));

		return blockslist;
	}

	private ArrayList<ExpectedBlockInfo> modify(ArrayList<ExpectedBlockInfo> blocks, IReshuffler reshuffler) {

		ArrayList<ExpectedBlockInfo> list = new ArrayList<>(blocks.size());

		for (ExpectedBlockInfo block : blocks) {
			BlockPos offset = block.getBlockOffset();
			list.add(new ExpectedBlockInfo(block.getBlock(), reshuffler.reshuffle(offset)));
		}

		return list;
	}

	private BlockPos reshuffleXtoZ(BlockPos pos) {
		return new BlockPos(pos.getZ(), pos.getY(), pos.getX());
	}

	private BlockPos reshuffleFrontToBack(BlockPos pos) {
		return new BlockPos(-pos.getX(), pos.getY(), -pos.getZ());
	}

	private interface IReshuffler {
		BlockPos reshuffle(BlockPos pos);
	}

}
