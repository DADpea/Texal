package io.github.dadpea.texal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlightspeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
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

        if (fs < 0) fs = 0;
        if (fs > 1000) fs = 1000;
        p.setFlySpeed(fs / 1000f);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Flightspeed set to: " + fs + "%.");
        return true;
    }
}
