package com.team_autists.perfect_anime_world;

import com.team_autists.perfect_anime_world.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	private static CommonProxy proxy;

	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
