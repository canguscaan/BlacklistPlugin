package com.cangus.blacklist.command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.cangus.blacklist.main.PluginMain;

public class CommandBlock implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length >= 2) {
			String string = args[0] + ":" + args[1];
			List<String> blacklist = PluginMain.instance().getConfig().getStringList("blacklist");
			blacklist.add(string);
			PluginMain.instance().getConfig().set("blacklist", blacklist);

		}

		if (args.length == 1) {

			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to use this command ");
				return false;
			}

			Player player = (Player) sender;
			String string = args[0] + ":" + player.getWorld().getName();
			List<String> blacklist = PluginMain.instance().getConfig().getStringList("blacklist");
			blacklist.add(string);
			PluginMain.instance().getConfig().set("blacklist", blacklist);

		}

		PluginMain.instance().saveDefaultConfig();
		return false;
	}

}

// /blacklist block <world> 