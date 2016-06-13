package gregtech.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GT_MinableOreGenerator
        extends WorldGenerator {
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
        float math_pi = 3.141593F;//FB: CNT - CNT_ROUGH_CONSTANT_VALUE
        float var6 = par2Random.nextFloat() * math_pi;
        float var1s = this.numberOfBlocks / 8.0F;
        float var4s = par4 - 2;float var5s = par3 + 8;float var6s = par5 + 8;
        float var7s = this.numberOfBlocks / 16.0F;
        float var8s = math_pi / this.numberOfBlocks;
        float var7 = var5s + MathHelper.sin(var6) * var1s;
        float var9 = var5s - MathHelper.sin(var6) * var1s;
        float var11 = var6s + MathHelper.cos(var6) * var1s;
        float var13 = var6s - MathHelper.cos(var6) * var1s;
        float var15 = var4s + par2Random.nextInt(3);
        float var17 = var4s + par2Random.nextInt(3);
        for (int var19 = 0; var19 <= this.numberOfBlocks; var19++) {
            float var20 = var7 + (var9 - var7) * var19 / this.numberOfBlocks;
            float var22 = var15 + (var17 - var15) * var19 / this.numberOfBlocks;
            float var24 = var11 + (var13 - var11) * var19 / this.numberOfBlocks;
            float var26 = par2Random.nextFloat() * var7s;
            float var1c = var19 * var8s; float var2c = var26 + 1.0F;
            float var28 = (MathHelper.sin(var1c) + 1.0F) * var2c;
            float var30 = (MathHelper.sin(var1c) + 1.0F) * var2c;
            float var3c = var28 / 2.0F;float var4c = var30 / 2.0F;
            int var32 = MathHelper.floor_float(var20 - var3c);
            int var33 = MathHelper.floor_float(var22 - var4c);
            int var34 = MathHelper.floor_float(var24 - var3c);
            int var35 = MathHelper.floor_float(var20 + var3c);
            int var36 = MathHelper.floor_float(var22 + var4c);
            int var37 = MathHelper.floor_float(var24 + var3c);
            for (int var38 = var32; var38 <= var35; var38++) {
                float var39 = (var38 + 0.5F - var20) / (var3c);
                float var5c = var39 * var39;
                if (var5c < 1.0F) {
                    for (int var41 = var33; var41 <= var36; var41++) {
                        float var42 = (var41 + 0.5F - var22) / (var4c);
                        float var6c = var42 * var42;
                        float var7c = var5c + var6c;
                        if (var7c < 1.0F) {
                            for (int var44 = var34; var44 <= var37; var44++) {
                                float var45 = (var44 + 0.5F - var24) / (var3c);
                                Block block = par1World.getBlock(var38, var41, var44);
                                if ((var7c + var45 * var45 < 1.0F) && (((this.allowVoid) && (par1World.getBlock(var38, var41, var44) == Blocks.air)) || ((block != null) && (block.isReplaceableOreGen(par1World, var38, var41, var44, this.mBlock))))) {
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
