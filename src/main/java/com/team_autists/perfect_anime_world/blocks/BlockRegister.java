package com.team_autists.perfect_anime_world.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;


public class BlockRegister {

	public final static List<Block> BLOCKS = new ArrayList<>();

	public final static Block ANIME_STONE = new AnimeStone("anime_stone");
	public final static Block ANIME_DIRT = new AnimeDirt("anime_dirt");

	public static void register() {
		for (Block block : BLOCKS) {
			setRegister(block);
		}
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender() {
		for (Block block : BLOCKS) {
			setRender(block);
		}
	}

	private static void setRegister(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	private static void setRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block),
				0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
