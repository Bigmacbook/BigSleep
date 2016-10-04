package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.Location;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerRespawn implements Listener {
	private BigSleep bigsleep;

	public PlayerRespawn(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Location location = event.getRespawnLocation();
		
		if(!bigsleep.onlineNormal.contains(player.getUniqueId().toString()) && location.getWorld().getEnvironment() == Environment.NORMAL){
			
			bigsleep.onlineNormal.add(player.getUniqueId().toString());
			
		}else if(bigsleep.onlineNormal.contains(player.getUniqueId().toString())){
			
			bigsleep.onlineNormal.remove(player.getUniqueId().toString());
			
		}
	}
}
