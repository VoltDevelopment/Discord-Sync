package me.rodri.discordsync.events;

import me.rodri.discordsync.DiscordSync;
import me.rodri.discordsync.DiscordWebhook;
import org.bukkit.Achievement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

import static org.bukkit.Bukkit.getLogger;

public class PlayerListeners implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setColor(Color.green).setTitle("Player join").setDescription(player.getDisplayName() + " has joined the server"));

        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setColor(Color.red).setTitle("Player leave").setDescription(player.getDisplayName() + " has left the server"));

        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }

    }


    @EventHandler //Player Death webhook
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setColor(Color.orange).setTitle("Player death").setDescription(event.getDeathMessage()));

        try {
            webhook.execute();
        }
        catch (java.io.IOException e){
            getLogger().severe(e.getStackTrace().toString());
        }


    }

    @EventHandler //Player Achievement webhook
    public void onAchievementGet(PlayerAchievementAwardedEvent event) {
        Player player = event.getPlayer();
        Achievement achievement = event.getAchievement();

        DiscordWebhook webhook = new DiscordWebhook(DiscordSync.webhookurl);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setColor(Color.YELLOW)
                .setTitle("Achievement unlocked")
                .setDescription(player.getName() + " has unlocked the achievement " + achievement.name()));

        try {
            webhook.execute();
        } catch (java.io.IOException e) {
            getLogger().severe(e.getStackTrace().toString());
        }
    }




}
