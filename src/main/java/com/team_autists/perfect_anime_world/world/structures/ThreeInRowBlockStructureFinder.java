package com.team_autists.perfect_anime_world.world.structures;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlocksStructureFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class ThreeInRowBlockStructureFinder extends BlocksStructureFinder {

	private static final ThreeInRowBlockStructureFinder instance = new ThreeInRowBlockStructureFinder();

	public ThreeInRowBlockStructureFinder() {
		super(BlockRegister.ANIME_TELEPORT_BLOCK, getExpectedBlockInfo(), Minecraft.getMinecraft().world);
	}

	private static ArrayList<ExpectedBlockInfo> getExpectedBlockInfo() {
		ArrayList<ExpectedBlockInfo> blocks = new ArrayList<>();
		blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(0, 1, 0)));
		blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(0, 2, 0)));
		blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(1, 0, 0)));
		blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(-1, 0, 0)));
		return blocks;
	}

	public static ThreeInRowBlockStructureFinder getInstance() {
		return instance;
	}
}
