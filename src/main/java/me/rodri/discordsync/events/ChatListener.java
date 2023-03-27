package me.rodri.discordsync.events;

import com.avaje.ebeaninternal.server.cluster.mcast.Message;
import me.rodri.discordsync.DiscordSync;
import me.rodri.discordsync.DiscordWebhook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.awt.*;

import static org.bukkit.Bukkit.getLogger;

public class ChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setColor(Color.red).setTitle("New chat message").setDescription(player.getDisplayName() +  " " + message));

        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }



    }

}
