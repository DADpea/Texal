package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.player.state.LobbyState;
import io.github.dadpea.texal.plots.Plot;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.plots.exceptions.NoSuchPlotException;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;

        Texal.setPlayerState(p, new LobbyState());
        return true;
    }
}
