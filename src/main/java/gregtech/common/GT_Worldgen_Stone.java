package gregtech.common;

import gregtech.api.GregTech_API;
import gregtech.api.world.GT_Worldgen_Ore;
import gregtech.common.blocks.GT_TileEntity_Ores;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Collection;
import java.util.Random;

public class GT_Worldgen_Stone
        extends GT_Worldgen_Ore {
    public GT_Worldgen_Stone(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aDimensionType, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid) {
        super(aName, aDefault, aBlock, aBlockMeta, aDimensionType, aAmount, aSize, aProbability, aMinY, aMaxY, aBiomeList, aAllowToGenerateinVoid);
    }

    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        if ((isGenerationAllowed(aWorld, aDimensionType, this.mDimensionType)) && ((this.mBiomeList.isEmpty()) || (this.mBiomeList.contains(aBiome))) && ((this.mProbability <= 1) || (aRandom.nextInt(this.mProbability) == 0))) {
            for (int i = 0; i < this.mAmount; i++) {
                int tX = aChunkX + aRandom.nextInt(16);
                int tY = this.mMinY + aRandom.nextInt(this.mMaxY - this.mMinY);
                int tZ = aChunkZ + aRandom.nextInt(16);
                if ((this.mAllowToGenerateinVoid) || (!aWorld.getBlock(tX, tY, tZ).isAir(aWorld, tX, tY, tZ))) {
                    float var6 = aRandom.nextFloat() * 3.141593F;
                    double var1d = this.mSize / 8.0F;double var2d = tX + 8;double var3d = tZ + 8;double var4d = tY - 2;
                    double var7 = var2d + MathHelper.sin(var6) * var1d;
                    double var9 = var2d - MathHelper.sin(var6) * var1d;
                    double var11 = var3d + MathHelper.cos(var6) * var1d;
                    double var13 = var3d - MathHelper.cos(var6) * var1d;
                    double var15 = var4d + aRandom.nextInt(3);
                    double var17 = var4d + aRandom.nextInt(3);
                    for (int var19 = 0; var19 <= this.mSize; var19++) {
                        double var5d = var19 / this.mSize;
                        double var20 = var7 + (var9 - var7) * var5d;
                        double var22 = var15 + (var17 - var15) * var5d;
                        double var24 = var11 + (var13 - var11) * var5d;
                        float var6d = var19 * 3.141593F / this.mSize;
                        double var26 = aRandom.nextDouble() * this.mSize / 16.0D;
                        double var7d = var26 + 1.0D;
                        double var28 = (MathHelper.sin(var6d) + 1.0F) * var7d;
                        double var30 = (MathHelper.sin(var6d) + 1.0F) * var7d;
                        double var8d = var28 / 2.0D;double var9d = var30 / 2.0D;
                        int tMinX = MathHelper.floor_double(var20 - var8d);
                        int tMinY = MathHelper.floor_double(var22 - var9d);
                        int tMinZ = MathHelper.floor_double(var24 - var8d);
                        int tMaxX = MathHelper.floor_double(var20 + var8d);
                        int tMaxY = MathHelper.floor_double(var22 + var9d);
                        int tMaxZ = MathHelper.floor_double(var24 + var8d);
                        for (int eX = tMinX; eX <= tMaxX; eX++) {
                            double var39 = (eX + 0.5D - var20) / (var8d);
                            double var10d = var39 * var39;
                            if (var10d < 1.0D) {
                                for (int eY = tMinY; eY <= tMaxY; eY++) {
                                    double var42 = (eY + 0.5D - var22) / (var9d);
                                    double var11d = var42 * var42;
                                    double var12d = var10d + var11d;
                                    if (var12d < 1.0D) {
                                        for (int eZ = tMinZ; eZ <= tMaxZ; eZ++) {
                                            double var45 = (eZ + 0.5D - var24) / (var8d);
                                            if (var12d + var45 * var45 < 1.0D) {
                                                Block tTargetedBlock = aWorld.getBlock(eX, eY, eZ);
                                                if (tTargetedBlock == GregTech_API.sBlockOres1) {
                                                    TileEntity tTileEntity = aWorld.getTileEntity(eX, eY, eZ);
                                                    if ((tTileEntity instanceof GT_TileEntity_Ores)) {
                                                        ((GT_TileEntity_Ores) tTileEntity).overrideOreBlockMaterial(this.mBlock, (byte) this.mBlockMeta);
                                                    }
                                                } else if (((this.mAllowToGenerateinVoid) && (aWorld.getBlock(eX, eY, eZ).isAir(aWorld, eX, eY, eZ))) || ((tTargetedBlock != null) && ((tTargetedBlock.isReplaceableOreGen(aWorld, eX, eY, eZ, Blocks.stone)) || (tTargetedBlock.isReplaceableOreGen(aWorld, eX, eY, eZ, Blocks.end_stone)) || (tTargetedBlock.isReplaceableOreGen(aWorld, eX, eY, eZ, Blocks.netherrack))))) {
                                                    aWorld.setBlock(eX, eY, eZ, this.mBlock, this.mBlockMeta, 0);
                                                }
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
}
