package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.TexalPlayer;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.NoPermissionError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.commands.parameter.ParameterList;
import io.github.dadpea.texal.ranks.Rank;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public abstract class TexalCommand implements CommandExecutor, TabCompleter {

    @Override
    final public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        try {
            if (permissionLevel(sender) < Rank.ADMIN.getImportance()) permissionCheck(sender);
            runCommand(sender, args);
            return true;
        } catch (CommandError e) {
            sender.sendMessage(e.toString());
            return true;
        }
    }

    public abstract void permissionCheck(CommandSender sender) throws CommandError;
    public abstract void runCommand(CommandSender sender, String[] args) throws CommandError;

    @Override
    final public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (permissionLevel(sender) < Rank.ADMIN.getImportance()) permissionCheck(sender);
            List<String> out = tabComplete(sender, command, label, args);
            return out;
        } catch (CommandError e) {
            return Collections.emptyList();
        }
    }

    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return Collections.emptyList();
    }

    @SuppressWarnings("all")
    public static void registerCommand(TexalCommand executor, String command) {
        Texal.plugin.getCommand(command).setExecutor(executor);
        Texal.plugin.getCommand(command).setTabCompleter(executor);
    }

    protected static int permissionLevel(CommandSender sender) {
        if (sender instanceof Player) {
            TexalPlayer p = TexalPlayer.create((Player) sender);
            return p.getRanks().getImportance();
        } else if (sender instanceof ConsoleCommandSender) {
            return Rank.ADMIN.getImportance();  // Console == admin.
        } else {
            return 0;   // Command blocks and others have no permission level.
        }
    }

    protected static TexalPlayer playerOnly(CommandSender s) throws PlayerOnlyError {
        if (!(s instanceof Player))
            throw new PlayerOnlyError();
        return TexalPlayer.create((Player) s);
    }
}
