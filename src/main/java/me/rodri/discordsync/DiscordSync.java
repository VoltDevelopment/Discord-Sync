package me.rodri.discordsync;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class DiscordSync extends JavaPlugin {

    private String webhookurl = "https://discord.com/api/webhooks/1083970473777430679/P7GNYieX4psAnBjmyFTR_DTl1qwIRYuIxi_JILKOiIxr9qarzj1M-OcnXOw1ddAdHafd";

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
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("The server is starting at port: " + getServer().getPort() + "\n Version: " + getServer().getVersion() + "\n Bukkit Version: " + getServer().getBukkitVersion()).setColor(Color.GREEN).setTitle("Server is starting!"));
        try {
            webhook.execute();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
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
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

    }
}
