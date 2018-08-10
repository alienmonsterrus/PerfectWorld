package com.team_autists.perfect_anime_world.world.structures;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlocksStructureFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class AnimeWorkbenchStructureFinder extends BlocksStructureFinder {
    public AnimeWorkbenchStructureFinder() {
        super(BlockRegister.ANIME_TELEPORT_BLOCK, getOffsets(), Minecraft.getMinecraft().world);
    }
    private static ArrayList<ExpectedBlockInfo> getOffsets() {
        ArrayList<ExpectedBlockInfo> blocks = new ArrayList<>();
        blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(1,0,-1)));
        blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(1,0,-2)));
        blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(1,0,-3)));
        blocks.add(new ExpectedBlockInfo(BlockRegister.ANIME_TELEPORT_BLOCK, new BlockPos(1,0,-4)));
        return blocks;
    }

}
