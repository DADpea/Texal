package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.plots.exceptions.NoSuchPlotException;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinPlotCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        if (args.length==0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Expected input.");
            return true;
        }

        int id;
        try {
            id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Input is not a number.");
            return true;
        }
        Plot plot;
        try {
            plot = new Plot(id);
        } catch(NoSuchPlotException e) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Invalid ID.");
            return true;
        } catch (MalformedDataException e) {
            Texal.plugin.getLogger().severe("Malformed data received on plot " + id);
            p.sendMessage(Prefix.PREFIX_FAILURE + "Internal error, contact admins.");
            return true;
        }

        plot.joinPlot(p);
        return true;
    }
}
