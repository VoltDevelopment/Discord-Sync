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
    public void onPlayerTeleport(PlayerTeleportEvent event){
        Player player = event.getPlayer();
        Location location1 = event.getFrom();
        Location location2 = event.getTo();
        PlayerTeleportEvent.TeleportCause cause = event.getCause();


        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new EmbedObject().setColor(Color.MAGENTA).setTitle("New teleport").setDescription(player.getDisplayName() + " teleport info").addField("**From**", "" + location1, true).addField("**To**", "" + location2, true).addField("**Reason**", "" + cause, false));
        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

    }
}
