package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerQuit implements Listener {
	private BigSleep bigsleep;

	public PlayerQuit(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if(bigsleep.onlineNormal.contains(player.getUniqueId().toString())){
			bigsleep.onlineNormal.remove(player.getUniqueId().toString());
		}
		if(bigsleep.sleepers.contains(player.getUniqueId().toString())){
			bigsleep.sleepers.remove(player.getUniqueId().toString());
		}
	}
}
