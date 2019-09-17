package com.finiox.SimpleMotd;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SimpleMotd extends JavaPlugin implements Listener {
	public void loadConf() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		loadConf();

		this.getCommand("simplemotd").setExecutor(new CommandSimpleMotd(this));
	}

	@Override
	public void onDisable() {
		this.saveConfig();
	}
	
	@EventHandler
	public void onPing(ServerListPingEvent e)
	{
		if (!(this.getConfig().getBoolean("simplemotd.enabled"))) return;
		
		List<String> messages = this.getConfig().getStringList("simplemotd.firstline");
		int randomNum = ThreadLocalRandom.current().nextInt(0, messages.size());
		String secondline = ChatColor.translateAlternateColorCodes('&', messages.get(randomNum));
		List<String> messages = this.getConfig().getStringList("simplemotd.secondline");
		int randomNum = ThreadLocalRandom.current().nextInt(0, messages.size());
		String secondline = ChatColor.translateAlternateColorCodes('&', messages.get(randomNum));
		
		e.setMotd(firstline + "\n" + ChatColor.WHITE + secondline);
	}
}
