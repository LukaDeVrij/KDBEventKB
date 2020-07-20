package me.lifelessnerd.kdbeventskb;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class OnPlayerMoveConcrete implements Listener {

    private KDBEventsKB plugin;

    public OnPlayerMoveConcrete() {
        this.plugin = plugin;

        Bukkit.getPluginManager();
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {


        Player player = event.getPlayer();
        if(player.getWorld().getName().equalsIgnoreCase("kbevent")) {
            Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
            Material blockMaterial = block.getType();
            Location loc = player.getLocation();

            if(blockMaterial == Material.GLOWSTONE) {

                Location redloc = new Location(Bukkit.getWorld("kbevent"), 1 , 86, 11);
                Location redloc2 = new Location(Bukkit.getWorld("kbevent"), 0, 86, 11);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "scoreboard players set " + player.getName() + " KBdeath 1");
                redloc.getBlock().setType(Material.REDSTONE_BLOCK);
                redloc2.getBlock().setType(Material.REDSTONE_BLOCK);
                event.getPlayer().getWorld().strikeLightning(loc);
                player.sendMessage(ChatColor.RED + "You died!");
            } else {
                //
            }

        }
        else {
            //
        }
    }
}