package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.chat.ScopeGlobal;
import io.github.dadpea.texal.chat.ScopeLocal;
import io.github.dadpea.texal.chat.ScopeNone;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatScopeCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return false;

        TexalPlayer p = TexalPlayer.create((Player) sender);
        if (args.length<1) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "/chat <Global/Local/None>");
            return true;
        }

        if(args[0].equalsIgnoreCase("global") || args[0].equalsIgnoreCase("g")) {
            p.setChatScope(new ScopeGlobal());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to Global.");
            return true;
        } else if (args[0].equalsIgnoreCase("local") || args[0].equalsIgnoreCase("l")) {
            p.setChatScope(new ScopeLocal());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to Local.");
            return true;
        } else if (args[0].equalsIgnoreCase("none") || args[0].equalsIgnoreCase("n")) {
            p.setChatScope(new ScopeNone());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to None.");
            return true;
        } else {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Invalid chat scope. Use /chat <Global/Local/None>");
            return true;
        }
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
