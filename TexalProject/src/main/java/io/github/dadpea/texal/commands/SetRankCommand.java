package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.TexalPlayer;
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

import java.util.List;

public class SetRankCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if (args.length<3) {
            sender.sendMessage(Prefix.PREFIX_FAILURE + "Not enough input.");
            return true;
        }

        Player playerName = Bukkit.getPlayer(args[0]);
        if (playerName==null) {
            sender.sendMessage(Prefix.PREFIX_FAILURE + "Not a player.");
            return true;
        }
        TexalPlayer p = TexalPlayer.create(playerName);

        Rank rank;
        try {
            rank = Rank.valueOf(args[1].toUpperCase());
        } catch (Exception e) {
            sender.sendMessage(Prefix.PREFIX_FAILURE + "Invalid rank.");
            return true;
        }

        if (args[2].equalsIgnoreCase("true")) {
            p.getRanks().addRank(rank);
        } else if (args[2].equalsIgnoreCase("false")) {
            p.getRanks().removeRank(rank);
        } else {
            sender.sendMessage(Prefix.PREFIX_FAILURE + "Invalid boolean.");
            return true;
        }

        sender.sendMessage(Prefix.PREFIX_SUCCESS + "Success.");

        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
