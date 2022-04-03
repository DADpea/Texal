package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
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
        if (args.length<1) throw new MissingParameterError("Player");
        if (args.length<2) {
            Rank[] vals = Rank.values();
            String[] out = new String[vals.length];
            for (int i = 0; i < Rank.values().length; i++) out[i] = vals[i].toString();
            throw new MissingParameterError("Rank", out);
        }
        if (args.length<3) throw new MissingParameterError("Status", "True", "False");


        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName==null) {
            throw new InvalidParameterError("Not a player");
        }
        TexalPlayer p = TexalPlayer.create(playerName);

        Rank rank;
        try {
            rank = Rank.valueOf(args[1].toUpperCase());
        } catch (Exception e) {
            Rank[] vals = Rank.values();
            String[] out = new String[vals.length];
            for (int i = 0; i < Rank.values().length; i++) out[i] = vals[i].toString();
            throw new InvalidParameterError("Invalid rank", out);
        }

        if (args[2].equalsIgnoreCase("true")) {
            p.getRanks().addRank(rank);
        } else if (args[2].equalsIgnoreCase("false")) {
            p.getRanks().removeRank(rank);
        } else {
            throw new InvalidParameterError("Status", "True", "False");
        }

        sender.sendMessage(Prefix.PREFIX_SUCCESS + "Success.");
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
