package gregtech.api.util;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.registry.*;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.TC_Aspects.TC_AspectStack;
import gregtech.api.interfaces.internal.IThaumcraftCompat;
import gregtech.api.objects.ItemData;
import gregtech.api.objects.MaterialStack;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static gregtech.api.enums.GT_Values.*;

/**
 * Class for Automatic Recipe registering.
 */
public class GT_RecipeRegistrator {
    /**
     * List of Materials, which are used in the Creation of Sticks. All Rod Materials are automatically added to this List.
     */
    public static List<Materials> sRodMaterialList = /*Ser0 ? null : */new ArrayList<Materials>();
    //public static List<Materials> sRodMaterialList_NonNull = Ser0 ? null : new ArrayList<Materials>();
    //public static List<ItemStack[]> sInternalListsBeforeAdd = Ser0 ? null : new ArrayList();
    //public static List<Object[]> sInternalListsBeforeAdd2 = Ser0 ? null : new ArrayList();
    //public static List<ItemStack> sInternalListsBeforeAdd3 = Ser0 ? null : new ArrayList();
    public static ItemStack sMt1 = new ItemStack(Blocks.dirt, 1, 0), sMt2 = new ItemStack(Blocks.dirt, 1, 0);
    private static String s_H = "h", s_F = "f", s_I = "I", s_P = "P", s_R = "R";
    public static ItemStack[][]
            sShapes1 = new ItemStack[][]{
            {sMt1, null, sMt1, sMt1, sMt1, sMt1, null, sMt1, null},
            {sMt1, null, sMt1, sMt1, null, sMt1, sMt1, sMt1, sMt1},
            {null, sMt1, null, sMt1, sMt1, sMt1, sMt1, null, sMt1},
            {sMt1, sMt1, sMt1, sMt1, null, sMt1, null, null, null},
            {sMt1, null, sMt1, sMt1, sMt1, sMt1, sMt1, sMt1, sMt1},
            {sMt1, sMt1, sMt1, sMt1, null, sMt1, sMt1, null, sMt1},
            {null, null, null, sMt1, null, sMt1, sMt1, null, sMt1},
            {null, sMt1, null, null, sMt1, null, null, sMt2, null},
            {sMt1, sMt1, sMt1, null, sMt2, null, null, sMt2, null},
            {null, sMt1, null, null, sMt2, null, null, sMt2, null},
            {sMt1, sMt1, null, sMt1, sMt2, null, null, sMt2, null},
            {null, sMt1, sMt1, null, sMt2, sMt1, null, sMt2, null},
            {sMt1, sMt1, null, null, sMt2, null, null, sMt2, null},
            {null, sMt1, sMt1, null, sMt2, null, null, sMt2, null},
            {null, sMt1, null, sMt1, null, null, null, sMt1, sMt2},
            {null, sMt1, null, null, null, sMt1, sMt2, sMt1, null},
            {null, sMt1, null, sMt1, null, sMt1, null, null, sMt2},
            {null, sMt1, null, sMt1, null, sMt1, sMt2, null, null},
            {null, sMt2, null, null, sMt1, null, null, sMt1, null},
            {null, sMt2, null, null, sMt2, null, sMt1, sMt1, sMt1},
            {null, sMt2, null, null, sMt2, null, null, sMt1, null},
            {null, sMt2, null, sMt1, sMt2, null, sMt1, sMt1, null},
            {null, sMt2, null, null, sMt2, sMt1, null, sMt1, sMt1},
            {null, sMt2, null, null, sMt2, null, sMt1, sMt1, null},
            {sMt1, null, null, null, sMt2, null, null, null, sMt2},
            {null, null, sMt1, null, sMt2, null, sMt2, null, null},
            {sMt1, null, null, null, sMt2, null, null, null, null},
            {null, null, sMt1, null, sMt2, null, null, null, null},
            {sMt1, sMt2, null, null, null, null, null, null, null},
            {sMt2, sMt1, null, null, null, null, null, null, null},
            {sMt1, null, null, sMt2, null, null, null, null, null},
            {sMt2, null, null, sMt1, null, null, null, null, null},
            {sMt1, sMt1, sMt1, sMt1, sMt1, sMt1, null, sMt2, null},
            {sMt1, sMt1, null, sMt1, sMt1, sMt2, sMt1, sMt1, null},
            {null, sMt1, sMt1, sMt2, sMt1, sMt1, null, sMt1, sMt1},
            {null, sMt2, null, sMt1, sMt1, sMt1, sMt1, sMt1, sMt1},
            {sMt1, sMt1, sMt1, sMt1, sMt2, sMt1, null, sMt2, null},
            {sMt1, sMt1, null, sMt1, sMt2, sMt2, sMt1, sMt1, null},
            {null, sMt1, sMt1, sMt2, sMt2, sMt1, null, sMt1, sMt1},
            {null, sMt2, null, sMt1, sMt2, sMt1, sMt1, sMt1, sMt1},
            {sMt1, null, null, null, sMt1, null, null, null, null},
            {null, sMt1, null, sMt1, null, null, null, null, null},
            {sMt1, sMt1, null, sMt2, null, sMt1, sMt2, null, null},
            {null, sMt1, sMt1, sMt1, null, sMt2, null, null, sMt2}
    };
    public static String[][] sShapesA = new String[][]{
            null,
            null,
            null,
            {"Helmet", s_P + s_P + s_P, s_P + s_H + s_P},
            {"ChestPlate", s_P + s_H + s_P, s_P + s_P + s_P, s_P + s_P + s_P},
            {"Pants", s_P + s_P + s_P, s_P + s_H + s_P, s_P + " " + s_P},
            {"Boots", s_P + " " + s_P, s_P + s_H + s_P},
            {"Sword", " " + s_P + " ", s_F + s_P + s_H, " " + s_R + " "},
            {"Pickaxe", s_P + s_I + s_I, s_F + s_R + s_H, " " + s_R + " "},
            {"Shovel", s_F + s_P + s_H, " " + s_R + " ", " " + s_R + " "},
            {"Axe", s_P + s_I + s_H, s_P + s_R + " ", s_F + s_R + " "},
            {"Axe", s_P + s_I + s_H, s_P + s_R + " ", s_F + s_R + " "},
            {"Hoe", s_P + s_I + s_H, s_F + s_R + " ", " " + s_R + " "},
            {"Hoe", s_P + s_I + s_H, s_F + s_R + " ", " " + s_R + " "},
            {"Sickle", " " + s_P + " ", s_P + s_F + " ", s_H + s_P + s_R},
            {"Sickle", " " + s_P + " ", s_P + s_F + " ", s_H + s_P + s_R},
            {"Sickle", " " + s_P + " ", s_P + s_F + " ", s_H + s_P + s_R},
            {"Sickle", " " + s_P + " ", s_P + s_F + " ", s_H + s_P + s_R},
            {"Sword", " " + s_R + " ", s_F + s_P + s_H, " " + s_P + " "},
            {"Pickaxe", " " + s_R + " ", s_F + s_R + s_H, s_P + s_I + s_I},
            {"Shovel", " " + s_R + " ", " " + s_R + " ", s_F + s_P + s_H},
            {"Axe", s_F + s_R + " ", s_P + s_R + " ", s_P + s_I + s_H},
            {"Axe", s_F + s_R + " ", s_P + s_R + " ", s_P + s_I + s_H},
            {"Hoe", " " + s_R + " ", s_F + s_R + " ", s_P + s_I + s_H},
            {"Hoe", " " + s_R + " ", s_F + s_R + " ", s_P + s_I + s_H},
            {"Spear", s_P + s_H + " ", s_F + s_R + " ", " " + " " + s_R},
            {"Spear", s_P + s_H + " ", s_F + s_R + " ", " " + " " + s_R},
            {"Knive", s_H + s_P, s_R + s_F},
            {"Knive", s_F + s_H, s_P + s_R},
            {"Knive", s_F + s_H, s_P + s_R},
            {"Knive", s_P + s_F, s_R + s_H},
            {"Knive", s_P + s_F, s_R + s_H},
            null,
            null,
            null,
            null,
            {"WarAxe", s_P + s_P + s_P, s_P + s_R + s_P, s_F + s_R + s_H},
            null,
            null,
            null,
            {"Shears", s_H + s_P, s_P + s_F},
            {"Shears", s_H + s_P, s_P + s_F},
            {"Scythe", s_I + s_P + s_H, s_R + s_F + s_P, s_R + " " + " "},
            {"Scythe", s_H + s_P + s_I, s_P + s_F + s_R, " " + " " + s_R}
    };
    //public static volatile int VERSION = 508;
    public static int sRodMaterialList_cycles = 0;public static int sRodMaterialList_cycles1 = 0;
    private static int i_count = 0;
    private static boolean first_call_gVTRO = true;private static boolean emptyList_find = false;
    public static int tMt2_null_cycles = 0;
    //public static int sRodMaterialList_cycles2 = 0;
    //public static int sInternalListsBeforeAdd_count=0, sInternalListsBeforeAdd2_count=0;
    /*static {
        if (Ser0) {
        try {
        FileInputStream inputStream = new FileInputStream("."+File.separator+"cache2"+File.separator+"sRodMaterialList.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        sRodMaterialList = (List<Materials>) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        } catch (Exception e) {cpw.mods.fml.common.FMLLog.log(org.apache.logging.log4j.Level.WARN, (Throwable)e, "Gregtech stacktrace: %s", (Throwable)e);}
        }
    }*/

