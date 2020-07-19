package me.lifelessnerd.kdbeventskb;


import org.bukkit.plugin.java.JavaPlugin;

public final class KDBEventsKB extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnPlayerMoveConcrete(), this);
        getServer().getPluginManager().registerEvents(new OnQuit(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
