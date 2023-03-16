package me.rodri.discordsync.events;

import me.rodri.discordsync.DiscordSync;
import me.rodri.discordsync.DiscordWebhook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import java.awt.*;
import java.util.logging.Logger;

public class PlayerJoin implements Listener {

    private final Logger logger;

    public PlayerJoin(Logger logger) {
        this.logger = logger;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle("Player joined!").setDescription(event.getPlayer().getDisplayName() + " has joined the server!").setColor(Color.GREEN));
        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            logger.severe(e.getStackTrace().toString());
        }
    }
}
