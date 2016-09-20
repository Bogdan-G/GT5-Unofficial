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

public class GT_Worldgen_Stone extends GT_Worldgen_Ore {
    public GT_Worldgen_Stone(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aDimensionType, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid) {
        super(aName, aDefault, aBlock, aBlockMeta, aDimensionType, aAmount, aSize, aProbability, aMinY, aMaxY, aBiomeList, aAllowToGenerateinVoid);
    }

    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        if ((isGenerationAllowed(aWorld, aDimensionType, this.mDimensionType)) && ((this.mBiomeList.isEmpty()) || (this.mBiomeList.contains(aBiome))) && ((this.mProbability <= 1) || (aRandom.nextInt(this.mProbability) == 0))) {
            float math_pi_0 = (float)Math.PI / this.mSize;
            //float[] arr_m_0 = new float[this.mSize+1];
            //for (int var19 = 0; var19 <= this.mSize; var19++) arr_m_0[var19] = MathHelper.sin(var19 * math_pi_0);//off, JMH test find slow by 30%
            for (int i = 0; i < this.mAmount; i++) {
                int tX = aChunkX + aRandom.nextInt(16);
                int tY = this.mMinY + aRandom.nextInt(this.mMaxY - this.mMinY);
                int tZ = aChunkZ + aRandom.nextInt(16);
                if ((this.mAllowToGenerateinVoid) || (!aWorld.getBlock(tX, tY, tZ).isAir(aWorld, tX, tY, tZ))) {
                    float var6 = aRandom.nextFloat() * (float)Math.PI;
                    float mh_s_ = MathHelper.sin(var6);
                    float mh_s_0 = mh_s_ * (this.mSize >> 3);
                    float mh_c_0 = (float)Math.sqrt(1 - mh_s_*mh_s_) * (this.mSize >> 3);
                    float var7 = tX + 8 + mh_s_0;//float var9 = var2d - mh_s_0;
                    float var11 = tZ + 8 + mh_c_0;//float var13 = var3d - mh_c_0;
                    int var15r = aRandom.nextInt(3);int var17r = aRandom.nextInt(3);
                    int var15 = tY - 2 + var15r;//float var17 = var4d + var17r;
                    int mh_n_4=var17r - var15r;
                    float mh_n_0 = -2*mh_s_0;float mh_n_1 = -2*mh_c_0;
                    for (int var19 = 0; var19 <= this.mSize; var19++) {
                        float var5d = var19 / this.mSize;
                        float var20 = var7 + mh_n_0 * var5d;
                        float var22 = var15 + mh_n_4 * var5d;
                        float var24 = var11 + mh_n_1 * var5d;
                        float var6d = var19 * math_pi_0;
                        float var26 = aRandom.nextFloat() * (this.mSize >> 4);
                        //float var7d = var26 + 1.0F;
                        float var28 = ((MathHelper.sin(var6d) + 1.0F) * var26 + 1.0F) / 2.0F;
                        //float var30 = (MathHelper.sin(var6d) + 1.0F) * var7d;
                        //float var8d = var28 / 2.0F;//float var9d = var30 / 2.0F;
                        int tMinX = MathHelper.floor_float(var20 - var28);
                        int tMinY = MathHelper.floor_float(var22 - var28);
                        int tMinZ = MathHelper.floor_float(var24 - var28);
                        int tMaxX = MathHelper.floor_float(var20 + var28);
                        int tMaxY = MathHelper.floor_float(var22 + var28);
                        int tMaxZ = MathHelper.floor_float(var24 + var28);
                        for (int eX = tMinX; eX <= tMaxX; eX++) {
                            float var39 = (eX + 0.5F - var20) / (var28);
                            float var10d = var39 * var39;
                            if (var10d < 1.0F) {
                                for (int eY = tMinY; eY <= tMaxY; eY++) {
                                    float var42 = (eY + 0.5F - var22) / (var28);
                                    //float var11d = var42 * var42;
                                    float var12d = var10d + var42 * var42;
                                    if (var12d < 1.0F) {
                                        for (int eZ = tMinZ; eZ <= tMaxZ; eZ++) {
                                            float var45 = (eZ + 0.5F - var24) / (var28);
                                            if (var12d + var45 * var45 < 1.0F) {
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
