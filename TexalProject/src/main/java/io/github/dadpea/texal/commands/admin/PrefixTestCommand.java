package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static io.github.dadpea.texal.style.Prefix.*;

public class PrefixTestCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        sender.sendMessage(PREFIX_SUCCESS + "Success message");
        sender.sendMessage(PREFIX_FAILURE + "Failure message");
        sender.sendMessage(PREFIX_INFO + "Info message");
        sender.sendMessage(PREFIX_SERVER_INFO + "Server Info message");
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
