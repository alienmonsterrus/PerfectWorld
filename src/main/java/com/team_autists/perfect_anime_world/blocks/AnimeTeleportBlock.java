package com.team_autists.perfect_anime_world.blocks;

import com.team_autists.perfect_anime_world.commands.Teleport;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AnimeTeleportBlock extends BlockBase {
	public AnimeTeleportBlock(String name) {
		super(Material.IRON, SoundType.METAL, name);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {

			double x = playerIn.getPosition().getX();
			double y = playerIn.getPosition().getY() + 5;
			double z = playerIn.getPosition().getZ();

			Teleport.teleportToDimension(playerIn, 2, x, y, z);
			return true;
		}

		return false;
	}
}
