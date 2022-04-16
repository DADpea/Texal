package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.errors.CommandError;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends AdminCommand {

    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        TexalPlayer p = playerOnly(sender);
        p.getPlayer().performCommand("reload confirm");
    }
}
