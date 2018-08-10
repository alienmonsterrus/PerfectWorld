package com.team_autists.perfect_anime_world.world.structures;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlocksStructureFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class PortalStructureFinder extends BlocksStructureFinder {

	private static final PortalStructureFinder instance = new PortalStructureFinder();

	private PortalStructureFinder() {
		super(BlockRegister.ANIME_TELEPORT_BLOCK, getExpectedBlockInfo(), Minecraft.getMinecraft().world);
	}

	private static ArrayList<ExpectedBlockInfo> getExpectedBlockInfo() {
		ArrayList<ExpectedBlockInfo> blocks = new ArrayList<>();

		blocks.addAll(getRectangleWithOffset(0));
		blocks.addAll(getRectangleWithOffset(1));
		blocks.addAll(getRectangleWithOffset(2));
		blocks.addAll(getRectangleWithOffset(3));

		return blocks;
	}

	private static ArrayList<ExpectedBlockInfo> getRectangleWithOffset(int offsetZ) {
		ArrayList<ExpectedBlockInfo> blocks = new ArrayList<>();

		blocks.add(getBlock(0 , 0, offsetZ));

		for (int y = 0; y < 4; y++) {
			blocks.add(getBlock(-1, y, offsetZ));
			blocks.add(getBlock(1 , y, offsetZ));
		}

		blocks.add(getBlock(0, 3, offsetZ));

		return blocks;
	}

	private static ExpectedBlockInfo getBlock(int x, int y, int z) {
		return new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(x, y, z));
	}

	public static PortalStructureFinder getInstance() {
		return instance;
	}
}
