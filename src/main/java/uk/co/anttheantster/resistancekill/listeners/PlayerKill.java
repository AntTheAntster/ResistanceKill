package uk.co.anttheantster.resistancekill.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffectType;
import uk.co.anttheantster.resistancekill.ResistanceKill;

public class PlayerKill implements Listener {

    private ResistanceKill resistanceKill;
    public PlayerKill(ResistanceKill resistanceKill){
        this.resistanceKill = resistanceKill;
    }

    public int level = 0;

    @EventHandler
    public void playerKill(PlayerDeathEvent e){
        Player target = e.getEntity().getKiller();

        if (e.getEntity() == target){
            level = 0;
            return;
        }
        level = level + 1;

        target.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE
                .createEffect(resistanceKill.getConfig().getInt("Duration"), level));

    }

}
