package com.cangus.blacklist.main;

import org.bukkit.plugin.PluginManager;

import com.cangus.blacklist.command.CommandBlock;
import com.cangus.blacklist.event.block.Prevention;

public class Registers {
	public static void registerCommands(PluginMain pl) {

		pl.getCommand("blacklist").setExecutor(new CommandBlock());
	}

	public static void registerEvents(PluginMain pl) {
		PluginManager pm = pl.getServer().getPluginManager();

		pm.registerEvents(new Prevention(), pl);
	}

	public static void onEnable(PluginMain pl) {
		registerEvents(pl);
		registerCommands(pl);
	}

}