package gregtech.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GT_MinableOreGenerator extends WorldGenerator {
    private Block minableBlockId;
    private Block mBlock;
    private int minableBlockMeta = 0;
    private int numberOfBlocks;
    private boolean allowVoid = false;

    public GT_MinableOreGenerator(Block par1, int par2) {
        this.minableBlockId = par1;
        this.numberOfBlocks = par2;
    }

    public GT_MinableOreGenerator(Block id, int meta, int number, boolean aAllowVoid, Block aBlock) {
        this(id, number);
        this.minableBlockMeta = meta;
        this.allowVoid = aAllowVoid;
        this.mBlock = aBlock;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        //float var6 = par2Random.nextFloat() * (float)Math.PI;
        int var7s = this.numberOfBlocks >> 4;
        float var8s = (float)Math.PI / this.numberOfBlocks;
        float mh_s_ = MathHelper.sin(par2Random.nextFloat() * (float)Math.PI);
        //float mh_s_0 = mh_s_ * (this.numberOfBlocks >> 3);
        float mh_c_0 = (float)Math.sqrt(1 - mh_s_*mh_s_) * (this.numberOfBlocks >> 3);
        float var7 = par3 + 8 + (mh_s_ * (this.numberOfBlocks >> 3));//float var9 = var5s - mh_s_0;
        float var11 = par5 + 8 + mh_c_0;//float var13 = var6s - mh_c_0;
        int var15r = par2Random.nextInt(3);//int var17r = par2Random.nextInt(3);
        int mh_n_4=par2Random.nextInt(3) - var15r;
        int var15 = par4 - 2 + var15r;//int var17 = var4s + var17r;
        float mh_n_0 = -2*(mh_s_ * (this.numberOfBlocks >> 3));float mh_n_1 = -2*mh_c_0;
        for (int var19 = 0; var19 <= this.numberOfBlocks; var19++) {
            float mh_n_2 = var19 / this.numberOfBlocks;
            float var20 = var7 + mh_n_0 * mh_n_2;
            float var22 = var15 + mh_n_4 * mh_n_2;
            float var24 = var11 + mh_n_1 * mh_n_2;
            //float var26 = par2Random.nextFloat() * var7s;
            //float var1c = var19 * var8s; //float var2c = var26 + 1.0F;
            float var28 = ((MathHelper.sin(var19 * var8s) + 1.0F) * (par2Random.nextFloat() * var7s) + 1.0F) / 2.0F;
            //float var30 = var28;
            //float var3c = var28 / 2.0F;//float var4c = var30 / 2.0F;
            int var32 = MathHelper.floor_float(var20 - var28);
            int var33 = MathHelper.floor_float(var22 - var28);
            int var34 = MathHelper.floor_float(var24 - var28);
            int var35 = MathHelper.floor_float(var20 + var28);
            int var36 = MathHelper.floor_float(var22 + var28);
            int var37 = MathHelper.floor_float(var24 + var28);
            for (int var38 = var32; var38 <= var35; var38++) {
                float var39 = (var38 + 0.5F - var20) / (var28);
                float var5c = var39 * var39;
                if (var5c < 1.0F) {
                    for (int var41 = var33; var41 <= var36; var41++) {
                        float var42 = (var41 + 0.5F - var22) / (var28);
                        //float var6c = var42 * var42;
                        float var7c = var5c + var42 * var42;
                        if (var7c < 1.0F) {
                            for (int var44 = var34; var44 <= var37; var44++) {
                                float var45 = (var44 + 0.5F - var24) / (var28);
                                Block block = par1World.getBlock(var38, var41, var44);
                                if ((var7c + var45 * var45 < 1.0F) && (((this.allowVoid) && (block == Blocks.air)) || ((block != null) && (block.isReplaceableOreGen(par1World, var38, var41, var44, this.mBlock))))) {
                                    par1World.setBlock(var38, var41, var44, this.minableBlockId, this.minableBlockMeta, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
