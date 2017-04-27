package gregtech.common;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.internal.IGT_RecipeAdder;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_Recipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.enums.GT_Values.T;
import static gregtech.api.enums.GT_Values.F;

public class GT_RecipeAdder
        implements IGT_RecipeAdder {
    public boolean addFusionReactorRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration, int aEUt, int aStartEU) {
        return F;
    }

    @Override
    public boolean addFusionReactorRecipe(FluidStack aInput1, FluidStack aInput2, FluidStack aOutput1, int aDuration, int aEUt, int aStartEU) {
        if (aInput1 == null || aInput2 == null || aOutput1 == null || aDuration < 1 || aEUt < 1 || aStartEU < 1) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sFusionRecipes.addRecipe(null, new FluidStack[]{aInput1, aInput2}, new FluidStack[]{aOutput1}, aDuration, aEUt, aStartEU);
        return T;
    }

    public boolean addCentrifugeRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, ItemStack aOutput5, ItemStack aOutput6, int aDuration) {
        return addCentrifugeRecipe(aInput1, aInput2 < 0 ? ItemList.IC2_Fuel_Can_Empty.get(-aInput2, new Object[0]) : aInput2 > 0 ? ItemList.Cell_Empty.get(aInput2, new Object[0]) : null, null, null, aOutput1, aOutput2, aOutput3, aOutput4, aOutput5, aOutput6, null, aDuration, 5);
    }

    public boolean addCentrifugeRecipe(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, ItemStack aOutput5, ItemStack aOutput6, int[] aChances, int aDuration, int aEUt) {
        if (((aInput1 == null) && (aFluidInput == null)) || ((aOutput1 == null) && (aFluidOutput == null))) {
            return F;
        }
        if ((aInput1 != null) && ((aDuration = GregTech_API.sRecipeFile.get("centrifuge", aInput1, aDuration)) <= 0)) {
            return F;
        }
        if ((aFluidInput != null) && ((aDuration = GregTech_API.sRecipeFile.get("centrifuge", aFluidInput.getFluid().getName(), aDuration)) <= 0)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sCentrifugeRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2}, new ItemStack[]{aOutput1, aOutput2, aOutput3, aOutput4, aOutput5, aOutput6}, null, aChances, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addElectrolyzerRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, ItemStack aOutput5, ItemStack aOutput6, int aDuration, int aEUt) {
        return addElectrolyzerRecipe(aInput1, aInput2 < 0 ? ItemList.IC2_Fuel_Can_Empty.get(-aInput2, new Object[0]) : aInput2 > 0 ? ItemList.Cell_Empty.get(aInput2, new Object[0]) : null, null, null, aOutput1, aOutput2, aOutput3, aOutput4, aOutput5, aOutput6, null, aDuration, aEUt);
    }

    public boolean addElectrolyzerRecipe(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, ItemStack aOutput5, ItemStack aOutput6, int[] aChances, int aDuration, int aEUt) {
        if (((aInput1 == null) && (aFluidInput == null)) || ((aOutput1 == null) && (aFluidOutput == null))) {
            return F;
        }
        if ((aInput1 != null) && ((aDuration = GregTech_API.sRecipeFile.get("electrolyzer", aInput1, aDuration)) <= 0)) {
            return F;
        }
        if ((aFluidInput != null) && ((aDuration = GregTech_API.sRecipeFile.get("electrolyzer", aFluidInput.getFluid().getName(), aDuration)) <= 0)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sElectrolyzerRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2}, new ItemStack[]{aOutput1, aOutput2, aOutput3, aOutput4, aOutput5, aOutput6}, null, aChances, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addChemicalRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput, int aDuration) {
        return addChemicalRecipe(aInput1, aInput2, null, null, aOutput, aDuration);
    }

    public boolean addChemicalRecipe(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput, int aDuration) {
        if (((aInput1 == null) && (aFluidInput == null)) || ((aOutput == null) && (aFluidOutput == null))) {
            return F;
        }
        if ((aOutput != null) && ((aDuration = GregTech_API.sRecipeFile.get("chemicalreactor", aOutput, aDuration)) <= 0)) {
            return F;
        }
        if ((aFluidOutput != null) && ((aDuration = GregTech_API.sRecipeFile.get("chemicalreactor", aFluidOutput.getFluid().getName(), aDuration)) <= 0)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sChemicalRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2}, new ItemStack[]{aOutput}, null, null, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, aDuration, 30, 0);
        return T;
    }

    public boolean addBlastRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt, int aLevel) {
        return addBlastRecipe(aInput1, aInput2, null, null, aOutput1, aOutput2, aDuration, aEUt, aLevel);
    }

    public boolean addBlastRecipe(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt, int aLevel) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("blastfurnace", aInput1, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sBlastRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2}, new ItemStack[]{aOutput1, aOutput2}, null, null, new FluidStack[]{aFluidInput}, null, aDuration, aEUt, aLevel);
        return T;
    }

    public boolean addCannerRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("canning", aInput1, aDuration)) <= 0) {
            return F;
        }
        new GT_Recipe(aInput1, aEUt, aInput2, aDuration, aOutput1, aOutput2);
        return T;
    }

    public boolean addAlloySmelterRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null || Materials.Graphite.contains(aInput1))) {
            return F;
        }
        if ((aInput2 == null) && ((OrePrefixes.ingot.contains(aInput1)) || (OrePrefixes.dust.contains(aInput1)) || (OrePrefixes.gem.contains(aInput1)))) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("alloysmelting", aInput2 == null ? aInput1 : aOutput1, aDuration)) <= 0) {
            return F;
        }
        new GT_Recipe(aInput1, aInput2, aEUt, aDuration, aOutput1);
        return T;
    }

    public boolean addCNCRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((/*aDuration = */GregTech_API.sRecipeFile.get("cnc", aOutput1, aDuration)) <= 0) {
            return F;
        }
        return T;
    }

    public boolean addLatheRecipe(ItemStack aInput1, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("lathe", aInput1, aDuration)) <= 0) {
            return F;
        }
        new GT_Recipe(aInput1, aOutput1, aOutput2, aDuration, aEUt);
        return T;
    }

    public boolean addCutterRecipe(ItemStack aInput, FluidStack aLubricant, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt) {
        if ((aInput == null) || (aLubricant == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("cutting", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2}, null, new FluidStack[]{aLubricant}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addCutterRecipe(ItemStack aInput, ItemStack aOutput1, ItemStack aOutput2, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("cutting", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2}, null, new FluidStack[]{Materials.Water.getFluid(Math.max(4, Math.min(1000, aDuration * aEUt / 320)))}, null, aDuration * 2, aEUt, 0);
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2}, null, new FluidStack[]{GT_ModHandler.getDistilledWater(Math.max(3, Math.min(750, aDuration * aEUt / 426)))}, null, aDuration * 2, aEUt, 0);
        GT_Recipe.GT_Recipe_Map.sCutterRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2}, null, new FluidStack[]{Materials.Lubricant.getFluid(Math.max(1, Math.min(250, aDuration * aEUt / 1280)))}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addAssemblerRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("assembling", aOutput1, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sAssemblerRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2 == null ? aInput1 : aInput2}, new ItemStack[]{aOutput1}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addAssemblerRecipe(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("assembling", aOutput1, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sAssemblerRecipes.addRecipe(T, new ItemStack[]{aInput1, (ItemStack) (aInput2 == null ? new ItemStack[]{aInput1} : aInput2)}, new ItemStack[]{aOutput1}, null, new FluidStack[]{aFluidInput == null ? null : aFluidInput}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addWiremillRecipe(ItemStack aInput, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("wiremill", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sWiremillRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addPolarizerRecipe(ItemStack aInput, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("polarizer", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sPolarizerRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addBenderRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("bender", aInput1, aDuration)) <= 0) {
            return F;
        }
        new GT_Recipe(aEUt, aDuration, aInput1, aOutput1);
        return T;
    }

    public boolean addExtruderRecipe(ItemStack aInput, ItemStack aShape, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aShape == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("extruder", aOutput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sExtruderRecipes.addRecipe(T, new ItemStack[]{aInput, aShape}, new ItemStack[]{aOutput}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addSlicerRecipe(ItemStack aInput, ItemStack aShape, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aShape == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("slicer", aOutput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sSlicerRecipes.addRecipe(T, new ItemStack[]{aInput, aShape}, new ItemStack[]{aOutput}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addImplosionRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aInput2 = GregTech_API.sRecipeFile.get("implosion", aInput1, aInput2)) <= 0) {
            return F;
        }
        new GT_Recipe(aInput1, aInput2, aOutput1, aOutput2);
        return T;
    }

    @Deprecated
    public boolean addDistillationRecipe(ItemStack aInput1, int aInput2, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, int aDuration, int aEUt) {
//    if ((aInput1 == null) || (aOutput1 == null)) {
//      return F;
//    }
//    if ((aDuration = GregTech_API.sRecipeFile.get("distillation", aInput1, aDuration)) <= 0) {
//      return F;
//    }
//    new GT_Recipe(aInput1, aInput2, aOutput1, aOutput2, aOutput3, aOutput4, aDuration, aEUt);
//    return T;
        return F;
    }

    public boolean addDistillationTowerRecipe(FluidStack aInput, FluidStack[] aOutputs, ItemStack aOutput2, int aDuration, int aEUt) {
        if (aInput == null || aOutputs == null || aOutputs.length < 1 || aOutputs.length > 5) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("distillation", aInput.getUnlocalizedName(), aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sDistillationRecipes.addRecipe(F, null, new ItemStack[]{aOutput2}, null, new FluidStack[]{aInput}, aOutputs, Math.max(1, aDuration), Math.max(1, aEUt), 0);
        return F;
    }

    public boolean addVacuumFreezerRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("vacuumfreezer", aInput1, aDuration)) <= 0) {
            return F;
        }
        new GT_Recipe(aInput1, aOutput1, aDuration);
        return T;
    }

    public boolean addGrinderRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4) {
        return F;
    }

    public boolean addFuel(ItemStack aInput1, ItemStack aOutput1, int aEU, int aType) {
        if (aInput1 == null) {
            return F;
        }
        new GT_Recipe(aInput1, aOutput1, GregTech_API.sRecipeFile.get("fuel_" + aType, aInput1, aEU), aType);
        return T;
    }

    public boolean addSonictronSound(ItemStack aItemStack, String aSoundName) {
        if ((aItemStack == null) || (aSoundName == null) || (aSoundName.length()==0)) {
            return F;
        }
        GT_Mod.gregtechproxy.mSoundItems.add(aItemStack);
        GT_Mod.gregtechproxy.mSoundNames.add(aSoundName);
        if (aSoundName.startsWith("note.")) {
            GT_Mod.gregtechproxy.mSoundCounts.add(Integer.valueOf(25));
        } else {
            GT_Mod.gregtechproxy.mSoundCounts.add(Integer.valueOf(1));
        }
        return T;
    }

    public boolean addForgeHammerRecipe(ItemStack aInput1, ItemStack aOutput1, int aDuration, int aEUt) {
        if ((aInput1 == null) || (aOutput1 == null)) {
            return F;
        }
        if (!GregTech_API.sRecipeFile.get("forgehammer", aOutput1, T)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sHammerRecipes.addRecipe(T, new ItemStack[]{aInput1}, new ItemStack[]{aOutput1}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addBoxingRecipe(ItemStack aContainedItem, ItemStack aEmptyBox, ItemStack aFullBox, int aDuration, int aEUt) {
        if ((aContainedItem == null) || (aFullBox == null)) {
            return F;
        }
        if (!GregTech_API.sRecipeFile.get("boxing", aFullBox, T)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sBoxinatorRecipes.addRecipe(T, new ItemStack[]{aContainedItem, aEmptyBox}, new ItemStack[]{aFullBox}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addUnboxingRecipe(ItemStack aFullBox, ItemStack aContainedItem, ItemStack aEmptyBox, int aDuration, int aEUt) {
        if ((aFullBox == null) || (aContainedItem == null)) {
            return F;
        }
        if (!GregTech_API.sRecipeFile.get("unboxing", aFullBox, T)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sUnboxinatorRecipes.addRecipe(T, new ItemStack[]{aFullBox}, new ItemStack[]{aContainedItem, aEmptyBox}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addAmplifier(ItemStack aAmplifierItem, int aDuration, int aAmplifierAmountOutputted) {
        if ((aAmplifierItem == null) || (aAmplifierAmountOutputted <= 0)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("amplifier", aAmplifierItem, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sAmplifiers.addRecipe(T, new ItemStack[]{aAmplifierItem}, null, null, null, new FluidStack[]{Materials.UUAmplifier.getFluid(aAmplifierAmountOutputted)}, aDuration, 32, 0);
        return T;
    }

    public boolean addBrewingRecipe(ItemStack aIngredient, Fluid aInput, Fluid aOutput, boolean aHidden) {
        if ((aIngredient == null) || (aInput == null) || (aOutput == null)) {
            return F;
        }
        if (!GregTech_API.sRecipeFile.get("brewing", aOutput.getUnlocalizedName(), T)) {
            return F;
        }
        GT_Recipe tRecipe = GT_Recipe.GT_Recipe_Map.sBrewingRecipes.addRecipe(F, new ItemStack[]{aIngredient}, null, null, new FluidStack[]{new FluidStack(aInput, 750)}, new FluidStack[]{new FluidStack(aOutput, 750)}, 128, 4, 0);
        if ((aHidden) && (tRecipe != null)) {
            tRecipe.mHidden = T;
        }
        return T;
    }

    public boolean addFermentingRecipe(FluidStack aInput, FluidStack aOutput, int aDuration, boolean aHidden) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("fermenting", aOutput.getFluid().getUnlocalizedName(), aDuration)) <= 0) {
            return F;
        }
        GT_Recipe tRecipe = GT_Recipe.GT_Recipe_Map.sFermentingRecipes.addRecipe(F, null, null, null, new FluidStack[]{aInput}, new FluidStack[]{aOutput}, aDuration, 2, 0);
        if ((aHidden) && (tRecipe != null)) {
            tRecipe.mHidden = T;
        }
        return T;
    }

    public boolean addDistilleryRecipe(ItemStack aCircuit, FluidStack aInput, FluidStack aOutput, int aDuration, int aEUt, boolean aHidden) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("distillery", aOutput.getFluid().getUnlocalizedName(), aDuration)) <= 0) {
            return F;
        }
        GT_Recipe tRecipe = GT_Recipe.GT_Recipe_Map.sDistilleryRecipes.addRecipe(T, new ItemStack[]{aCircuit}, null, null, new FluidStack[]{aInput}, new FluidStack[]{aOutput}, aDuration, aEUt, 0);
        if ((aHidden) && (tRecipe != null)) {
            tRecipe.mHidden = T;
        }
        return T;
    }

    public boolean addFluidSolidifierRecipe(ItemStack aMold, FluidStack aInput, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aMold == null) || (aInput == null) || (aOutput == null)) {
            return F;
        }
        if (aInput.isFluidEqual(Materials.PhasedGold.getMolten(144))) {
            aInput = Materials.VibrantAlloy.getMolten(aInput.amount);
        }
        if (aInput.isFluidEqual(Materials.PhasedIron.getMolten(144))) {
            aInput = Materials.PulsatingIron.getMolten(aInput.amount);
        }

        if ((aDuration = GregTech_API.sRecipeFile.get("fluidsolidifier", aOutput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sFluidSolidficationRecipes.addRecipe(T, new ItemStack[]{aMold}, new ItemStack[]{aOutput}, null, new FluidStack[]{aInput}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addFluidSmelterRecipe(ItemStack aInput, ItemStack aRemains, FluidStack aOutput, int aChance, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if (aOutput.isFluidEqual(Materials.PhasedGold.getMolten(1))) {
            aOutput = Materials.VibrantAlloy.getMolten(aOutput.amount);
        }
        if (aOutput.isFluidEqual(Materials.PhasedIron.getMolten(1))) {
            aOutput = Materials.PulsatingIron.getMolten(aOutput.amount);
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("fluidsmelter", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aRemains}, null, new int[]{aChance}, null, new FluidStack[]{aOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addFluidExtractionRecipe(ItemStack aInput, ItemStack aRemains, FluidStack aOutput, int aChance, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if (aOutput.isFluidEqual(Materials.PhasedGold.getMolten(1))) {
            aOutput = Materials.VibrantAlloy.getMolten(aOutput.amount);
        }
        if (aOutput.isFluidEqual(Materials.PhasedIron.getMolten(1))) {
            aOutput = Materials.PulsatingIron.getMolten(aOutput.amount);
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("fluidextractor", aInput, aDuration)) <= 0) {
            return F;
        }

        GT_Recipe.GT_Recipe_Map.sFluidExtractionRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aRemains}, null, new int[]{aChance}, null, new FluidStack[]{aOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addFluidCannerRecipe(ItemStack aInput, ItemStack aOutput, FluidStack aFluidInput, FluidStack aFluidOutput) {
        if ((aInput != null) && (aOutput != null)) {
            if ((aFluidInput == null ? 1 : 0) != (aFluidOutput == null ? 1 : 0)) {
            }
        } else {
            return F;
        }
        if (!GregTech_API.sRecipeFile.get("fluidcanner", aOutput, T)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sFluidCannerRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput}, null, new FluidStack[]{aFluidInput == null ? null : aFluidInput}, new FluidStack[]{aFluidOutput == null ? null : aFluidOutput}, aFluidOutput == null ? aFluidInput.amount / 62 : aFluidOutput.amount / 62, 1, 0);
        return T;
    }

    public boolean addChemicalBathRecipe(ItemStack aInput, FluidStack aBathingFluid, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aBathingFluid == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("chemicalbath", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sChemicalBathRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2, aOutput3}, null, aChances, new FluidStack[]{aBathingFluid}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addElectromagneticSeparatorRecipe(ItemStack aInput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput1 == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("electromagneticseparator", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sElectroMagneticSeparatorRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput1, aOutput2, aOutput3}, null, aChances, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addPrinterRecipe(ItemStack aInput, FluidStack aFluid, ItemStack aSpecialSlot, ItemStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aFluid == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("printer", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sPrinterRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput}, aSpecialSlot, null, new FluidStack[]{aFluid}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addAutoclaveRecipe(ItemStack aInput, FluidStack aFluid, ItemStack aOutput, int aChance, int aDuration, int aEUt) {
        if ((aInput == null) || (aFluid == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("autoclave", aInput, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sAutoclaveRecipes.addRecipe(T, new ItemStack[]{aInput}, new ItemStack[]{aOutput}, null, new int[]{aChance}, new FluidStack[]{aFluid}, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addMixerRecipe(ItemStack aInput1, ItemStack aInput2, ItemStack aInput3, ItemStack aInput4, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput, int aDuration, int aEUt) {
        if (((aInput1 == null) && (aFluidInput == null)) || ((aOutput == null) && (aFluidOutput == null))) {
            return F;
        }
        if ((aOutput != null) && ((aDuration = GregTech_API.sRecipeFile.get("mixer", aOutput, aDuration)) <= 0)) {
            return F;
        }
        if ((aFluidOutput != null) && ((aDuration = GregTech_API.sRecipeFile.get("mixer", aFluidOutput.getFluid().getName(), aDuration)) <= 0)) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sMixerRecipes.addRecipe(T, new ItemStack[]{aInput1, aInput2, aInput3, aInput4}, new ItemStack[]{aOutput}, null, null, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addLaserEngraverRecipe(ItemStack aItemToEngrave, ItemStack aLens, ItemStack aEngravedItem, int aDuration, int aEUt) {
        if ((aItemToEngrave == null) || (aLens == null) || (aEngravedItem == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("laserengraving", aEngravedItem, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sLaserEngraverRecipes.addRecipe(T, new ItemStack[]{aItemToEngrave, aLens}, new ItemStack[]{aEngravedItem}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addFormingPressRecipe(ItemStack aItemToImprint, ItemStack aForm, ItemStack aImprintedItem, int aDuration, int aEUt) {
        if ((aItemToImprint == null) || (aForm == null) || (aImprintedItem == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("press", aImprintedItem, aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sPressRecipes.addRecipe(T, new ItemStack[]{aItemToImprint, aForm}, new ItemStack[]{aImprintedItem}, null, null, null, aDuration, aEUt, 0);
        return T;
    }

    public boolean addFluidHeaterRecipe(ItemStack aCircuit, FluidStack aInput, FluidStack aOutput, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutput == null)) {
            return F;
        }
        if ((aDuration = GregTech_API.sRecipeFile.get("fluidheater", aOutput.getFluid().getUnlocalizedName(), aDuration)) <= 0) {
            return F;
        }
        GT_Recipe.GT_Recipe_Map.sFluidHeaterRecipes.addRecipe(T, new ItemStack[]{aCircuit}, null, null, new FluidStack[]{aInput}, new FluidStack[]{aOutput}, aDuration, aEUt, 0);
        return T;
    }

    public boolean addSifterRecipe(ItemStack aItemToSift, ItemStack[] aSiftedItems, int[] aChances, int aDuration, int aEUt) {
        if ((aItemToSift == null) || (aSiftedItems == null)) {
            return F;
        }
        for (ItemStack tStack : aSiftedItems) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("sifter", aItemToSift, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sSifterRecipes.addRecipe(T, new ItemStack[]{aItemToSift}, aSiftedItems, null, aChances, null, null, aDuration, aEUt, 0);
                return T;
            }
        }
        return F;
    }

    public boolean addArcFurnaceRecipe(ItemStack aInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutputs == null)) {
            return F;
        }
        for (ItemStack tStack : aOutputs) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("arcfurnace", aInput, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, new FluidStack[]{Materials.Oxygen.getGas(aDuration)}, null, Math.max(1, aDuration), Math.max(1, aEUt), 0);
                for (Materials tMaterial : new Materials[]{Materials.Argon, Materials.Nitrogen}) {
                    if (tMaterial.mPlasma != null) {
                        int tPlasmaAmount = (int) Math.max(1L, aDuration / (tMaterial.getMass() * 16L));
                        GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, new FluidStack[]{tMaterial.getPlasma(tPlasmaAmount)}, new FluidStack[]{tMaterial.getGas(tPlasmaAmount)}, Math.max(1, aDuration / 16), Math.max(1, aEUt / 3), 0);
                    }
                }
                return T;
            }
        }
        return F;
    }

    public boolean addSimpleArcFurnaceRecipe(ItemStack aInput, FluidStack aFluidInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutputs == null) || aFluidInput == null) {
            return F;
        }
        for (ItemStack tStack : aOutputs) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("arcfurnace", aInput, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sArcFurnaceRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, new FluidStack[]{aFluidInput}, null, Math.max(1, aDuration), Math.max(1, aEUt), 0);
                return T;
            }
        }
        return F;
    }

    public boolean addPlasmaArcFurnaceRecipe(ItemStack aInput, FluidStack aFluidInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutputs == null) || aFluidInput == null) {
            return F;
        }
        for (ItemStack tStack : aOutputs) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("arcfurnace", aInput, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, new FluidStack[]{aFluidInput}, null, Math.max(1, aDuration), Math.max(1, aEUt), 0);
                return T;
            }
        }
        return F;
    }

    public boolean addPlasmaArcFurnaceRecipe(ItemStack aInput, FluidStack aFluidInput, ItemStack[] aOutputs, FluidStack aFluidOutput, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutputs == null) || aFluidInput == null) {
            return F;
        }
        for (ItemStack tStack : aOutputs) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("arcfurnace", aInput, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sPlasmaArcFurnaceRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, new FluidStack[]{aFluidInput}, new FluidStack[]{aFluidOutput}, Math.max(1, aDuration), Math.max(1, aEUt), 0);
                return T;
            }
        }
        return F;
    }

    public boolean addPulveriserRecipe(ItemStack aInput, ItemStack[] aOutputs, int[] aChances, int aDuration, int aEUt) {
        if ((aInput == null) || (aOutputs == null)) {
            return F;
        }
        for (ItemStack tStack : aOutputs) {
            if (tStack != null) {
                if ((aDuration = GregTech_API.sRecipeFile.get("pulveriser", aInput, aDuration)) <= 0) {
                    return F;
                }
                GT_Recipe.GT_Recipe_Map.sMaceratorRecipes.addRecipe(T, new ItemStack[]{aInput}, aOutputs, null, aChances, null, null, aDuration, aEUt, 0);
                return T;
            }
        }
        return F;
    }

}
