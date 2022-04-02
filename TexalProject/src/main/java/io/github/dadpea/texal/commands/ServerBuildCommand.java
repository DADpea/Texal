package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.player.state.ServerBuildState;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ServerBuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        TexalPlayer.create(p).setState(new ServerBuildState());
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Now in server build.");
        return true;
    }
}
