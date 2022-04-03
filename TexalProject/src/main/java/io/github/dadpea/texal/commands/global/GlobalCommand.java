package io.github.dadpea.texal.commands.global;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class GlobalCommand extends TexalCommand {

    @Override
    public final void permissionCheck(CommandSender sender) {
        return;
    }

    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;
    public abstract List<String> tabComplete(CommandSender sender, Command command, String label, String[] args);
}