    public static void registerMaterialRecycling(ItemStack aStack, Materials aMaterial, long aMaterialAmount, MaterialStack aByproduct) {
        if (GT_Utility.isStackInvalid(aStack)) return;
        if (aByproduct != null) {
            aByproduct = aByproduct.clone();
            aByproduct.mAmount /= aStack.stackSize;
        }
        GT_OreDictUnificator.addItemData(GT_Utility.copyAmount(1, aStack), new ItemData(aMaterial, aMaterialAmount / aStack.stackSize, aByproduct));
    }

    public static void registerMaterialRecycling(ItemStack aStack, ItemData aData) {
        if (GT_Utility.isStackInvalid(aStack) || GT_Utility.areStacksEqual(new ItemStack(Items.blaze_rod), aStack) || aData == null || !aData.hasValidMaterialData() || aData.mMaterial.mAmount <= 0 || GT_Utility.getFluidForFilledItem(aStack, false) != null)
            return;
        registerReverseMacerating(GT_Utility.copyAmount(1, aStack), aData, aData.mPrefix == null);
        registerReverseSmelting(GT_Utility.copyAmount(1, aStack), aData.mMaterial.mMaterial, aData.mMaterial.mAmount, true);
        registerReverseFluidSmelting(GT_Utility.copyAmount(1, aStack), aData.mMaterial.mMaterial, aData.mMaterial.mAmount, aData.getByProduct(0));
        registerReverseArcSmelting(GT_Utility.copyAmount(1, aStack), aData);
    }

