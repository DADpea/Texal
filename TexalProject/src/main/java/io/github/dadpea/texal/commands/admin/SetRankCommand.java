package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.parameter.*;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.PlotSize;
import io.github.dadpea.texal.ranks.Rank;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetRankCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        ParameterList pl = new ParameterList();
        PlayerParameter playerParam = pl.add(new PlayerParameter());
        EnumParameter<Rank> rankParam = pl.add(new EnumParameter<>(Rank.class));
        BooleanParameter boolParam = pl.add(new BooleanParameter());
        pl.testAgainst(args);

        if (boolParam.getValue()) {
            playerParam.getValue().getRanks().addRank(rankParam.getValue());
        } else {
            playerParam.getValue().getRanks().removeRank(rankParam.getValue());
        }

        sender.sendMessage(Prefix.PREFIX_SUCCESS + "Success.");
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new PlayerParameter());
        pl.add(new EnumParameter<>(Rank.class));
        pl.add(new BooleanParameter());
        return pl.tabComplete(args);
    }
}
