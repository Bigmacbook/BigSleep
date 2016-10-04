package com.bigmacbook.bigsleep.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bigmacbook.bigsleep.BigSleep;

public class Hello implements CommandExecutor {
	
	private BigSleep bigsleep;

	public Hello(BigSleep pl){
		bigsleep = pl;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You need to be a player!");
			return false;
		}
		Player player = (Player) sender;
		sender.sendMessage(""+bigsleep.onlineNormal.size());
		return true;
	}

}
