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
        Scoreboard scoreboard = player.getScoreboard();
        Objective objective = scoreboard.getObjective("KBteam");

        assert objective != null : "Speler had geen score op " + objective.getName();
        //
        Score playerScore = objective.getScore(player);
        int playerScoreInt = playerScore.getScore();
        Bukkit.broadcastMessage(String.valueOf(playerScore));
        //

//        if (player.getWorld().getName().equalsIgnoreCase("kbevent")) {
//            if (playerScore.equals("1")) {
//
//            }
//
//        }
    }
}
