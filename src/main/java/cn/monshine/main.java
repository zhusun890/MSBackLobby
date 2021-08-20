package cn.monshine;

import cn.monshine.utils.bungeeUtils;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class main extends JavaPlugin implements Listener {

	private static main instance;
	private static FileConfiguration config;

	@Override
	public void onEnable() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		instance = this;
		config = getConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("transerver")) {
			try {
				if (commandArgs[0] == "") {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUsage: /transerver <Server name>"));
				} else if (config.getString(commandArgs[0]) == null) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cInvaild Server!"));
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bConnecting you to server &3") + commandArgs[0] + "...");
					bungeeUtils.connectToServer((Player) sender, commandArgs[0]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("hub")) {
			try {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&bConnecting to &3Lobby..."));
				bungeeUtils.connectToServer((Player) sender, config.getString("Server.lobbyServerName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}


	public static main getInstance() {
		return instance;
	}


}
