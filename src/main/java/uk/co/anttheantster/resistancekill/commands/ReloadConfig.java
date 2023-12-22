package uk.co.anttheantster.resistancekill.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.anttheantster.resistancekill.ResistanceKill;

public class ReloadConfig implements CommandExecutor {

    private ResistanceKill resistanceKill;
    public ReloadConfig(ResistanceKill resistanceKill){
        this.resistanceKill = resistanceKill;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("rkreload")){
            if (sender.hasPermission("rkreload")){
                resistanceKill.reloadConfig();
                return false;
            }
            return false;
        }
        return false;
    }
}
