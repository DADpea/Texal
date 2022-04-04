package io.github.dadpea.texal.commands.global;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
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

import java.util.Collections;
import java.util.List;

public class LeaveCommand extends GlobalCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws PlayerOnlyError {
        playerOnly(sender).setState(new LobbyState());
    }
}
