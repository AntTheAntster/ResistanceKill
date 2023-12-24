package uk.co.anttheantster.resistancekill.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
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
            if (level != 0){
                level = target.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() - 1;
                target.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                target.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE
                        .createEffect(resistanceKill.getConfig().getInt("Duration"), level));
            }
            return;
        }
        if (level != resistanceKill.getConfig().getInt("Max Level")){
            level = target.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier() + 1;

            target.addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE
                    .createEffect(resistanceKill.getConfig().getInt("Duration"), level));
        }
    }
}
