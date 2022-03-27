package io.github.dadpea.texal;

import io.github.dadpea.texal.commands.*;
import io.github.dadpea.texal.commands.itemManipulation.LoreLineCommand;
import io.github.dadpea.texal.commands.itemManipulation.RemoveLoreLine;
import io.github.dadpea.texal.commands.itemManipulation.RenameCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Texal extends JavaPlugin implements Listener {
    static Location spawnPoint;

    @Override
    public void onEnable() {
        spawnPoint =  new Location(Bukkit.getWorld("world"), 0.5, 2, 0.5);

        this.getCommand("fs").setExecutor(new FlightspeedCommand());
        this.getCommand("flightspeed").setExecutor(new FlightspeedCommand());

        this.getCommand("prefixtest").setExecutor(new PrefixTestCommand());

        this.getCommand("loadworld").setExecutor(new LoadWorldCommand()); // temp
        this.getCommand("unloadworld").setExecutor(new UnloadWorldCommand()); // temp

        this.getCommand("newplot").setExecutor(new NewPlotCommand()); // temp

        this.getCommand("sll").setExecutor(new LoreLineCommand());
        this.getCommand("rll").setExecutor(new RemoveLoreLine());
        this.getCommand("rename").setExecutor(new RenameCommand());

        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("");
        Player p = e.getPlayer();
        for (Player p1 : Bukkit.getOnlinePlayers()) {
            p.sendMessage(Prefix.PREFIX_SERVER_INFO + "" + p.getDisplayName() + " joined!");
        }
        p.teleport(spawnPoint);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
//            System.out.println(e.getBlock().getLocation());

    }
}
