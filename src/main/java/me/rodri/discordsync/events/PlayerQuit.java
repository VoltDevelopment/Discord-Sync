package me.rodri.discordsync.events;

import me.rodri.discordsync.DiscordSync;
import me.rodri.discordsync.DiscordWebhook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setTitle("Player Disconnected").setDescription(event.getPlayer() + " disconnected from the server." + event.getPlayer().getPlayerTime()).addField("Time played", "asd", false));

    }

}