    /**
     * @param aStack          the stack to be recycled.
     * @param aMaterial       the Material.
     * @param aMaterialAmount the amount of it in Material Units.
     */
    public static void registerReverseFluidSmelting(ItemStack aStack, Materials aMaterial, long aMaterialAmount, MaterialStack aByproduct) {
        if (aStack == null || aMaterial == null || aMaterial.mSmeltInto.mStandardMoltenFluid == null || !aMaterial.contains(SubTag.SMELTING_TO_FLUID) || (L * aMaterialAmount) / (M * aStack.stackSize) <= 0)
            return;
        RA.addFluidSmelterRecipe(GT_Utility.copyAmount(1, aStack), aByproduct == null ? null : aByproduct.mMaterial.contains(SubTag.NO_SMELTING) || !aByproduct.mMaterial.contains(SubTag.METAL) ? aByproduct.mMaterial.contains(SubTag.FLAMMABLE) ? GT_OreDictUnificator.getDust(Materials.Ash, aByproduct.mAmount / 2) : aByproduct.mMaterial.contains(SubTag.UNBURNABLE) ? GT_OreDictUnificator.getDustOrIngot(aByproduct.mMaterial.mSmeltInto, aByproduct.mAmount) : null : GT_OreDictUnificator.getIngotOrDust(aByproduct.mMaterial.mSmeltInto, aByproduct.mAmount), aMaterial.mSmeltInto.getMolten((L * aMaterialAmount) / (M * aStack.stackSize)), 10000, (int) Math.max(1, (24 * aMaterialAmount) / M), Math.max(8, (int) Math.sqrt(2 * aMaterial.mSmeltInto.mStandardMoltenFluid.getTemperature())));
    }

