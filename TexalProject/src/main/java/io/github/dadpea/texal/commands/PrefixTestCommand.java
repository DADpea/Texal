package io.github.dadpea.texal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static io.github.dadpea.texal.style.Prefix.*;

public class PrefixTestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        p.sendMessage(PREFIX_SUCCESS + "Success message");
        p.sendMessage(PREFIX_FAILURE + "Failure message");
        p.sendMessage(PREFIX_INFO + "Info message");
        return true;
    }
}
