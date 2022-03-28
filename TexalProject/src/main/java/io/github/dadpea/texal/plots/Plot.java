package io.github.dadpea.texal.plots;

import io.github.dadpea.texal.plots.exceptions.NoSuchPlotException;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Plot {
    final static String plotPrefix = "plots/plot";
    static int nextID = 0; // The next ID that needs to be created // Make sure to load this up!
    static Queue<Integer> openIDs; // Any unclaimed plot IDs that are now open
    private static HashMap<Integer, Plot> loadedPlots = new HashMap<Integer, Plot>();

    private void loadPlot() {
        loadedPlots.put(this.getId(), this);
    }
    private void createPlot() {

    }
    private void unloadPlot() {
        loadedPlots.remove(this.getId());
    }

    public static Plot createNewPlot(PlotSize size, Player owner) {
        int plotID;
        if (openIDs.size()>0) {
            plotID = openIDs.remove();
        } else {
            plotID = nextID;
            nextID++;
        }
        return new Plot(plotID, size, owner);
    }

    public static Plot getPlot(int id) throws NoSuchPlotException {
        if (loadedPlots.containsKey(id)) {
            return loadedPlots.get(id);
        } else if (Bukkit.getWorld(plotPrefix + id) != null) {
            Plot p = new Plot(id);
            loadedPlots.put(id, p);
            return p;
        } else {
            throw new NoSuchPlotException();
        }
    }

    World world;
    PlotPersistent plotData;

    private Plot(int id, PlotSize s, Player owner) {
        WorldCreator wc = new WorldCreator(plotPrefix + id);
        wc.generator(new PlotChunkGenerator(s));
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
        this.plotData = new PlotPersistent(id, s, owner);
    }

    // TODO load plotData from the world.
    private Plot(int id) {

    }

    public void joinWorld(Player p) {
        p.teleport(new Location(world, this.plotData.getSpawnX(), this.plotData.getSpawnY(), this.plotData.getSpawnZ()));
    }

    public int getId() {
        return this.plotData.getId();
    }

    public PlotSize getPlotSize() {
        return this.plotData.getPlotSize();
    }
}
