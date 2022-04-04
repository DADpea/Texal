package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.commands.parameter.EnumParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.commands.parameter.StringParameter;
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
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        EnumParameter<PlotSize> sizeParam = pl.add(new EnumParameter<>(PlotSize.class));
        pl.testAgainst(args);

        Plot plot = Plot.createNewPlot(sizeParam.getValue(), p.getPlayer());
        p.setState(new EditPlotState(plot));
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Joined plot: " + plot.getId() + ".");
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new EnumParameter<>(PlotSize.class));
        return pl.tabComplete(args);
    }
}
