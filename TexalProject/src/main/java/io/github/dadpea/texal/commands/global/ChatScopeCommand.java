package io.github.dadpea.texal.commands.global;

import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.chat.ScopeGlobal;
import io.github.dadpea.texal.chat.ScopeLocal;
import io.github.dadpea.texal.chat.ScopeNone;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.InvalidParameterError;
import io.github.dadpea.texal.commands.errors.MissingParameterError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChatScopeCommand extends GlobalCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        if (!(sender instanceof Player))
            throw new NoPermissionError();

        TexalPlayer p = TexalPlayer.create((Player) sender);
        if (args.length<1) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "/chat <Global/Local/None>");
            throw new MissingParameterError("Scope", "Global", "Local", "None");
        }

        if(args[0].equalsIgnoreCase("global") || args[0].equalsIgnoreCase("g")) {
            p.setChatScope(new ScopeGlobal());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to Global.");
        } else if (args[0].equalsIgnoreCase("local") || args[0].equalsIgnoreCase("l")) {
            p.setChatScope(new ScopeLocal());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to Local.");
        } else if (args[0].equalsIgnoreCase("none") || args[0].equalsIgnoreCase("n")) {
            p.setChatScope(new ScopeNone());
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Set chat to None.");
        } else {
            throw new InvalidParameterError("Scope", "Global", "Local", "None");
        }
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
