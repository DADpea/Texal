package io.github.dadpea.texal.player.state;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class ServerBuildState implements PlayerState{

    @Override
    public void onEnter(Player p) {
        p.setGameMode(GameMode.CREATIVE);
    }

    @Override
    public void onExit(Player p) {

    }

    @Override
    public void onTick(Player p) {

    }

    @Override
    public void onInteract(PlayerInteractEvent e) {

    }

    @Override
    public void onSwapHands(PlayerSwapHandItemsEvent e) {

    }

    @Override
    public void onRespawn(PlayerRespawnEvent e) {

    }

    @Override
    public void onDropItem(PlayerDropItemEvent e) {

    }

    @Override
    public void onSwapSlots(PlayerChangedMainHandEvent e) {

    }

    @Override
    public void onSneak(PlayerToggleSneakEvent e) {

    }

    @Override
    public void onSprint(PlayerToggleSprintEvent e) {

    }

    @Override
    public void onDeath(PlayerDeathEvent e) {

    }

    @Override
    public void onDamage(EntityDamageEvent e) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent e) {

    }

    @Override
    public void onChat(AsyncPlayerChatEvent e) {

    }
}
