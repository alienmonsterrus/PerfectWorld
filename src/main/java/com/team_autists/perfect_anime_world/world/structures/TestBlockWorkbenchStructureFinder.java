package com.team_autists.perfect_anime_world.world.structures;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlocksStructureFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;

public class TestBlockWorkbenchStructureFinder extends BlocksStructureFinder {

    private static ArrayList<TestBlockStructureInfo> blocksStructures = new ArrayList<>();

    public TestBlockWorkbenchStructureFinder() {
        super(BlockRegister.TEST_BLOCK, getOffsets(),
                Minecraft.getMinecraft().world);
    }

    public static TestBlockStructureInfo getStructure(BlockPos pos) {
        for (TestBlockStructureInfo info : blocksStructures) {
            if (info.getPosition().equals(pos)) {
                return info;
            }
        }

        TestBlockStructureInfo n = new TestBlockStructureInfo();
        n.setPosition(pos);
        blocksStructures.add(n);

        return n;
    }

    private static ArrayList<ExpectedBlockInfo> getOffsets() {
        ArrayList<ExpectedBlockInfo> blocks = new ArrayList<>();

        for (int y = 0; y < 3; y++) {
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                     1, y,  0)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                     1, y,  1)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                     0, y,  1)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                    -1, y,  1)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                    -1, y,  0)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                    -1, y, -1)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                     0, y, -1)));
            blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
                     1, y, -1)));
        }
        blocks.add(new ExpectedBlockInfo(BlockRegister.TEST_BLOCK, new BlockPos(
            0, 2, 0)));
        return blocks;
    }

    public static class TestBlockStructureInfo {
        private BlockPos position;
        private int clickCount = 0;

        public BlockPos getPosition() {
            return position;
        }

        public void setPosition(BlockPos pos) {
            position = pos;
        }

        public int getClick() {
            clickCount++;
            return clickCount;
        }
    }
}
