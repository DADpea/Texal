package io.github.dadpea.texal.plots;

import io.github.dadpea.texal.style.GlobalColors;
import org.bukkit.entity.Player;

import java.io.Serializable;
import java.util.UUID;

public class PlotPersistent implements Serializable {
    private int id;
    private PlotSize plotSize;
    private int spawnX;
    private int spawnY;
    private int spawnZ;
    private String name;
    private UUID owner;

    public PlotPersistent() {
        this.id=0;
        this.plotSize = PlotSize.SMALL;
        spawnX = 16;
        spawnY = 1;
        spawnZ = 16;
        name = "";
        owner = null;
    }

    public PlotPersistent(int id, PlotSize s, Player p) {
        this();
        this.id=id;
        this.plotSize = s;
        String pName = p.getName();
        char finalChar = pName.charAt(pName.length()-1);
        if (finalChar=='s' || finalChar=='S') {
            this.name = GlobalColors.TEAL + pName + "' Plot";
        } else {
            this.name = GlobalColors.TEAL + pName + "'s Plot";
        }
        this.owner = p.getUniqueId();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public PlotSize getPlotSize() {
        return plotSize;
    }
    public void setPlotSize(PlotSize plotSize) {
        this.plotSize = plotSize;
    }
    public int getSpawnX() {
        return this.spawnX;
    }
    public void setSpawnX(int x) {
        this.spawnX = x;
    }
    public int getSpawnY() {
        return this.spawnY;
    }
    public void setSpawnY(int y) {
        this.spawnY = y;
    }
    public int getSpawnZ() {
        return this.spawnZ;
    }
    public void setSpawnZ(int z) {
        this.spawnZ = z;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UUID getOwner() {
        return owner;
    }
    public void setOwner(UUID owner) {
        this.owner = owner;
    }
}
