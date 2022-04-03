package io.github.dadpea.texal.commands.admin;

import io.github.dadpea.texal.commands.TexalCommand;
import io.github.dadpea.texal.commands.errors.CommandError;
import io.github.dadpea.texal.commands.errors.CustomError;
import io.github.dadpea.texal.commands.errors.PlayerOnlyError;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class UnloadWorldCommand extends AdminCommand {
    @Override
    public void runCommand(CommandSender sender, String[] args) throws CommandError {
        if (!(sender instanceof Player))
            throw new PlayerOnlyError();

        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Available worlds " + Bukkit.getServer().getWorlds());
            return;
        }
        if (Bukkit.getServer().getWorld(args[0]) == null) {
            throw new CustomError("World not loaded.");
        }
        p.sendMessage(Prefix.PREFIX_INFO + "Unloading " + args[0]);
        if(!(Bukkit.getServer().unloadWorld(Bukkit.getServer().getWorld(args[0]), true))) {
            throw new CustomError("Failed to unload.");
        }
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Unloaded " + args[0]);

    }

    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }
}
