package io.github.dadpea.texal.player.state;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class PlayerState implements Listener {
    public void onEnter(Player p) {}
    public void onExit(Player p) {}
    public void onTick(Player p) {}
    @EventHandler
    public void onClick(PlayerInteractEvent e) {}
    @EventHandler
    public void onSwapHands(PlayerSwapHandItemsEvent e) {}
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {}
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) {}
    @EventHandler
    public void onSwapSlots(PlayerChangedMainHandEvent e) {}
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) {}
    @EventHandler
    public void onSprint(PlayerToggleSprintEvent e) {}
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {}
    @EventHandler
    public void onDamage(EntityDamageEvent e) {}
}
