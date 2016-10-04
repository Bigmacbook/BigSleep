package com.bigmacbook.bigsleep;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.bigmacbook.bigsleep.PlayerEvents.PlayerBedEnter;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerBedLeave;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerChangedWorld;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerGameModeChange;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerJoin;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerKick;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerQuit;
import com.bigmacbook.bigsleep.PlayerEvents.PlayerRespawn;

import net.md_5.bungee.api.ChatColor;

public class BigSleep extends JavaPlugin {

	PluginDescriptionFile file = getDescription();
	Logger logger = Logger.getLogger("Minecraft");
	public List<String> sleepers = new ArrayList<String>();
	public List<String> onlineNormal = new ArrayList<String>();

	public void onEnable() {
		logger.info(file.getName() + " has been enabled!");

		registerCommands();
		registerEvents();
	}

	public void onDisable() {
		logger.info(file.getName() + " has been disabled!");
	}

	public void registerCommands() {
		//getCommand("hello").setExecutor(new Hello(this));
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerBedEnter(this), this);
		pm.registerEvents(new PlayerBedLeave(this), this);
		pm.registerEvents(new PlayerGameModeChange(this), this);
		pm.registerEvents(new PlayerChangedWorld(this), this);
		pm.registerEvents(new PlayerRespawn(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerKick(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
	}

	public void sleepCheck(Player player) {
		getServer().broadcastMessage(ChatColor.YELLOW+"Players sleeping (" + sleepers.size() + "/" + onlineNormal.size() + ") - "
				+ (int)Math.ceil((double) onlineNormal.size() / 2) + " needed to get through the night!");
		
		if (sleepers.size() >= Math.ceil((double) onlineNormal.size() / 2)) {
			if (player.getWorld().getTime() >= 13000) {
				player.getWorld().setTime(0);
				getServer().broadcastMessage(ChatColor.YELLOW+"Everyone get up! It's daytime.");
			}
		}
		
	}

}