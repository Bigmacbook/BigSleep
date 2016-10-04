package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.GameMode;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import com.bigmacbook.bigsleep.BigSleep;

import net.md_5.bungee.api.ChatColor;

public class PlayerBedEnter implements Listener {

	private BigSleep bigsleep;

	public PlayerBedEnter(BigSleep pl) {
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		Player player = event.getPlayer();
		Block bed = event.getBed();
		
		if (!bigsleep.sleepers.contains(player.getUniqueId().toString())
				&& player.getWorld().getEnvironment() == Environment.NORMAL
				&& player.getGameMode() == GameMode.SURVIVAL) {

			bigsleep.sleepers.add(player.getUniqueId().toString());
			
			player.setBedSpawnLocation(bed.getLocation());
			
			player.sendMessage(ChatColor.YELLOW + "Bed Spawn Set!");
			
			bigsleep.sleepCheck(player);
			/*
			 * for(Player player : atb.getServer().getOnlinePlayers()){
			 * player.getWorld().getEmptyChunkSnapshot(arg0, arg1, arg2, arg3) }
			 */
		}
	}
}
