package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import io.github.dadpea.texal.ranks.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class AdminCommand extends TexalCommand {
    @Override
    public final void permissionCheck(CommandSender sender) throws NoPermissionError {
        throw new NoPermissionError();
    }

    @Override
    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;

}