    /**
     * @param aStack             the stack to be recycled.
     * @param aMaterial          the Material.
     * @param aMaterialAmount    the amount of it in Material Units.
     * @param aAllowAlloySmelter if it is allowed to be recycled inside the Alloy Smelter.
     */
    public static void registerReverseSmelting(ItemStack aStack, Materials aMaterial, long aMaterialAmount, boolean aAllowAlloySmelter) {
        if (aStack == null || aMaterial == null || aMaterialAmount <= 0 || aMaterial.contains(SubTag.NO_SMELTING) || (aMaterialAmount > M && aMaterial.contains(SubTag.METAL)))
            return;
        aMaterialAmount /= aStack.stackSize;
        if(aMaterial==Materials.Naquadah||aMaterial==Materials.NaquadahEnriched)return;
        if (aAllowAlloySmelter)
            GT_ModHandler.addSmeltingAndAlloySmeltingRecipe(GT_Utility.copyAmount(1, aStack), GT_OreDictUnificator.getIngot(aMaterial.mSmeltInto, aMaterialAmount));
        else
            GT_ModHandler.addSmeltingRecipe(GT_Utility.copyAmount(1, aStack), GT_OreDictUnificator.getIngot(aMaterial.mSmeltInto, aMaterialAmount));
    }

    public static void registerReverseArcSmelting(ItemStack aStack, Materials aMaterial, long aMaterialAmount, MaterialStack aByProduct01, MaterialStack aByProduct02, MaterialStack aByProduct03) {
        registerReverseArcSmelting(aStack, new ItemData(/*aMaterial == null ? null : */new MaterialStack(aMaterial, aMaterialAmount), aByProduct01, aByProduct02, aByProduct03));
    }

    public static void registerReverseArcSmelting(ItemStack aStack, ItemData aData) {
        if (aStack == null || aData == null) return;
        aData = new ItemData(aData);

        if (!aData.hasValidMaterialData()) return;

        for (MaterialStack tMaterial : aData.getAllMaterialStacks()) {
            if (tMaterial.mMaterial.contains(SubTag.UNBURNABLE)) {
                tMaterial.mMaterial = tMaterial.mMaterial.mSmeltInto.mArcSmeltInto;
                continue;
            }
            if (tMaterial.mMaterial.contains(SubTag.EXPLOSIVE)) {
                tMaterial.mMaterial = Materials.Ash;
                tMaterial.mAmount /= 4;
                continue;
            }
            if (tMaterial.mMaterial.contains(SubTag.FLAMMABLE)) {
                tMaterial.mMaterial = Materials.Ash;
                tMaterial.mAmount /= 2;
                continue;
            }
            if (tMaterial.mMaterial.contains(SubTag.NO_SMELTING)) {
                tMaterial.mAmount = 0;
                continue;
            }
            if (tMaterial.mMaterial.contains(SubTag.METAL)) {
                tMaterial.mMaterial = tMaterial.mMaterial.mSmeltInto.mArcSmeltInto;
                continue;
            }
            tMaterial.mAmount = 0;
        }

        aData = new ItemData(aData);

        if (aData.mByProducts.length > 3) for (MaterialStack tMaterial : aData.getAllMaterialStacks())
            if (tMaterial.mMaterial == Materials.Ash) tMaterial.mAmount = 0;

        aData = new ItemData(aData);

        if (!aData.hasValidMaterialData()) return;

        long tAmount = 0;
        for (MaterialStack tMaterial : aData.getAllMaterialStacks())
            tAmount += tMaterial.mAmount * tMaterial.mMaterial.getMass();

        RA.addArcFurnaceRecipe(aStack, new ItemStack[]{GT_OreDictUnificator.getIngotOrDust(aData.mMaterial), GT_OreDictUnificator.getIngotOrDust(aData.getByProduct(0)), GT_OreDictUnificator.getIngotOrDust(aData.getByProduct(1)), GT_OreDictUnificator.getIngotOrDust(aData.getByProduct(2))}, null, (int) Math.max(16, tAmount / M), 96);
    }

