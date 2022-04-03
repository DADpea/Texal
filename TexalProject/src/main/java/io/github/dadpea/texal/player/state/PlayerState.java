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

public interface PlayerState extends Listener {
    void onEnter(TexalPlayer p);
    void onExit(TexalPlayer p);
    void onTick(TexalPlayer p);
    void onInteract(PlayerInteractEvent e);
    void onSwapHands(PlayerSwapHandItemsEvent e);
    void onRespawn(PlayerRespawnEvent e);
    void onDropItem(PlayerDropItemEvent e);
    void onSwapSlots(PlayerChangedMainHandEvent e);
    void onSneak(PlayerToggleSneakEvent e);
    void onSprint(PlayerToggleSprintEvent e);
    void onDeath(PlayerDeathEvent e);
    void onDamage(EntityDamageEvent e);
    void onBlockBreak(BlockBreakEvent e);
    void onChat(AsyncPlayerChatEvent e);

}
