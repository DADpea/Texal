package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
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

import java.util.List;

public class LeaveCommand extends TexalCommand{
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;

        TexalPlayer.create(p).setState(new LobbyState());
        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
