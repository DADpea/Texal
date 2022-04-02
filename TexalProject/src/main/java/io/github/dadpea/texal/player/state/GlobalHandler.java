package io.github.dadpea.texal.player.state;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class GlobalHandler implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        TexalPlayer.create(e.getPlayer()).getState().onInteract(e); }
    @EventHandler
    public void onSwapHands(PlayerSwapHandItemsEvent e) { TexalPlayer.create(e.getPlayer()).getState().onSwapHands(e); }
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) { TexalPlayer.create(e.getPlayer()).getState().onRespawn(e); }
    @EventHandler
    public void onDropItem(PlayerDropItemEvent e) { TexalPlayer.create(e.getPlayer()).getState().onDropItem(e); }
    @EventHandler
    public void onSwapSlots(PlayerChangedMainHandEvent e) { TexalPlayer.create(e.getPlayer()).getState().onSwapSlots(e); }
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e) { TexalPlayer.create(e.getPlayer()).getState().onSneak(e); }
    @EventHandler
    public void onSprint(PlayerToggleSprintEvent e) { TexalPlayer.create(e.getPlayer()).getState().onSprint(e); }
    @EventHandler
    public void onDeath(PlayerDeathEvent e) { TexalPlayer.create(e.getEntity()).getState().onDeath(e); }
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player)
            TexalPlayer.create((Player) e.getEntity()).getState().onDamage(e);
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) { TexalPlayer.create(e.getPlayer()).getState().onBlockBreak(e); }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        TexalPlayer.create(e.getPlayer()).getState().onChat(e);
    }
}
