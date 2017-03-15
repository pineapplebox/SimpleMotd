package com.finiox.SimpleMotd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.finiox.SimpleMotd.SimpleMotd;

public class CommandSimpleMotd implements CommandExecutor {
	private final SimpleMotd plugin;

	public CommandSimpleMotd(SimpleMotd plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("simplemotd"))
		{
			if (args.length == 1)
			{
				if (args[0].equalsIgnoreCase("on"))
				{
					plugin.getConfig().set("simplemotd.enabled", true);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.RED + "SimpleMotd is turned ON!");
				}
				else if (args[0].equalsIgnoreCase("off"))
				{
					plugin.getConfig().set("simplemotd.enabled", false);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.RED + "SimpleMotd is turned OFF!");
				}
				else if (args[0].equalsIgnoreCase("reload"))
				{
					plugin.reloadConfig();
					sender.sendMessage(ChatColor.RED + "SimpleMotd is reloaded!");
				}
				else if (args[0].equalsIgnoreCase("status"))
				{
					String status = "off";
					if (plugin.getConfig().getBoolean("simplemotd.enabled")) status = "on";
					sender.sendMessage(ChatColor.RED + "SimpleMotd is currently " + status);
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f===&cSimple&eMotd&f==="));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/simplemotd on"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/simplemotd off"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/simplemotd reload"));
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/simplemotd status"));
				}
			}
			else
			{
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f===&cSimple&eMotd&f==="));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fPlugin by: &bFiniox"));
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fUse: &c/simplemotd help &ffor help"));
			}
			return true;
		}
		return false;
	}
	
}
