package io.github.dadpea.texal.commands;

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
        if (args[0].equals("MEDIUM")) plotsize = PlotSize.MEDIUM;
        if (args[0].equals("LARGE")) plotsize = PlotSize.LARGE;
        Plot plot = new Plot(plotsize);
        plot.joinWorld(p);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Joined plot: " + plot.getID() + ".");
        return true;
    }
}
