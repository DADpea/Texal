package io.github.dadpea.texal.plots;

import com.google.gson.Gson;
import io.github.dadpea.texal.Texal;
import io.github.dadpea.texal.plots.exceptions.MalformedDataException;
import io.github.dadpea.texal.plots.exceptions.NoSuchPlotException;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.io.*;

public class Plot {
    final static String plotPrefix = "plots/plot";

    private static int getNextID() {
        return Texal.persistentData.getPlotPersistent().getNextID();
    }
    private static void setNextID(int i) {
        Texal.persistentData.getPlotPersistent().setNextID(i);
    }

    private void loadWorld() {
        if (!isLoaded) {
            isLoaded = true;
            Bukkit.createWorld(new WorldCreator(plotPrefix + id));
        }
    }
    private void unloadWorld() {
        if (isLoaded) {
            isLoaded = false;
            Bukkit.unloadWorld(world, true);
        }
    }

    public static Plot createNewPlot(PlotSize size, Player owner) {
        setNextID(getNextID() + 1);
        return new Plot(getNextID(), size, owner);
    }

    World world;
    PlotPersistent plotData;
    boolean isLoaded;
    int id;


    /**
     * Loads a pre-existing plot from an input ID.
     * Will not create a new plot.
     *
     * @param id
     * @throws NoSuchPlotException
     * @throws MalformedDataException
     */
    public Plot(int id) throws NoSuchPlotException, MalformedDataException {
        this.id = id;
        this.isLoaded = false;
        this.world = Bukkit.getWorld(plotPrefix + id);
        if (this.world == null) throw new NoSuchPlotException();
        try (Reader r = new FileReader(plotPrefix + id + "/plotData.json")) {
            Gson g = new Gson();
            this.plotData = g.fromJson(r, PlotPersistent.class);
        } catch (Exception e) {
            throw new MalformedDataException();
        }
    }

    private Plot(int id, PlotSize s, Player owner) {
        this.id = id;
        this.isLoaded = true;
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

    public void joinPlot(Player p) {
        loadWorld();
        p.teleport(new Location(world, this.plotData.getSpawnX(), this.plotData.getSpawnY(), this.plotData.getSpawnZ()));
    }

    public int getId() {
        return this.id;
    }
}
