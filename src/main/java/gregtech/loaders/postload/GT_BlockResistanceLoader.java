package gregtech.loaders.postload;

import gregtech.GT_Mod;
import gregtech.api.util.GT_Utility;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;

import java.util.Set;

import static gregtech.api.enums.GT_Values.*;

public class GT_BlockResistanceLoader
        implements Runnable {
    public void run() {
        if (GT_Mod.gregtechproxy.mHardRock) {
            Blocks.stone.setHardness(16.0F);
            Blocks.brick_block.setHardness(32.0F);
            Blocks.hardened_clay.setHardness(32.0F);
            Blocks.stained_hardened_clay.setHardness(32.0F);
            Blocks.cobblestone.setHardness(12.0F);
            Blocks.stonebrick.setHardness(24.0F);
            Blocks.sandstone.setHardness(8.0F);
            Blocks.sandstone_stairs.setHardness(8.0F);
        }
        Blocks.stone.setResistance(10.0F);
        Blocks.cobblestone.setResistance(10.0F);
        Blocks.stonebrick.setResistance(10.0F);
        Blocks.brick_block.setResistance(20.0F);
        Blocks.hardened_clay.setResistance(15.0F);
        Blocks.stained_hardened_clay.setResistance(15.0F);
        Blocks.sandstone.setResistance(4.0F);
        Blocks.sandstone_stairs.setResistance(4.0F);
        //Add setHarvestLevel("pickaxe", 2) for balance my modpack
        if (IronPickaxeReq) {
            Blocks.stone.setHarvestLevel("pickaxe", 2);
            Blocks.cobblestone.setHarvestLevel("pickaxe", 2);
            Blocks.stonebrick.setHarvestLevel("pickaxe", 2);
            Blocks.brick_block.setHarvestLevel("pickaxe", 2);
            Blocks.gold_ore.setHarvestLevel("pickaxe", 2);
            Blocks.iron_ore.setHarvestLevel("pickaxe", 2);
            Blocks.lapis_ore.setHarvestLevel("pickaxe", 2);
            Blocks.sandstone.setHarvestLevel("pickaxe", 1);//additional req
            Blocks.double_stone_slab.setHarvestLevel("pickaxe", 2);
            Blocks.stone_slab.setHarvestLevel("pickaxe", 2);
            Blocks.stone_stairs.setHarvestLevel("pickaxe", 2);
            Blocks.stone_pressure_plate.setHarvestLevel("pickaxe", 2);
            Blocks.redstone_ore.setHarvestLevel("pickaxe", 2);
            Blocks.stone_button.setHarvestLevel("pickaxe", 2);
            Blocks.brick_stairs.setHarvestLevel("pickaxe", 2);
            Blocks.stone_brick_stairs.setHarvestLevel("pickaxe", 2);
            Blocks.nether_brick.setHarvestLevel("pickaxe", 2);
            Blocks.nether_brick_fence.setHarvestLevel("pickaxe", 2);
            Blocks.nether_brick_stairs.setHarvestLevel("pickaxe", 2);
            Blocks.sandstone_stairs.setHarvestLevel("pickaxe", 1);//additional req
            Blocks.emerald_ore.setHarvestLevel("pickaxe", 2);
            Blocks.cobblestone_wall.setHarvestLevel("pickaxe", 2);
            Blocks.quartz_ore.setHarvestLevel("pickaxe", 2);
        }


        Blocks.bed.setHarvestLevel("axe", 0);
        Blocks.hay_block.setHarvestLevel("axe", 0);
        Blocks.tnt.setHarvestLevel("pickaxe", 0);
        Blocks.sponge.setHarvestLevel("axe", 0);
        Blocks.monster_egg.setHarvestLevel("pickaxe", 0);

        GT_Utility.callMethod(Material.tnt, "func_85158_p", true, false, false, new Object[0]);
        GT_Utility.callMethod(Material.tnt, "setAdventureModeExempt", true, false, false, new Object[0]);

        Set tSet = (Set) GT_Utility.getFieldContent(ItemAxe.class, "field_150917_c", true, true);
        tSet.add(Blocks.bed);
        tSet.add(Blocks.hay_block);
        tSet.add(Blocks.sponge);

        tSet = (Set) GT_Utility.getFieldContent(ItemPickaxe.class, "field_150915_c", true, true);
        tSet.add(Blocks.monster_egg);
        tSet.add(Blocks.tnt);
    }
}
