package io.github.dadpea.texal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlightspeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            try {
                float fs = Integer.parseInt(args[0]) / 1000f ; // get percent
                p.sendMessage("" + fs);
                if (fs < 0) fs = 0;
                if (fs > 1) fs = 1;

                p.setFlySpeed(fs);
                p.sendMessage(Prefix.PREFIX_SUCCESS + "Flightspeed set to: " + (fs * 1000) + "%.");

            } catch (Exception e) {
                p.sendMessage(Prefix.PREFIX_FAILURE + "Malformed command.");
            }
            return true;
        }

        return false;
    }
}