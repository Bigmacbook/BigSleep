package com.bigmacbook.bigsleep.PlayerEvents;

import org.bukkit.GameMode;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import com.bigmacbook.bigsleep.BigSleep;

public class PlayerGameModeChange implements Listener {
	private BigSleep bigsleep;

	public PlayerGameModeChange(BigSleep pl) {
		bigsleep = pl;
	}

	@EventHandler
	public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {

		Player player = event.getPlayer();
		GameMode gameMode = event.getNewGameMode();

		if (bigsleep.onlineNormal.contains(player.getUniqueId().toString()) && gameMode != GameMode.SURVIVAL) {

			bigsleep.onlineNormal.remove(player.getUniqueId().toString());

		} else if (!bigsleep.onlineNormal.contains(player.getUniqueId().toString()) && gameMode == GameMode.SURVIVAL
				&& player.getWorld().getEnvironment() == Environment.NORMAL) {

			bigsleep.onlineNormal.add(player.getUniqueId().toString());

		}

		if (bigsleep.sleepers.contains(player) && gameMode != GameMode.SURVIVAL) {

			bigsleep.sleepers.remove(player.getUniqueId().toString());

		} else if (!bigsleep.sleepers.contains(player.getUniqueId().toString()) && player.isSleeping()
				&& gameMode == GameMode.SURVIVAL && player.getWorld().getEnvironment() == Environment.NORMAL) {

			bigsleep.sleepers.add(player.getUniqueId().toString());
			bigsleep.sleepCheck(player);

		}
	}
}
