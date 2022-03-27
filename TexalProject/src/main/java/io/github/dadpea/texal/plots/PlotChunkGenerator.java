package io.github.dadpea.texal.plots;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlotChunkGenerator extends ChunkGenerator {
    PlotSize plotSize;

    public PlotChunkGenerator(PlotSize s) {
        this.plotSize = s;
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(WorldInfo worldInfo) {
        return new BiomeProvider() {
            @Override
            public Biome getBiome(WorldInfo worldInfo, int i, int i1, int i2) {
                return Biome.PLAINS;
            }

            @Override
            public List<Biome> getBiomes(WorldInfo worldInfo) {
                return Arrays.asList(Biome.PLAINS);
            }
        };
    }

    @Override
    public void generateSurface(WorldInfo worldInfo, Random random, int x, int z, ChunkData chunkData) {
         if (x >= 0 && z >= 0 && x < plotSize.size && z < plotSize.size) {
            setRegion(chunkData, 0, 0, 0, 16, 0, 16, Material.GRASS_BLOCK);
            setRegion(chunkData, 0, -1, 0, 16, -1, 16, Material.DIRT);
            setRegion(chunkData, 0, -4, 0, 16, -4, 16, Material.BEDROCK);
            if (x==0) setRegion(chunkData, 0, 0, 0, 0, 0, 16, plotSize.borderMat);
            if (x==plotSize.size-1) setRegion(chunkData, 16, 0, 0, 16, 0, 16, plotSize.borderMat);
            if (z==0) setRegion(chunkData, 0, 0, 0, 16, 0, 0, plotSize.borderMat);
            if (z==plotSize.size-1) setRegion(chunkData, 16, 0, 0, 16, 0, 16, plotSize.borderMat);
         }
    }

    public void setRegion(ChunkData c, int minx, int miny, int minz, int maxx, int maxy, int maxz, Material m) {
        for (int x = minx; x < maxx; x++)
            for (int y = miny; y < maxy; y++)
                for (int z = minz; z < maxz; z++)
                    c.setBlock(x,y,z,m);
    }
}
