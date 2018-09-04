package com.cangus.blacklist.main;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginMain extends JavaPlugin {

	private static PluginMain instance;

	public static PluginMain instance() {
		return instance;
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		instance = this;

		logger.info(pdfFile.getName() + " V" + pdfFile.getVersion() + " is loaded");
		Registers.onEnable(this);
	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		logger.info(pdfFile.getName() + " is ready for use another day");
	}
}
