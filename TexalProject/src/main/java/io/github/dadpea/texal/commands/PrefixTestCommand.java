package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static io.github.dadpea.texal.style.Prefix.*;

public class PrefixTestCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        p.sendMessage(PREFIX_SUCCESS + "Success message");
        p.sendMessage(PREFIX_FAILURE + "Failure message");
        p.sendMessage(PREFIX_INFO + "Info message");
        p.sendMessage(PREFIX_SERVER_INFO + "Server Info message");
        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
