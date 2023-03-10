package me.rodri.discordsync;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DiscordSync extends JavaPlugin {

    private String webhookurl = "https://discord.com/api/webhooks/1082849143640297562/WGrXvBluHAgIRry-pxWKUKPNThyGcIZOzBzbgZCTGdbPGob5pOz4C2UOqb8ZWDSZ8weL";

    @Override
    public void onEnable() {
        String pluginName = getDescription().getName();
        String message = ChatColor.GREEN + "Starting " + pluginName;
        getServer().getConsoleSender().sendMessage(message);

        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Volt Development discord");
        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "Join: https://dsc.gg/voltdev");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
