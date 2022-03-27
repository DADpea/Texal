package io.github.dadpea.texal.plots;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.Random;

// Represents a plot that the owner/devs can work on.
// Represents a world.
public class Plot {
    final static String plotPrefix = "plots/plot";
    static int nextID = 0; // Make sure to load this up!
    World world;
    PlotSize plotSize;
    Location spawnLoc;
    int id;

    public Plot(PlotSize s) {
        this(++nextID,s);
    }

    public Plot(int id, PlotSize s) {
        this.plotSize = s;
        this.id = id;
        WorldCreator wc = new WorldCreator(plotPrefix + id);
        wc.generator(new PlotChunkGenerator(plotSize));
        this.world = Bukkit.createWorld(wc);
        this.world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        this.world.setGameRule(GameRule.DO_TRADER_SPAWNING, false);
        this.world.setGameRule(GameRule.DISABLE_RAIDS, true);
        this.world.setGameRule(GameRule.SHOW_DEATH_MESSAGES, false);
        this.world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        this.world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        this.world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
        this.world.setGameRule(GameRule.DO_FIRE_TICK, false);
        this.world.setGameRule(GameRule.DO_INSOMNIA, false);
        this.world.setGameRule(GameRule.MOB_GRIEFING, false);
        this.world.setGameRule(GameRule.SPECTATORS_GENERATE_CHUNKS, false);
        this.world.setTime(6000L);
        this.world.setKeepSpawnInMemory(false);
        this.spawnLoc = new Location(world, 0, 1, 0);
    }

    public void joinWorld(Player p) {
        p.teleport(spawnLoc);
    }

    public int getID() {
        return this.id;
    }
}
