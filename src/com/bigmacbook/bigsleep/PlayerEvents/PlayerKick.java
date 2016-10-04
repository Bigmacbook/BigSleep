package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerKick implements Listener {
	private BigSleep bigsleep;

	public PlayerKick(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerKick(PlayerKickEvent event) {
		Player player = event.getPlayer();
		if(bigsleep.onlineNormal.contains(player.getUniqueId().toString())){
			bigsleep.onlineNormal.remove(player.getUniqueId().toString());
		}
		if(bigsleep.sleepers.contains(player.getUniqueId().toString())){
			bigsleep.sleepers.remove(player.getUniqueId().toString());
		}
	}
}
