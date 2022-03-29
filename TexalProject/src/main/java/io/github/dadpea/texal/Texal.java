package io.github.dadpea.texal;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import io.github.dadpea.texal.events.*;
import io.github.dadpea.texal.plots.PlotPersistent;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.style.GlobalColors;
import io.github.dadpea.texal.commands.*;
import io.github.dadpea.texal.commands.itemManipulation.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.io.*;

public final class Texal extends JavaPlugin {
    public static Texal plugin;
    public static Location spawnPoint;
    public static Scoreboard spawnBoard;
    public static String scoreboardTitle = GlobalColors.TEAL + "" + ChatColor.BOLD + ">" + GlobalColors.GREEN + "" + ChatColor.BOLD + "  TEXAL  " + GlobalColors.TEAL + ChatColor.BOLD + "<";
    public static ServerPersistent persistentData;

    @Override
    public void onEnable() {
        this.plugin = this;
        spawnPoint =  new Location(Bukkit.getWorld("world"), 0.5, 2, 0.5);
        spawnBoard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = spawnBoard.registerNewObjective("spawnBoard", "dummy", scoreboardTitle);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore(" ").setScore(0);
        obj.getScore(ChatColor.GRAY + "Spawn" + ChatColor.DARK_GRAY + " - " + GlobalColors.WHITE + "Patio").setScore(1);
        obj.getScore("  ").setScore(2);

        registerCommands();
        registerEvents();
        loadPersistent();
    }

    @Override
    public void onDisable() {
        savePersistent();
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer(GlobalColors.RED + "The server is restarting!");
        }
    }

    private void registerCommands() {
        this.getCommand("fs").setExecutor(new FlightspeedCommand());
        this.getCommand("flightspeed").setExecutor(new FlightspeedCommand());

        this.getCommand("prefixtest").setExecutor(new PrefixTestCommand());

        this.getCommand("loadworld").setExecutor(new LoadWorldCommand()); // temp
        this.getCommand("unloadworld").setExecutor(new UnloadWorldCommand()); // temp

        this.getCommand("newplot").setExecutor(new NewPlotCommand()); // temp
        this.getCommand("joinplot").setExecutor(new JoinPlotCommand()); // temp

        this.getCommand("sll").setExecutor(new LoreLineCommand());
        this.getCommand("rll").setExecutor(new RemoveLoreLine());
        this.getCommand("rename").setExecutor(new RenameCommand());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new QuitEvent(), this);
    }

    private void loadPersistent() {
        try (Reader r = new FileReader("serverData.json")) {
            Gson g = new Gson();
            persistentData = g.fromJson(r, ServerPersistent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void savePersistent() {
        try (Writer r = new FileWriter("serverData.json")) {
            Gson g = new Gson();
            g.toJson(persistentData, ServerPersistent.class, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
