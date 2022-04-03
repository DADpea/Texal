package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.player.state.EditPlotState;
import io.github.dadpea.texal.player.state.ServerBuildState;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class ServerBuildCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        if (!(sender instanceof Player))
            throw new PlayerOnlyError();

        Player p = (Player) sender;
        TexalPlayer.create(p).setState(new ServerBuildState());
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Now in server build.");
        return;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) { return Collections.emptyList(); }
}