    public static void registerReverseMacerating(ItemStack aStack, Materials aMaterial, long aMaterialAmount, MaterialStack aByProduct01, MaterialStack aByProduct02, MaterialStack aByProduct03, boolean aAllowHammer) {
        registerReverseMacerating(aStack, new ItemData(/*aMaterial == null ? null : */new MaterialStack(aMaterial, aMaterialAmount), aByProduct01, aByProduct02, aByProduct03), aAllowHammer);
    }

    public static void registerReverseMacerating(ItemStack aStack, ItemData aData, boolean aAllowHammer) {
        if (aStack == null || aData == null) return;
        aData = new ItemData(aData);

        if (!aData.hasValidMaterialData()) return;

        for (MaterialStack tMaterial : aData.getAllMaterialStacks())
            tMaterial.mMaterial = tMaterial.mMaterial.mMacerateInto;

        aData = new ItemData(aData);

        if (!aData.hasValidMaterialData()) return;

        long tAmount = 0;
        for (MaterialStack tMaterial : aData.getAllMaterialStacks())
            tAmount += tMaterial.mAmount * tMaterial.mMaterial.getMass();

        RA.addPulveriserRecipe(aStack, new ItemStack[]{GT_OreDictUnificator.getDust(aData.mMaterial), GT_OreDictUnificator.getDust(aData.getByProduct(0)), GT_OreDictUnificator.getDust(aData.getByProduct(1)), GT_OreDictUnificator.getDust(aData.getByProduct(2))}, null, (int) Math.max(16, tAmount / M), 4);

        if (aAllowHammer) for (MaterialStack tMaterial : aData.getAllMaterialStacks())
            if (tMaterial.mMaterial.contains(SubTag.CRYSTAL) && !tMaterial.mMaterial.contains(SubTag.METAL)) {
                if (RA.addForgeHammerRecipe(GT_Utility.copyAmount(1, aStack), GT_OreDictUnificator.getGem(aData.mMaterial), 200, 32))
                    break;
            }
        ItemStack tDust = GT_OreDictUnificator.getDust(aData.mMaterial);
        if (tDust != null && GT_ModHandler.addPulverisationRecipe(GT_Utility.copyAmount(1, aStack), tDust, GT_OreDictUnificator.getDust(aData.getByProduct(0)), 100, GT_OreDictUnificator.getDust(aData.getByProduct(1)), 100, true)) {
            if (GregTech_API.sThaumcraftCompat != null)
                GregTech_API.sThaumcraftCompat.addCrucibleRecipe(IThaumcraftCompat.ADVANCEDENTROPICPROCESSING, aStack, tDust, Arrays.asList(new TC_AspectStack(TC_Aspects.PERDITIO, Math.max(1, (aData.mMaterial.mAmount * 2) / M))));
        }
    }

