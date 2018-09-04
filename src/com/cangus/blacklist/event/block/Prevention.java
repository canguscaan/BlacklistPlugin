package com.cangus.blacklist.event.block;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.cangus.blacklist.main.PluginMain;

public class Prevention implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();

		// Loads the blacklist list and saves it as blacklist
		List<String> blacklist = PluginMain.instance().getConfig().getStringList("blacklist");
		Block block = event.getBlock();
		Material material = block.getType();

		
		World world = player.getWorld();
		String check = material.name() + ":" + world.getName();

		if (blacklist.contains(check)) {

			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You are not allowed to break this here");
		}
	}

}
