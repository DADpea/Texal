package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
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

        Plot plot = new Plot(PlotSize.LARGE);
        plot.joinWorld(p);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Joined plot: " + plot.getID() + ".");
        return true;
    }

}
