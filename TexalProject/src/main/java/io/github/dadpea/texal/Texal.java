package io.github.dadpea.texal;

import io.github.dadpea.texal.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Texal extends JavaPlugin implements Listener {
    static Location spawnPoint;

    @Override
    public void onEnable() {
        spawnPoint =  new Location(Bukkit.getWorld("world"), 0.5, 1, 0.5);

        this.getCommand("fs").setExecutor(new FlightspeedCommand());
        this.getCommand("flightspeed").setExecutor(new FlightspeedCommand());

        this.getCommand("prefixTest").setExecutor(new PrefixTestCommand());

        this.getCommand("worldTest").setExecutor(new WorldTestCommand()); // temp
        this.getCommand("unloadWorld").setExecutor(new UnloadWorldCommand()); // temp

        this.getCommand("newplot").setExecutor(new NewPlotCommand()); // temp

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
}
