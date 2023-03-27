package me.rodri.discordsync.events;

import me.rodri.discordsync.DiscordSync;
import me.rodri.discordsync.DiscordWebhook;
import me.rodri.discordsync.DiscordWebhook.EmbedObject;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.awt.*;

import static org.bukkit.Bukkit.getLogger;

public class TeleportListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        Location location1 = event.getFrom();
        Location location2 = event.getTo();
        PlayerTeleportEvent.TeleportCause cause = event.getCause();

        String fromLocationString = String.format("World: %s" + "X: %.2f  Y: %.2f  Z: %.2f",
                location1.getWorld().getName(), location1.getX(), location1.getY(), location1.getZ());
        String toLocationString = String.format("World: %s" + "X: %.2f  Y: %.2f  Z: %.2f",
                location2.getWorld().getName(), location2.getX(), location2.getY(), location2.getZ());
        String tpstring =  "" + player.getDisplayName() + " teleport info " + "From: " + fromLocationString + " To: " + toLocationString;

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new EmbedObject()
                .setColor(Color.MAGENTA)
                .setTitle("New teleport")
                .setDescription(tpstring));

        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }
    }
}
