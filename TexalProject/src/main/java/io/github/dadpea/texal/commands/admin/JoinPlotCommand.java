package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.*;
import io.github.dadpea.texal.commands.errors.InternalError;
import io.github.dadpea.texal.commands.parameter.IntParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.plots.exceptions.NoSuchPlotException;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class JoinPlotCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        IntParameter idParam = pl.add(new IntParameter());
        pl.testAgainst(args);

        int id = idParam.getValue();

        Plot plot;
        try {
            plot = new Plot(id);
        } catch(NoSuchPlotException e) {
            throw new CustomError("Invalid ID.");
        } catch (MalformedDataException e) {
            Texal.plugin.getLogger().severe("Malformed data received on plot " + id);
            throw new InternalError();
        }

        p.setState(new EditPlotState(plot));
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new IntParameter());
        return pl.tabComplete(args);
    }
}
