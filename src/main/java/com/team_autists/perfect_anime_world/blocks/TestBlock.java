package com.team_autists.perfect_anime_world.blocks;

import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlockNeighborsFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import com.team_autists.perfect_anime_world.world.structures.AnimeWorkbenchStructureFinder;
import com.team_autists.perfect_anime_world.world.structures.TestBlockWorkbenchStructureFinder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;

public class TestBlock extends BlockBase {
    public TestBlock(String name) {
        super(Material.CLOTH, SoundType.SAND, name);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            playerIn.sendMessage(new TextComponentString("Activated"));
            handleClick(worldIn, pos, playerIn);
        }
        return true;
    }

    private void handleClick(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        ArrayList<ExpectedBlockInfo> blocks = BlockNeighborsFinder.Find(worldIn, pos, BlockRegister.TEST_BLOCK);

        boolean finded = false;

        for (ExpectedBlockInfo block: blocks) {
            TestBlockWorkbenchStructureFinder finder = new TestBlockWorkbenchStructureFinder();
            boolean isFinded = finder.findStructure(block.getBlockOffset());
            if (isFinded) {
                finded = true;
            }
        }

        if (finded) {
            playerIn.sendMessage(new TextComponentString(
                    "Workbench structure was found"));

            TestBlockWorkbenchStructureFinder.TestBlockStructureInfo n =
                    TestBlockWorkbenchStructureFinder.getStructure(pos);

            playerIn.sendMessage(new TextComponentString("Clicks: " + n.getClick()));
        }
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        EntityPlayer player = Minecraft.getMinecraft().player;
        player.sendMessage(new TextComponentString("Test block placed"));
    }
}
