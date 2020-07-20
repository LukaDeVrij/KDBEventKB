package me.lifelessnerd.kdbeventskb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public class OnQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (player.getWorld().getName().equalsIgnoreCase("KBevent")) {

            Scoreboard scoreboard = player.getScoreboard();
            Objective objective = scoreboard.getObjective("KBteam");
            // idk what this does but the IDE said it so sure and it works so a je to i guess
            assert objective != null : "Speler had geen score op " + objective.getName();
            //
            Score playerScore = objective.getScore(player);
            int playerScoreInt = playerScore.getScore();

            if (playerScoreInt == 1 | playerScoreInt == 2) {
                Bukkit.broadcastMessage(player + " had a score of 1 or 2: " + playerScoreInt);
                // do stuff when player in team 1 or 2 quits
            } else {
                Bukkit.broadcastMessage(player + " was not team 1 or 2");
            }
        }
    }
}
