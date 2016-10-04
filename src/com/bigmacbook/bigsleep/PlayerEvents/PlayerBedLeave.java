package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerBedLeave implements Listener {

	private BigSleep bigsleep;

	public PlayerBedLeave(BigSleep pl){
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
		Player player = event.getPlayer();
		if (bigsleep.sleepers.contains(player.getUniqueId().toString())) {
			bigsleep.sleepers.remove(player.getUniqueId().toString());
		}
	}
}
