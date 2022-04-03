package io.github.dadpea.texal.commands.editing;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class EditingCommand extends TexalCommand {
    @Override
    public final void permissionCheck(CommandSender sender) throws NoPermissionError {
        if (!(sender instanceof Player))
            throw new NoPermissionError();
    }

    @Override
    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;

    @Override
    public abstract List<String> tabComplete(CommandSender sender, Command command, String label, String[] args);
}
