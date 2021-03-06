package gregtech.api.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Collection;
import java.util.Random;

public class GT_Worldgen_Ore_SingleBlock extends GT_Worldgen_Ore {
    public GT_Worldgen_Ore_SingleBlock(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aDimensionType, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid) {
        super(aName, aDefault, aBlock, aBlockMeta, aDimensionType, aAmount, aSize, aProbability, aMinY, aMaxY, aBiomeList, aAllowToGenerateinVoid);
    }

    @Override
    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        //aRandom.nextInt(3) != 2 - decrease gen by 30%, for balance my modpack
        if (aRandom.nextInt(3) != 2) {if (isGenerationAllowed(aWorld, aDimensionType, mDimensionType) && (mBiomeList.isEmpty() || mBiomeList.contains(aBiome)) && (mProbability <= 1 || aRandom.nextInt(mProbability) == 0)) {
            int dim = aWorld.provider.dimensionId;
            for (int i = 0; i < mAmount; i++) {
                int tX = aChunkX + aRandom.nextInt(16), tY = mMinY + aRandom.nextInt(mMaxY - mMinY), tZ = aChunkZ + aRandom.nextInt(16);
                Block tBlock = aWorld.getBlock(tX, tY, tZ);
                if (((mAllowToGenerateinVoid && tBlock.isAir(aWorld, tX, tY, tZ)) || (tBlock != null && (tBlock.isReplaceableOreGen(aWorld, tX, tY, tZ, Blocks.stone) || dim == 1 && tBlock.isReplaceableOreGen(aWorld, tX, tY, tZ, Blocks.end_stone) || dim == -1 && tBlock.isReplaceableOreGen(aWorld, tX, tY, tZ, Blocks.netherrack))))) {
                    aWorld.setBlock(tX, tY, tZ, mBlock, mBlockMeta, 0);
                }
            }
            return true;
        }
        return false;
        }
        return true;
    }
}