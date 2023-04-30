package me.rodri.discordsync;

import me.rodri.discordsync.events.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class DiscordSync extends JavaPlugin {

    public static String webhookurl = "https://your.webhook/url";

    @Override
    public void onEnable() {
        String pluginName = getDescription().getName();
        String message = ChatColor.GREEN + "Initializing " + pluginName;
        getServer().getConsoleSender().sendMessage(message);

        getServer().getConsoleSender().sendMessage("------------------------------");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "DiscordSync " + ChatColor.YELLOW + "Volt Development");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Join: https://dsc.gg/voltdev");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Authors: " + ChatColor.WHITE + "rodri");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage( ChatColor.GOLD + "Checking license status...");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "License: " + ChatColor.GREEN + "Valid");
        getServer().getConsoleSender().sendMessage("------------------------------");

        getServer().getPluginManager().registerEvents(new EventListeners(), this);

        DiscordWebhook webhook = new DiscordWebhook(webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("The server is starting").addField("Port", getServer().getPort() + "",false).addField("Version", getServer().getVersion() + "", false).addField("Spigot/Bukkit", getServer().getBukkitVersion() + "", false).setColor(Color.GREEN));
        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

        //Listeners
        getServer().getPluginManager().registerEvents(new PlayerListeners(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);

        //Commands
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        String pluginName = getDescription().getName();

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Disabling " + pluginName);
        getServer().getConsoleSender().sendMessage("------------------------------");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "DiscordSync " + ChatColor.YELLOW + "Volt Development");
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "Join: https://dsc.gg/voltdev");
        getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "Authors: " + ChatColor.WHITE + "rodri");
        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage( ChatColor.GOLD + "Plugin is shutting down...");
        getServer().getConsoleSender().sendMessage("------------------------------");

        DiscordWebhook webhook = new DiscordWebhook(webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("The server is shutting down!").setColor(Color.RED).setTitle("Server has been stopped!"));
        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

    }
}
