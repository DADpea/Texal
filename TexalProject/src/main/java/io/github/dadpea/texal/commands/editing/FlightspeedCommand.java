package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlightspeedCommand extends EditingCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        if (!(sender instanceof Player))
            throw new PlayerOnlyError();

        Player p = (Player) sender;
        if (args.length==0) {
            throw new MissingParameterError("Flight speed");
        }

        int fs;
        try {
            fs = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new InvalidParameterError("Flight speed");
        }

        if (fs < -1000) fs = -1000;
        if (fs > 1000) fs = 1000;
        p.setFlySpeed(fs / 1000f);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Flightspeed set to: " + fs + "%.");
        return;
    }

    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("100", "1000");
        }
        return Collections.emptyList();
    }
}
