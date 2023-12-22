package uk.co.anttheantster.resistancekill;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.resistancekill.commands.ReloadConfig;
import uk.co.anttheantster.resistancekill.listeners.PlayerKill;

public class ResistanceKill extends JavaPlugin {

    PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setup();
    }

    private void setup(){
        saveDefaultConfig();

        pm.registerEvents(new PlayerKill(this), this);
        getCommand("rkreload").setExecutor(new ReloadConfig(this));
    }
}
