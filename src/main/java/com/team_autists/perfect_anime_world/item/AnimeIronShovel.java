package com.team_autists.perfect_anime_world.item;

import com.team_autists.perfect_anime_world.Main;
import net.minecraft.item.ItemSpade;

public class AnimeIronShovel extends ItemSpade
{
    public AnimeIronShovel(String name, ToolMaterial material)
    {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Main.CREATIVE_TAB);

        ItemRegister.ITEMS.add(this);
    }
}
