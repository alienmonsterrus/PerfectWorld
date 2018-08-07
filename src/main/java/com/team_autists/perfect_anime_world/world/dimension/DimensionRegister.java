package com.team_autists.perfect_anime_world.world.dimension;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionRegister {
    public static final DimensionType LIBRARY = DimensionType.register("Library", "_library",
            2, DimensionLibrary.class, false);
	public static final DimensionType OVERWORLD_FLAT = DimensionType.register("OverworldFlat",
			"_overworldflat", 5, DimensionOverworldFlat.class, false);

    public static void register() {
        DimensionManager.registerDimension(5, OVERWORLD_FLAT);
        DimensionManager.registerDimension(2, LIBRARY);
    }
}
