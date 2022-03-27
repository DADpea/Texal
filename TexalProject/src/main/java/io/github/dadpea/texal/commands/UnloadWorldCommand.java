package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnloadWorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {


        if (!(sender instanceof Player)) {
            return false;
        }

        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Available worlds " + Bukkit.getServer().getWorlds());
            return true;
        }
        if (Bukkit.getServer().getWorld(args[0]) == null) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "World not loaded.");
            return true;
        }
        p.sendMessage(Prefix.PREFIX_INFO + "Unloading " + args[0]);
        if(!(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(args[0]), true))) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Failed to unload " + args[0]);
            return true;
        }
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Unloaded " + args[0]);
        return true;
    }
}
