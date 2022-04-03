package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.style.Prefix;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class NewPlotCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        if(!(sender instanceof Player))
            throw new PlayerOnlyError();

        Player p = (Player) sender;

        if (args.length==0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Expected input.");
            throw new MissingParameterError("Plot Size", "Small", "Medium", "Large");
        }
        PlotSize plotsize = PlotSize.SMALL;
        if (args[0].toLowerCase().equals("medium")) plotsize = PlotSize.MEDIUM;
        if (args[0].toLowerCase().equals("large")) plotsize = PlotSize.LARGE;

        Plot plot = Plot.createNewPlot(plotsize, p);
        TexalPlayer.create(p).setState(new EditPlotState(plot));
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Joined plot: " + plot.getId() + ".");
        return;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
