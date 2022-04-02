package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.style.Prefix;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewPlotCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;

        if (args.length==0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Expected input.");
            return true;
        }
        PlotSize plotsize = PlotSize.SMALL;
        if (args[0].toLowerCase().equals("medium")) plotsize = PlotSize.MEDIUM;
        if (args[0].toLowerCase().equals("large")) plotsize = PlotSize.LARGE;
        Plot plot = Plot.createNewPlot(plotsize, p);
        TexalPlayer.create(p).setState(new EditPlotState(plot));
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Joined plot: " + plot.getId() + ".");
        return true;
    }
}
