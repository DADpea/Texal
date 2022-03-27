package io.github.dadpea.texal.plots;

import org.bukkit.Material;

public enum PlotSize {
    SMALL(8, Material.WHITE_CONCRETE),
    MEDIUM(16, Material.YELLOW_CONCRETE),
    LARGE(32, Material.ORANGE_CONCRETE);

    public int size;
    public Material borderMat;
    private PlotSize(int s, Material m) {
        this.size = s;
        this.borderMat = m;
    }


}
