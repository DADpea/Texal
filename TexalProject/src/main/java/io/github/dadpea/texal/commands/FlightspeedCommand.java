package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.player.state.ServerBuildState;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightspeedCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        if (args.length==0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Expected input.");
            return true;
        }

        int fs;
        try {
            fs = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Input is not a number.");
            return true;
        }

        if (fs < -1000) fs = -1000;
        if (fs > 1000) fs = 1000;
        p.setFlySpeed(fs / 1000f);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Flightspeed set to: " + fs + "%.");
        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        if (!(sender instanceof Player)) return false;

        TexalPlayer p = TexalPlayer.create((Player) sender);
        return p.getState() instanceof EditPlotState || p.getState() instanceof ServerBuildState;
    }

    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("100", "1000");
        }
        return Collections.emptyList();
    }
}
