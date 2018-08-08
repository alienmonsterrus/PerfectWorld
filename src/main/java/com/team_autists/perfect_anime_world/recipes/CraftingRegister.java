package com.team_autists.perfect_anime_world.recipes;

import com.team_autists.perfect_anime_world.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class CraftingRegister {
	public static void register() {
		registerRecipes("useless_item");
		// registerRecipes("anime_iron_pickaxe");
	}

	private static void registerRecipes(String name) {
		CraftingHelper.register(new ResourceLocation(Reference.MOD_ID, name),
				(IRecipeFactory) (context, json) -> CraftingHelper.getRecipe(json, context));
	}
}
