package gregtech.common;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.api.GregTech_API;
import gregtech.api.util.GT_Log;
import gregtech.api.world.GT_Worldgen;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bogdang.modifications.random.XSTR;
import org.eclipse.collections.impl.list.mutable.FastList;

public class GT_Worldgenerator implements IWorldGenerator {
    public static boolean sAsteroids = true;
    public List<Runnable> mList = new FastList();
    public boolean mIsGenerating = false;

    public GT_Worldgenerator() {
        GameRegistry.registerWorldGenerator(this, 1073741823);
    }

    public void generate(Random aRandom, int aX, int aZ, World aWorld, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        this.mList.add(new WorldGenContainer(new XSTR(aRandom.nextInt()), aX * 16, aZ * 16, ((aChunkGenerator instanceof ChunkProviderEnd)) || (aWorld.getBiomeGenForCoords(aX * 16 + 8, aZ * 16 + 8) == BiomeGenBase.sky) ? 1 : ((aChunkGenerator instanceof ChunkProviderHell)) || (aWorld.getBiomeGenForCoords(aX * 16 + 8, aZ * 16 + 8) == BiomeGenBase.hell) ? -1 : 0, aWorld, aChunkGenerator, aChunkProvider, aWorld.getBiomeGenForCoords(aX * 16 + 8, aZ * 16 + 8).biomeName));
        if (!this.mIsGenerating) {
            this.mIsGenerating = true;
            int mList_sS=this.mList.size();
            for (int i = 0; i < mList_sS; i++) {
                ((Runnable) this.mList.get(i)).run();
            }
            this.mList.clear();
            this.mIsGenerating = false;
        }
    }

    public static class WorldGenContainer implements Runnable {
        public final Random mRandom;
        public final int mX;
        public final int mZ;
        public final int mDimensionType;
        public final World mWorld;
        public final IChunkProvider mChunkGenerator;
        public final IChunkProvider mChunkProvider;
        public final String mBiome;

        public WorldGenContainer(Random aRandom, int aX, int aZ, int aDimensionType, World aWorld, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider, String aBiome) {
            this.mRandom = aRandom;
            this.mX = aX;
            this.mZ = aZ;
            this.mDimensionType = aDimensionType;
            this.mWorld = aWorld;
            this.mChunkGenerator = aChunkGenerator;
            this.mChunkProvider = aChunkProvider;
            this.mBiome = aBiome;
        }

        public void run() {
            if (((this.mX / 16) % 3 == 1 || (this.mX / 16) % 3 == -1) && ((this.mZ / 16) % 3 == 1 || (this.mZ / 16) % 3 == -1)) {
                if ((GT_Worldgen_GT_Ore_Layer.sWeight > 0) && (GT_Worldgen_GT_Ore_Layer.sList.size() > 0)) {
                    boolean temp = true;
                    int tRandomWeight;
                    for (int i = 0; (i < 256) && (temp); i++) {
                        tRandomWeight = this.mRandom.nextInt(GT_Worldgen_GT_Ore_Layer.sWeight);
                        for (GT_Worldgen tWorldGen : GT_Worldgen_GT_Ore_Layer.sList) {
                            tRandomWeight -= ((GT_Worldgen_GT_Ore_Layer) tWorldGen).mWeight;
                            if (tRandomWeight <= 0) {
                                try {
                                    if (tWorldGen.executeWorldgen(this.mWorld, this.mRandom, this.mBiome, this.mDimensionType, this.mX, this.mZ, this.mChunkGenerator, this.mChunkProvider)) {
                                        temp = false;
                                    }
                                } catch (Throwable e) {
                                    e.printStackTrace(GT_Log.err);
                                }
                                break;
                            }
                        }
                    }
                }
                int i = 0;
                for (int tX = this.mX - 16; i < 3; tX += 16) {
                    int j = 0;
                    for (int tZ = this.mZ - 16; j < 3; tZ += 16) {
                        //String tBiome = this.mWorld.getBiomeGenForCoords(tX + 8, tZ + 8).biomeName;
                        /*if (tBiome == null) {
                            tBiome = BiomeGenBase.plains.biomeName;//FindBugs: DLS - DLS_DEAD_LOCAL_STORE
                        }*/
                        try {
                        for (GT_Worldgen tWorldGen : GregTech_API.sWorldgenList) {
                                tWorldGen.executeWorldgen(this.mWorld, this.mRandom, this.mBiome, this.mDimensionType, tX, tZ, this.mChunkGenerator, this.mChunkProvider);
                        }} catch (Throwable e) {e.printStackTrace(GT_Log.err);}
                        j++;
                    }
                    i++;
                }
            }
            Chunk tChunk = this.mWorld.getChunkFromBlockCoords(this.mX, this.mZ);
            if (tChunk != null) {
                tChunk.isModified = true;
            }
        }
    }
}
