package com.team_autists.perfect_anime_world.utils;

import com.team_autists.perfect_anime_world.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListWorldSelection;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MainMenuEvent {

	public static boolean needJoin = true;

	@SubscribeEvent
	public void onMainMenu(GuiOpenEvent event) {

		if (!needJoin)
			return;
		if (!Reference.AUTO_JOIN_WORLD)
			return;

		int world_index = Reference.AUTO_JOIN_WORLD_INDEX;

		GuiScreen guiScreen = event.getGui();
		Minecraft mc = Minecraft.getMinecraft();

		if (guiScreen instanceof GuiMainMenu) {
			mc.displayGuiScreen(new GuiWorldSelection(guiScreen));
		}

		if (guiScreen instanceof GuiWorldSelection) {
			GuiWorldSelection selection = (GuiWorldSelection)guiScreen;

			GuiListWorldSelection guiListWorldSelection = new GuiListWorldSelection(selection,
					mc, 100, 100, 32, 100 - 64, 36);

			try {
				needJoin = false;
				guiListWorldSelection.getListEntry(world_index).joinWorld();
			}
			catch (Exception ex) { }
		}
	}

	public static void register() {
		MinecraftForge.EVENT_BUS.register(new MainMenuEvent());
	}
}