    /**
     * You give this Function a Material and it will scan almost everything for adding recycling Recipes
     *
     * @param aMat             a Material, for example an Ingot or a Gem.
     * @param aOutput          the Dust you usually get from macerating aMat
     * @param aRecipeReplacing allows to replace the Recipe with a Plate variant
     */
    public static synchronized void registerUsagesForMaterials(ItemStack aMat, String aPlate, boolean aRecipeReplacing) {
    // public static synchronized void 
        if (aMat == null) return;
        aMat = GT_Utility.copy(aMat);
        ItemStack tStack;
        ItemData aItemData = GT_OreDictUnificator.getItemData(aMat);
        boolean aItemData_b_0 = aItemData != null;
        if (!aItemData_b_0 || aItemData.mPrefix != OrePrefixes.ingot) {aPlate = null;}
        if (aPlate != null && GT_OreDictUnificator.getFirstOre(aPlate, 1) == null) {aPlate = null;}
        boolean aItemData_b_1 = aItemData.hasValidPrefixMaterialData();
        boolean aPlate_b_0 = aPlate != null;

        sMt1.func_150996_a(aMat.getItem());
        sMt1.stackSize = 1;
        Items.feather.setDamage(sMt1, Items.feather.getDamage(aMat));

        sMt2.func_150996_a(new ItemStack(Blocks.dirt).getItem());
        sMt2.stackSize = 1;
        Items.feather.setDamage(sMt2, 0);

        for (ItemStack[] tRecipe : sShapes1) {
            int tAmount1 = 0;
            for (ItemStack tMat : tRecipe) {
                if (tMat == sMt1) tAmount1++;
            }
            if (aItemData_b_0 && aItemData_b_1)
                for (ItemStack tCrafted : GT_ModHandler.getRecipeOutputs(tRecipe)) {
                    GT_OreDictUnificator.addItemData(tCrafted, new ItemData(aItemData.mMaterial.mMaterial, aItemData.mMaterial.mAmount * tAmount1));
                }
        }

        if (first_call_gVTRO) {
        GT_ModHandler.getVanillyToolRecipeOutputs(sShapes1[0]);
        /*if (!Ser0) {
        try {
        FileOutputStream outputStream = new FileOutputStream("."+File.separator+"cache2"+File.separator+"sRodMaterialList.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(sRodMaterialList);
        objectOutputStream.flush();
        outputStream.close();
        } catch (Exception e) {cpw.mods.fml.common.FMLLog.log(org.apache.logging.log4j.Level.WARN, (Throwable)e, "Gregtech stacktrace: %s", (Throwable)e);}
        }*/
        first_call_gVTRO = false;}
        //for (Materials tMaterial : sRodMaterialList) {
            //ItemStack tMt2 = GT_OreDictUnificator.get(OrePrefixes.stick, tMaterial, 1);
            //if (tMt2 != null) {
                //GT_Log.out.println("GT_Mod: Debug: sRodMaterialList_cycles " + sRodMaterialList_cycles + " sRodMaterialList_cycles1 " + sRodMaterialList_cycles1);
                //sMt2.func_150996_a(tMt2.getItem());
                //sMt2.stackSize = 1;
                //Items.feather.setDamage(sMt2, Items.feather.getDamage(tMt2));

                if (emptyList_find || GT_ModHandler.sSingleNonBlockDamagableRecipeList.size() == 0 || GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1.size() == 0 || GT_ModHandler.sSingleNonBlockDamagableRecipeList_verified.size() == 0) {
                if (!emptyList_find) {emptyList_find = true;}
                sRodMaterialList_cycles1++;/*continue;*/}
                int sShapes1_len = GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1.size();
                //if (sRodMaterialList_cycles % 100 == 0) GT_Log.out.println("GT_Mod: Debug: sRodMaterialList_cycles " + sRodMaterialList_cycles + " sRodMaterialList_cycles1 " + sRodMaterialList_cycles1);
                for (int i = 0; i < sShapes1_len; i++) {
                    //int i = 0;
                    //if (i_count > 43) {i_count = 0;}
                    //int i = i_count;
                    int i2 = GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1.get(i);
                    ItemStack[] tRecipe = sShapes1[i2];
                    if (tRecipe == null) continue;
                    boolean OneCycleIteration = false;
                    labelOCI: for (Materials tMaterial : sRodMaterialList) {
                    if (OneCycleIteration) break labelOCI;
                    if (OneElemRML) {OneCycleIteration=true;}
                    ItemStack tMt2 = GT_OreDictUnificator.get(OrePrefixes.stick, tMaterial, 1);
                    if (tMt2 != null) {
                    sMt2.func_150996_a(tMt2.getItem());
                    sMt2.stackSize = 1;
                    Items.feather.setDamage(sMt2, Items.feather.getDamage(tMt2));

                    int tAmount1 = 0, tAmount2 = 0;
                    for (ItemStack tMat : tRecipe) {
                        if (tMat == sMt1) tAmount1++;
                        if (tMat == sMt2) tAmount2++;
                    }
                    List <ItemStack> tempTest = GT_ModHandler.getVanillyToolRecipeOutputs(tRecipe);
                    if (GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1_update) {sShapes1_len = GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1.size();GT_ModHandler.sSingleNonBlockDamagableRecipeList_validsShapes1_update = false;}
                    //int tempTest_size_sS = tempTest.size();
                    //if (tempTest_size_sS > 0) {
                    for (ItemStack tCrafted : tempTest/*GT_ModHandler.getVanillyToolRecipeOutputs(tRecipe)*/) {
                        if (aItemData_b_0 && aItemData_b_1) {
                            GT_OreDictUnificator.addItemData(tCrafted, new ItemData(aItemData.mMaterial.mMaterial, aItemData.mMaterial.mAmount * tAmount1, new MaterialStack(tMaterial, OrePrefixes.stick.mMaterialAmount * tAmount2)));
                            }

                        if (aRecipeReplacing && aPlate_b_0 && sShapesA[i2] != null && sShapesA[i2].length > 1) {
                            //assert aItemData != null;//dead dev code or decomp JAD?//only work when add flag -ea (?)
                            if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, new StringBuilder().append(aItemData.mMaterial.mMaterial).append('.').append(sShapesA[i2][0]).toString(), true)) {
                                //sInternalListsBeforeAdd.add(tRecipe);
                                if (null != (tStack = GT_ModHandler.removeRecipe(tRecipe))) {
                                    //boolean addObj = !(tStack.field_151002_e.getUnlocalizedName().startsWith("item.thermalfoundation"));
                                    //if (!addObj) sInternalListsBeforeAdd.remove(sInternalListsBeforeAdd.size()-1);
                                    switch (sShapesA[i2].length) {
                                        case 2:
                                            Object[] tObject = new Object[]{sShapesA[i2][1], s_P.charAt(0), aPlate, s_R.charAt(0), OrePrefixes.stick.get(tMaterial), s_I.charAt(0), aItemData};
                                            /*if (addObj && !Ser0) {
                                            sInternalListsBeforeAdd2.add(tObject);
                                            sInternalListsBeforeAdd3.add(tStack);}*/
                                            /*if (!addObj && Ser0 || !Ser0) */GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.BUFFERED, tObject);
                                            break;
                                        case 3:
                                            Object[] tObject2 = new Object[]{sShapesA[i2][1], sShapesA[i2][2], s_P.charAt(0), aPlate, s_R.charAt(0), OrePrefixes.stick.get(tMaterial), s_I.charAt(0), aItemData};
                                            /*if (addObj && !Ser0) {
                                            sInternalListsBeforeAdd2.add(tObject2);
                                            sInternalListsBeforeAdd3.add(tStack);}*/
                                            /*if (!addObj && Ser0 || !Ser0) */GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.BUFFERED, tObject2);
                                            break;
                                        default:
                                            Object[] tObject3 = new Object[]{sShapesA[i2][1], sShapesA[i2][2], sShapesA[i2][3], s_P.charAt(0), aPlate, s_R.charAt(0), OrePrefixes.stick.get(tMaterial), s_I.charAt(0), aItemData};
                                            /*if (addObj && !Ser0) {
                                            sInternalListsBeforeAdd2.add(tObject3);
                                            sInternalListsBeforeAdd3.add(tStack);}*/
                                            /*if (!addObj && Ser0 || !Ser0) */GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.BUFFERED, tObject3);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    //sRodMaterialList_cycles2++;
                    //}
                    sRodMaterialList_cycles++;//i_count++;
                    //if (sRodMaterialList_cycles % 1000 == 0) GT_Log.out.println("GT_Mod: Debug: sRodMaterialList_cycles " + sRodMaterialList_cycles + " sRodMaterialList_cycles1 " + sRodMaterialList_cycles1);
                }}}
                //GT_Log.out.println("GT_Mod: Debug: sRodMaterialList_cycles2 " + sRodMaterialList_cycles2);
            //}
            tMt2_null_cycles++;
            //if (!Ser0) sRodMaterialList_NonNull.add(tMaterial);
        //}
    }
    public static void cleanupObjects() {
        //crutches for allegedly cleaning
        sMt1=null;sMt2=null;sShapes1=null;sShapesA=null;
        s_H=null;s_F=null;s_I=null;s_P=null;s_R=null;
    }
}
