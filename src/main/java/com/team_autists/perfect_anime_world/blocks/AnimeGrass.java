package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class AnimeGrass extends BlockBase {
	public AnimeGrass(String name) {
		super(Material.GRASS, SoundType.CLOTH, name);
		setTickRandomly(true);
		setHardness(0.5f);
		setHarvestLevel("shovel", 1);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(BlockRegister.ANIME_DIRT));
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable) {
		return true;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (worldIn.isRemote)
			return;
		if (!worldIn.isAreaLoaded(pos, 3))
			return;

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
			for (int i = 0; i < 4; i++) {
				BlockPos blockPos = pos.add(rand.nextInt(3) - 1,
						rand.nextInt(5) - 3,
						rand.nextInt(3) - 1);

				if (blockPos.getY() >= 0 && blockPos.getY() < 256 && !worldIn.isBlockLoaded(blockPos)) {
					return;
				}

				IBlockState blockState = worldIn.getBlockState(blockPos);
				IBlockState upBlockState = worldIn.getBlockState(blockPos.up());

				if (upBlockState.getBlock() != Blocks.AIR)
					return;

				if (blockState.getBlock() == BlockRegister.ANIME_DIRT) {
					worldIn.setBlockState(blockPos, BlockRegister.ANIME_GRASS.getDefaultState());
					System.out.println("\u001B[32m" + "[Grass is set!]" + "\u001B[0m");
				}
			}
		}
	}
}
