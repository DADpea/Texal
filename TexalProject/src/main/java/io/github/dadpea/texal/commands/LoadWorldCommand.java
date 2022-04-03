package io.github.dadpea.texal.commands;

import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class LoadWorldCommand extends TexalCommand {
    @Override
    public boolean runCommand(CommandSender sender, String[] args) {
        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;
        if (args.length==0) {
            p.sendMessage(Prefix.PREFIX_FAILURE + "Need world name.");
            return true;
        }

        final WorldCreator worldC = new WorldCreator(args[0]);
        World checkWorld = Bukkit.getServer().getWorld(args[0]);
        if (!(checkWorld == null)) {
            p.sendMessage(Prefix.PREFIX_SUCCESS + "Teleported!");
            p.teleport(new Location(checkWorld, 0, 50, 0));
            return true;
        }

        worldC.generateStructures(false);
        p.sendMessage(Prefix.PREFIX_INFO + "Loading world " + args[0]);
        final World world = Bukkit.getServer().createWorld(worldC);

        System.out.println(Bukkit.getServer().getWorlds());
        p.teleport(new Location(world, 0, 50, 0));
        p.sendMessage(Prefix.PREFIX_SUCCESS + "Teleported!");
        return true;
    }
    public boolean hasPermissions(CommandSender sender) {
        return true;
    }
    public List<String> tabComplete(CommandSender sender, Command command, String label, String[] args) {
        return null;
    }

}
