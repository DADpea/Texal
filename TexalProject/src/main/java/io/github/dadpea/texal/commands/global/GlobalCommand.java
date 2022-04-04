package io.github.dadpea.texal.commands.global;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import org.bukkit.command.CommandSender;


public abstract class GlobalCommand extends TexalCommand {

    @Override
    public final void permissionCheck(CommandSender sender) {
        return;
    }

    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;

}
