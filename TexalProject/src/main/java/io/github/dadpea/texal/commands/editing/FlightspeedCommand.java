package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.commands.parameter.IntParameter;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.commands.parameter.StringParameter;
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
        TexalPlayer p = playerOnly(sender);

        ParameterList pl = new ParameterList();
        IntParameter lineNum = pl.add(new IntParameter());
        pl.testAgainst(args);

        int fs = lineNum.getValue();

        if (fs < -1000) fs = -1000;
        if (fs > 1000) fs = 1000;
        p.getPlayer().setFlySpeed(fs / 1000f);
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Flightspeed set to: " + fs + "%.");
    }

    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        ParameterList pl = new ParameterList();
        pl.add(new IntParameter());
        return pl.tabComplete(args);
    }
}
