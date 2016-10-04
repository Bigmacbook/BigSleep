package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerJoin implements Listener {
	private BigSleep bigsleep;

	public PlayerJoin(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		
		if(!bigsleep.onlineNormal.contains(player.getUniqueId().toString()) && player.getWorld().getEnvironment() == Environment.NORMAL){
			
			bigsleep.onlineNormal.add(player.getUniqueId().toString());
			
		}
	}
}
