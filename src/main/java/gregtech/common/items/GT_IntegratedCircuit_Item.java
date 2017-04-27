package gregtech.common.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.items.GT_Generic_Item;
import gregtech.api.util.GT_LanguageManager;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;
import java.io.*;

public class GT_IntegratedCircuit_Item
        extends GT_Generic_Item {
    private final static String text3 = "   ";
    public GT_IntegratedCircuit_Item() {
        super("integrated_circuit", "Integrated Circuit", "");
        setHasSubtypes(true);
        setMaxDamage(0);

        ItemList.Circuit_Integrated.set(this);


        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 0L, new Object[0]), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.circuit.get(Materials.Basic)});

        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 1L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"d  ", " P ", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 2L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" d ", " P ", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 3L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  d", " P ", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 4L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, " Pd", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 5L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, " P ", "  d", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 6L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, " P ", " d ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 7L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, " P ", "d  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 8L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, "dP ", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});

        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 9L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"P d", text3, text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 10L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"P  ", "  d", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 11L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"P  ", text3, "  d", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 12L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"P  ", text3, " d ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 13L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  P", text3, "  d", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 14L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  P", text3, " d ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 15L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  P", text3, "d  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 16L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  P", "d  ", text3, 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 17L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, text3, "d P", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 18L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, "d  ", "  P", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 19L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"d  ", text3, "  P", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 20L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" d ", text3, "  P", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 21L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"d  ", text3, "P  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 22L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" d ", text3, "P  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 23L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"  d", text3, "P  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
        GT_ModHandler.addCraftingRecipe(ItemList.Circuit_Integrated.getWithDamage(1L, 24L, new Object[0]), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{text3, "  d", "P  ", 'P', ItemList.Circuit_Integrated.getWildcard(1L, new Object[0])});
    }

    private static String getModeString(int aMetaData) {
        switch ((byte) (aMetaData >>> 8)) {
            case 0:
                return "==";
            case 1:
                return "<=";
            case 2:
                return ">=";
            case 3:
                return "<";
            case 4:
                return ">";
        }
        return "";
    }

    private static String getConfigurationString(int aMetaData) {
        return getModeString(aMetaData) + " " + (byte) (aMetaData & 0xFF);
    }

    public void addAdditionalToolTips(List aList, ItemStack aStack) {
        super.addAdditionalToolTips(aList, aStack);
        aList.add(GT_LanguageManager.addStringLocalization(new StringBuilder().append(getUnlocalizedName()).append(".configuration").toString(), "Configuration: ") + getConfigurationString(getDamage(aStack)));
    }

    public String getUnlocalizedName(ItemStack aStack) {
        return getUnlocalizedName();
    }

    @SideOnly(Side.CLIENT)
    public final void getSubItems(Item var1, CreativeTabs aCreativeTab, List aList) {
        aList.add(new ItemStack(this, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister aIconRegister) {
        super.registerIcons(aIconRegister);
        if (GregTech_API.sPostloadFinished) {
            GT_Log.out.println("GT_Mod: Starting Item Icon Load Phase");
            //GT_Log.out.println("GT_Mod: Starting Item Icon Load Phase");
            GregTech_API.sItemIcons = aIconRegister;
            try {
            for (Runnable tRunnable : GregTech_API.sGTItemIconload) {
                    tRunnable.run();
            }} catch (Throwable e) {final ByteArrayOutputStream baos = new ByteArrayOutputStream();e.printStackTrace(new PrintStream(baos));GT_Log.out.println("GT_Mod: Error: "+baos.toString());}
            GT_Log.out.println("GT_Mod: Finished Item Icon Load Phase");
            //GT_Log.out.println("GT_Mod: Finished Item Icon Load Phase");
        }
    }
}
