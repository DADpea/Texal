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
             // Fill y=0 with grass_block.
            for (int x1 = 0; x1 < 16; x1++) {
                for (int z1 = 0; z1 < 16; z1++) {
                    chunkData.setBlock(x1, 0, z1, Material.GRASS_BLOCK);
                    chunkData.setBlock(x1, -1, z1, Material.DIRT);
                    chunkData.setBlock(x1, -2, z1, Material.DIRT);
                    chunkData.setBlock(x1, -3, z1, Material.DIRT);
                    chunkData.setBlock(x1, -4, z1, Material.BEDROCK);
                }
            }
         }
    }
}
