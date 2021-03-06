package gregtech.api.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Collection;
import java.util.Random;

public class GT_Worldgen_Boulder extends GT_Worldgen_Ore {
    public GT_Worldgen_Boulder(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aDimensionType, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid) {
        super(aName, aDefault, aBlock, aBlockMeta, aDimensionType, aAmount, aSize, aProbability, aMinY, aMaxY, aBiomeList, aAllowToGenerateinVoid);
    }

    @Override
    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        //aRandom.nextInt(3) != 2 - decrease gen by 30%, for balance my modpack
        if (aRandom.nextInt(3) != 2) {
        if (isGenerationAllowed(aWorld, aDimensionType, mDimensionType) && (mBiomeList.isEmpty() || mBiomeList.contains(aBiome)) && (mProbability <= 1 || aRandom.nextInt(mProbability) == 0)) {
            for (int i = 0; i < mAmount; i++) {
                int tX = aChunkX + aRandom.nextInt(16), tY = mMinY + aRandom.nextInt(mMaxY - mMinY), tZ = aChunkZ + aRandom.nextInt(16);
                Block tBlock = aWorld.getBlock(tX, tY - 7, tZ);
                if (tBlock != null && tBlock.isOpaqueCube() && aWorld.getBlock(tX, tY - 6, tZ).isAir(aWorld, tX, tY - 6, tZ)) {
                    float var12b = (float)Math.PI / mSize;
                    //float var6 = aRandom.nextFloat() * (float)Math.PI;
                    float var3b_ = MathHelper.sin(aRandom.nextFloat() * (float)Math.PI);
                    //float var3b = var3b_ * (mSize >> 3);
                    float var4b = (float)Math.sqrt(1 - var3b_*var3b_) * (mSize >> 3);
                    float var8b = -2*(var3b_ * (mSize >> 3));float var9b = -2*var4b;
                    float var7 = ((tX + 8) + (var3b_ * (mSize >> 3)));//float var9 = (var10b - var3b);
                    float var11 = ((tZ + 8) + var4b);//float var13 = (var11b - var4b);
                    int var5b = aRandom.nextInt(3);/*int var6b = aRandom.nextInt(3);*/int var7b = aRandom.nextInt(3) - var5b;
                    float var15 = (tY + var5b - 2);//float var17 = (tY + var6b - 2);

                    for (int var19 = 0; var19 <= mSize; ++var19) {
                        float var2b = var19 / mSize;
                        float var20 = var7 + var8b * var2b;
                        float var22 = var15 + var7b * var2b;
                        float var24 = var11 + var9b * var2b;
                        //float var26 = aRandom.nextFloat() * (mSize >> 4);
                        float var28 = ((MathHelper.sin(var19 * var12b) + 1.0F) * (aRandom.nextFloat() * (mSize >> 4)) + 1.0F) / 2.0F;
                        //float var30 = (MathHelper.sin(var19 * math_pi / mSize) + 1.0F) * var26 + 1.0F;
                        int var32 = MathHelper.floor_float(var20 - var28);
                        int var33 = MathHelper.floor_float(var22 - var28);
                        int var34 = MathHelper.floor_float(var24 - var28);
                        int var35 = MathHelper.floor_float(var20 + var28);
                        int var36 = MathHelper.floor_float(var22 + var28);
                        int var37 = MathHelper.floor_float(var24 + var28);

                        for (int var38 = var32; var38 <= var35; ++var38) {
                            float var39 = (var38 + 0.5F - var20) / (var28);
                            float var13b = var39 * var39;
                            if (var13b < 1.0F) {
                                for (int var41 = var33; var41 <= var36; ++var41) {
                                    float var42 = (var41 + 0.5F - var22) / (var28);
                                    float var14b = var13b + var42 * var42;
                                    if (var14b < 1.0F) {
                                        for (int var44 = var34; var44 <= var37; ++var44) {
                                            float var45 = (var44 + 0.5F - var24) / (var28);
                                            Block block = aWorld.getBlock(var38, var41, var44);
                                            if (var14b + var45 * var45 < 1.0F && ((mAllowToGenerateinVoid && block.isAir(aWorld, var38, var41, var44)) || (block != null && !(block instanceof BlockContainer)))) {
                                                aWorld.setBlock(var38, var41, var44, mBlock, mBlockMeta, 0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
        }
        return true;
    }
}