package com.team_autists.perfect_anime_world.commands;

import com.google.common.collect.Lists;
import com.team_autists.perfect_anime_world.Reference;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.ArrayList;
import java.util.List;

public class CommandDimensionTeleport extends CommandBase {

	private static final List<String> alieses = Lists.newArrayList(Reference.MOD_ID,
			"tp", "tpdim", "tpdimension");

	@Override
	public String getName() {
		return "tpdim";
	}

	public static List<String> getAlieses() {
		return alieses;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "are u stupid? /? / ?";
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1)
			return;

		String s = args[0];

		int dimensionId;

		try {
			dimensionId = Integer.parseInt(s);
		} catch (NumberFormatException ex) {
			sender.sendMessage(new TextComponentString(TextFormatting.RED + "Invalid dimension (or you)"));
			return;
		}

		if (sender instanceof EntityPlayer) {

			double x = sender.getPosition().getX();
			double y = sender.getPosition().getY() + 5;
			double z = sender.getPosition().getZ();

			Teleport.teleportToDimension((EntityPlayer)sender, dimensionId, x, y, z);
		}
	}
}
