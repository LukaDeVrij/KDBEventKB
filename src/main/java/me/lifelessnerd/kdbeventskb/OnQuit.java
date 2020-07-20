package me.lifelessnerd.kdbeventskb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class OnQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(final PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld().getName().equalsIgnoreCase("KBevent")) {

            Scoreboard scoreboard = player.getScoreboard();
            Objective objectiveKBteam = scoreboard.getObjective("KBteam");
            // idk what this does but the IDE said it so sure and it works so a je to i guess
            assert objectiveKBteam != null : "Speler had geen score op " + objectiveKBteam;
            //
            Score playerScoreKBteam = objectiveKBteam.getScore(player);
            int playerScoreKBteamInt = playerScoreKBteam.getScore();
            //
            Objective objectiveKBplayer = scoreboard.getObjective("KBplayer");
            assert objectiveKBplayer != null : "Speler had geen score op " + objectiveKBplayer;
            Score playerScoreKBplayer = objectiveKBplayer.getScore(player);
            int playerScoreKBplayerInt = playerScoreKBplayer.getScore();

            if (playerScoreKBteamInt == 1 | playerScoreKBteamInt == 2) {

                if (playerScoreKBplayerInt == 1) {
                    Bukkit.broadcastMessage(player.getName() + " had a score of 1 or 2: " + playerScoreKBteamInt);
                    // do stuff when player in team 1 or 2 quits
                    // kb player naar 0
                    // kbactive: currently remove -1
                }

            } else {
                Bukkit.broadcastMessage(player.getName() + " was not team 1 or 2");
            }
        }
    }
}
