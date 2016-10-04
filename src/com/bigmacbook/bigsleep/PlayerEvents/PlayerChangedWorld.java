package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerChangedWorld implements Listener {
	private BigSleep bigsleep;

	public PlayerChangedWorld(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
		Player player = event.getPlayer();
		World from = event.getFrom();
		
		if(from.getEnvironment() == Environment.NORMAL){
			
			bigsleep.onlineNormal.remove(player.getUniqueId().toString());
			
		}else if(!bigsleep.onlineNormal.contains(player.getUniqueId().toString())){
			
			bigsleep.onlineNormal.add(player.getUniqueId().toString());
			
		}
	}
}
