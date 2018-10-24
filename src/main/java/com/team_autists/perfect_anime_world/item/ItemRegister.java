package com.team_autists.perfect_anime_world.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

public class ItemRegister {

	public static final List<Item> ITEMS = new ArrayList<>();

	public static final Item.ToolMaterial TOOL_ANIME_IRON = EnumHelper.addToolMaterial("tool anime iron", 2, 512, 6.0F, 2F, 5);
	public static final Item.ToolMaterial TOOL_EPIC__IRON = EnumHelper.addToolMaterial("tool epic sword", 1, 8192, 1.0F, 10F, 12);
	public static final Item.ToolMaterial TOOL_EPIC_PICKAXE = EnumHelper.addToolMaterial("tool epic pickaxe", 4, 8192, 12.0F, 5F, 12);
	public static final UselessItem USELESS_ITEM = new UselessItem("useless_item");
	public static final AnimeIronIngot ANIME_IRON_INGOT = new AnimeIronIngot("anime_iron_ingot");
	public static final AnimeIronCore ANIME_IRON_CORE = new AnimeIronCore("anime_iron_core");
	public static final AnimeIronPickaxe ANIME_IRON_PICKAXE = new AnimeIronPickaxe("anime_iron_pickaxe", TOOL_ANIME_IRON);
	public static final AnimeIronShovel ANIME_SHOVEL = new AnimeIronShovel("anime_iron_shovel", TOOL_ANIME_IRON);
	public static final AnimeEpicSword ANIME_EPIC_SWORD = new AnimeEpicSword("anime_epic_sword", TOOL_EPIC__IRON);
	public static final AnimeEpicPickaxe ANIME_EPIC_PICKAXE = new AnimeEpicPickaxe("anime_epic_pickaxe", TOOL_EPIC_PICKAXE);


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
