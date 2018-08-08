package com.team_autists.perfect_anime_world.proxy;

import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import com.team_autists.perfect_anime_world.commands.CommandDimensionTeleport;
import com.team_autists.perfect_anime_world.item.ItemRegister;
import com.team_autists.perfect_anime_world.item.SmeltingRecipes;
import com.team_autists.perfect_anime_world.recipes.CraftingRegister;
import com.team_autists.perfect_anime_world.world.biomes.BiomeRegister;
import com.team_autists.perfect_anime_world.world.dimension.DimensionRegister;
import com.team_autists.perfect_anime_world.world.generators.GeneratorsRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("\u001B[32m" + "[Starting Test Mod PRE-INITIALIZATION]" + "\u001B[0m");
		BlockRegister.register();
		BiomeRegister.register();
		ItemRegister.register();
		GeneratorsRegister.register();
		DimensionRegister.register();
		SmeltingRecipes.init();
		CraftingRegister.register();
	}

	public void init(FMLInitializationEvent event) {
		System.out.println("\u001B[32m" + "[Starting Test Mod INITIALIZATION]" + "\u001B[0m");
	}

	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("\u001B[32m" + "[Starting Test Mod POST-INITIALIZATION]" + "\u001B[0m");
	}

	public void serverInit(FMLServerStartingEvent event) {
		System.out.println("\u001B[32m" + "[Server Starting POST-INITIALIZATION]" + "\u001B[0m");

		event.registerServerCommand(new CommandDimensionTeleport());
	}
}
