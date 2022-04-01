package io.github.dadpea.texal.player.state;

import io.github.dadpea.texal.plots.Plot;
import org.bukkit.entity.Player;

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
    }

    @Override
    public void onExit(Player p) {

    }

    @Override
    public void onTick(Player p) {

    }
}
