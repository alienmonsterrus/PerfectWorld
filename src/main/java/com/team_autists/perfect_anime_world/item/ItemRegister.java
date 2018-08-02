package com.team_autists.perfect_anime_world.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemRegister {
	public static final List<Item> ITEMS = new ArrayList<>();

	public static final UselessItem USELESS_ITEM = new UselessItem("useless_item");

	public static final AnimeIronIngot ANIME_IRON_INGOT = new AnimeIronIngot("anime_iron_ingot");

	public static void register() {
		for (Item item : ITEMS) {
			setRegister(item);
		}
	}

	@SideOnly(Side.CLIENT)
	public static void registerRender() {
		for (Item item : ITEMS) {
			setRender(item);
		}
	}

	private static void setRegister(Item item)
	{
		ForgeRegistries.ITEMS.register(item);
	}

	@SideOnly(Side.CLIENT)
	private static void setRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
