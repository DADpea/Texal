package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Collections;
import java.util.List;

public abstract class TexalCommand implements CommandExecutor, TabCompleter {

    @Override
    final public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!hasPermissions(sender)) {
            sender.sendMessage(Prefix.PREFIX_FAILURE + "No permission.");
            return true;
        }
        return runCommand(sender, args);
    }

    public abstract boolean hasPermissions(CommandSender sender);
    public abstract boolean runCommand(CommandSender sender, String[] args);


    @Override
    final public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (!hasPermissions(sender)) return Collections.emptyList();
        return tabComplete(sender, command, label, args);
    }

    public abstract List<String> tabComplete(CommandSender sender, Command command, String label, String[] args);

    @SuppressWarnings("all")
    public static <T extends TexalCommand> void registerCommand(T executor, String command) {
        Texal.plugin.getCommand(command).setExecutor(executor);
        Texal.plugin.getCommand(command).setTabCompleter(executor);
    }
}
