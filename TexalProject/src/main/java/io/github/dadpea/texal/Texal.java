package io.github.dadpea.texal;

import com.google.gson.Gson;
import io.github.dadpea.texal.commands.admin.*;
import io.github.dadpea.texal.commands.editing.items.*;
import io.github.dadpea.texal.commands.global.ChatScopeCommand;
import io.github.dadpea.texal.commands.global.LeaveCommand;
import io.github.dadpea.texal.player.state.GlobalHandler;
import io.github.dadpea.texal.player.state.LobbyState;
import io.github.dadpea.texal.player.state.PlayerState;
import io.github.dadpea.texal.style.GlobalColors;
import io.github.dadpea.texal.commands.*;
import io.github.dadpea.texal.commands.editing.*;
import io.github.dadpea.texal.style.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.io.*;

public final class Texal extends JavaPlugin implements Listener {
    public static Texal plugin;
    public static Location spawnPoint;
    public static Scoreboard spawnBoard;
    public static String scoreboardTitle = GlobalColors.TEAL + "" + ChatColor.BOLD + ">" + GlobalColors.GREEN + "" + ChatColor.BOLD + "  TEXAL  " + GlobalColors.TEAL + ChatColor.BOLD + "<";
    public static ServerPersistent persistentData;

     @Override
    public void onEnable() {
        plugin = this;
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

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, this::tick, 0, 1);
    }

    @Override
    public void onDisable() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.kickPlayer(GlobalColors.RED + "The server is restarting!");
        }
        savePersistent();
    }

    @SuppressWarnings("all")
    private void registerCommands() {
        TexalCommand.registerCommand(new FlightspeedCommand(), "flightspeed");
        TexalCommand.registerCommand(new NewPlotCommand(), "newplot"); // temp
        TexalCommand.registerCommand(new JoinPlotCommand(), "joinplot"); // temp
        TexalCommand.registerCommand(new LeaveCommand(), "spawn");
        TexalCommand.registerCommand(new ServerBuildCommand(), "svbuild");
        TexalCommand.registerCommand(new LoreLineCommand(), "sll");
        TexalCommand.registerCommand(new RemoveLoreLine(), "rll");
        TexalCommand.registerCommand(new RenameCommand(), "rename");
        TexalCommand.registerCommand(new SetRankCommand(), "setrank");
        TexalCommand.registerCommand(new ChatScopeCommand(), "c");
        TexalCommand.registerCommand(new EnchantCommand(), "enchant");
        TexalCommand.registerCommand(new HideFlagsCommand(), "hideflags");
        TexalCommand.registerCommand(new ReloadCommand(), "rd");
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new GlobalHandler(), this);
    }

    private void loadPersistent() {
        try (Reader r = new FileReader("serverData.json")) {
            Gson g = new Gson();
            persistentData = g.fromJson(r, ServerPersistent.class);
        } catch (Exception e) {
            persistentData = new ServerPersistent();
            e.printStackTrace();
        }
    }

    private void savePersistent() {
        try (Writer r = new FileWriter("serverData.json")) {
            Gson g = new Gson();
            if (persistentData!=null) {
                g.toJson(persistentData, ServerPersistent.class, r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void tick() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            PlayerState s = TexalPlayer.create(p).getState();
            if (s != null) {
                s.onTick(TexalPlayer.create(p));
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        TexalPlayer.create(e.getPlayer()).setState(new LobbyState());
        e.setJoinMessage("");
        Player p = e.getPlayer();
        for (Player p1 : Bukkit.getOnlinePlayers()) {
            p1.sendMessage(Prefix.PREFIX_SERVER_INFO + "" + p.getDisplayName() + " joined!");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");

        Player p = e.getPlayer();
        TexalPlayer tp = TexalPlayer.create(p);

        for (Player p1 : Bukkit.getOnlinePlayers()) {
            p1.sendMessage(Prefix.PREFIX_SERVER_INFO + "" + p.getDisplayName() + " left.");
        }

        tp.saveData();
        tp.decache();
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        TexalPlayer tp = TexalPlayer.create(e.getPlayer());
        tp.getChatScope().sendMessage(tp, e.getMessage());
    }
}
