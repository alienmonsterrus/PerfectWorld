package com.team_autists.perfect_anime_world.blocks;

import com.team_autists.perfect_anime_world.commands.Teleport;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.BlockNeighborsFinder;
import com.team_autists.perfect_anime_world.world.blocks_structure_manager.ExpectedBlockInfo;
import com.team_autists.perfect_anime_world.world.structures.AnimeWorkbenchStructureFinder;
import com.team_autists.perfect_anime_world.world.structures.PortalStructureFinder;
import com.team_autists.perfect_anime_world.world.structures.ThreeInRowBlockStructureFinder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.ArrayList;

public class AnimeTeleportBlock extends BlockBase {
	public AnimeTeleportBlock(String name) {
		super(Material.IRON, SoundType.METAL, name);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		/*
		if (!worldIn.isRemote) {

			double x = playerIn.getPosition().getX();
			double y = playerIn.getPosition().getY() + 5;
			double z = playerIn.getPosition().getZ();

			Teleport.teleportToDimension(playerIn, 2, x, y, z);
			return true;
		}
		*/

		if (!worldIn.isRemote) {
			ArrayList<ExpectedBlockInfo> blocks = BlockNeighborsFinder.Find(worldIn, pos, BlockRegister.ANIME_TELEPORT_BLOCK);

			boolean trashFlagFinded = false;
			boolean portalFlagFinded = false;

			for (ExpectedBlockInfo block: blocks){
				AnimeWorkbenchStructureFinder finder = new AnimeWorkbenchStructureFinder();
				boolean isFinded = finder.findStructure(block.getBlockOffset());
				if(isFinded){
					playerIn.sendMessage(new TextComponentString("Workbench structure was found"));
				}
			}

			for (ExpectedBlockInfo block : blocks) {
				boolean trashFinded = ThreeInRowBlockStructureFinder.
						getInstance().findStructure(block.getBlockOffset());
				boolean portalFinded = PortalStructureFinder.
						getInstance().findStructure(block.getBlockOffset());

				if (trashFinded)
					trashFlagFinded = true;

				if (portalFinded)
					portalFlagFinded = true;
			}

			if (trashFlagFinded)
				if (!portalFlagFinded)
					playerIn.sendMessage(new TextComponentString("Trash Structure is finded"));

			if (portalFlagFinded) {
				playerIn.sendMessage(new TextComponentString("Portal Structure is finded"));
				Teleport.teleportToDimension(playerIn, 2, playerIn.getPosition().getX(), playerIn.getPosition().getY(), playerIn.getPosition().getZ());
			}
				playerIn.sendMessage(new TextComponentString("Count: " + String.valueOf(blocks.size())));

		}

		/*
		if (!worldIn.isRemote) {
			if (ThreeInRowBlockStructureFinder.getInstance().findStructure(pos)) {
				playerIn.sendMessage(new TextComponentString("TeleportBlock: FINDED!!"));
			} else {
				playerIn.sendMessage(new TextComponentString("TeleportBlock: None"));
			}
		}
		*/
		return true;
	}
}
