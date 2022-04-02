package io.github.dadpea.texal.player.state;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.plots.Plot;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EditPlotState extends PlayerState {
    int id;
    Plot plot;

    public EditPlotState(Plot plot) {
        this.id = plot.getId();
        this.plot = plot;
    }

    @Override
    public void onEnter(Player p) {
        plot.joinPlot(p);
        p.getInventory().clear();
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        p.setGameMode(GameMode.CREATIVE);
        p.teleport(Texal.spawnPoint);
        p.setFlySpeed(0.1f);
        p.setWalkSpeed(0.2f);
        p.setExp(0f);
        p.setLevel(0);
        p.setHealth(20);
        p.setFlying(false);
    }

    @Override
    public void onExit(Player p) {

    }

    @Override
    public void onTick(Player p) {

    }
}
