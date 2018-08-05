package com.team_autists.perfect_anime_world.item;

import com.team_autists.perfect_anime_world.blocks.AnimeIronOre;
import com.team_autists.perfect_anime_world.blocks.BlockRegister;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingRecipes {
    public static void init() {
        GameRegistry.addSmelting(ItemRegister.ANIME_IRON_INGOT, new ItemStack(ItemRegister.ANIME_IRON_INGOT), 1);
        GameRegistry.addSmelting(BlockRegister.ANIME_IRON_ORE, new ItemStack(ItemRegister.ANIME_IRON_INGOT), 1);
    }
}
