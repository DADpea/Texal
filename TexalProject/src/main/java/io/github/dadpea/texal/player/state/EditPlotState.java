package io.github.dadpea.texal.player.state;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.plots.Plot;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

public class EditPlotState implements PlayerState {
    int id;
    Plot plot;

    public EditPlotState(Plot plot) {
        this.id = plot.getId();
        this.plot = plot;
    }

    @Override
    public void onEnter(TexalPlayer tp) {
        Player p = tp.getPlayer();
        plot.joinPlot(p);
        p.getInventory().clear();
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        p.setGameMode(GameMode.CREATIVE);
        p.setFlySpeed(0.1f);
        p.setWalkSpeed(0.2f);
        p.setExp(0f);
        p.setLevel(0);
        p.setHealth(20);
        p.setFlying(false);
    }

    @Override
    public void onExit(TexalPlayer tp) {
        Player p = tp.getPlayer();
    }

    @Override
    public void onTick(TexalPlayer tp) {
        Player p = tp.getPlayer();
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EditPlotState)) {
            return false;
        }
        EditPlotState ops = (EditPlotState) o;
        return ops.id == this.id;
    }

    @Override
    public boolean canEditItems() {
        return true;
    }
}
