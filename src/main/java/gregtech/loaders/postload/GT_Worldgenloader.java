package gregtech.loaders.postload;

import cpw.mods.fml.common.Loader;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Materials;
import gregtech.common.GT_Worldgen_GT_Ore_Layer;
import gregtech.common.GT_Worldgen_GT_Ore_SmallPieces;
import gregtech.common.GT_Worldgen_Stone;
import gregtech.common.GT_Worldgenerator;

import static gregtech.api.enums.GT_Values.T;
import static gregtech.api.enums.GT_Values.F;

public class GT_Worldgenloader
        implements Runnable {
    public void run() {
        boolean tPFAA = (GregTech_API.sWorldgenFile.get(ConfigCategories.general, "AutoDetectPFAA", T)) && (Loader.isModLoaded("PFAAGeologica"));

        new GT_Worldgenerator();

        new GT_Worldgen_Stone("overworld.stone.blackgranite.tiny", T, GregTech_API.sBlockGranites, 0, 0, 1, 50, 48, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.small", T, GregTech_API.sBlockGranites, 0, 0, 1, 100, 96, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.medium", T, GregTech_API.sBlockGranites, 0, 0, 1, 200, 144, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.large", T, GregTech_API.sBlockGranites, 0, 0, 1, 300, 192, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.huge", T, GregTech_API.sBlockGranites, 0, 0, 1, 400, 240, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.redgranite.tiny", T, GregTech_API.sBlockGranites, 8, 0, 1, 50, 48, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.redgranite.small", T, GregTech_API.sBlockGranites, 8, 0, 1, 100, 96, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.redgranite.medium", T, GregTech_API.sBlockGranites, 8, 0, 1, 200, 144, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.redgranite.large", T, GregTech_API.sBlockGranites, 8, 0, 1, 300, 192, 0, 120, null, F);
        new GT_Worldgen_Stone("overworld.stone.redgranite.huge", T, GregTech_API.sBlockGranites, 8, 0, 1, 400, 240, 0, 120, null, F);

        new GT_Worldgen_Stone("nether.stone.blackgranite.tiny", F, GregTech_API.sBlockGranites, 0, -1, 1, 50, 48, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.blackgranite.small", F, GregTech_API.sBlockGranites, 0, -1, 1, 100, 96, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.blackgranite.medium", F, GregTech_API.sBlockGranites, 0, -1, 1, 200, 144, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.blackgranite.large", F, GregTech_API.sBlockGranites, 0, -1, 1, 300, 192, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.blackgranite.huge", F, GregTech_API.sBlockGranites, 0, -1, 1, 400, 240, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.redgranite.tiny", F, GregTech_API.sBlockGranites, 8, -1, 1, 50, 48, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.redgranite.small", F, GregTech_API.sBlockGranites, 8, -1, 1, 100, 96, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.redgranite.medium", F, GregTech_API.sBlockGranites, 8, -1, 1, 200, 144, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.redgranite.large", F, GregTech_API.sBlockGranites, 8, -1, 1, 300, 192, 0, 120, null, F);
        new GT_Worldgen_Stone("nether.stone.redgranite.huge", F, GregTech_API.sBlockGranites, 8, -1, 1, 400, 240, 0, 120, null, F);

        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.copper", T, 60, 120, 32, !tPFAA, T, T, Materials.Copper);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tin", T, 60, 120, 32, !tPFAA, T, T, Materials.Tin);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bismuth", T, 80, 120, 8, !tPFAA, T, F, Materials.Bismuth);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.coal", T, 60, 100, 24, !tPFAA, F, F, Materials.Coal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iron", T, 40, 80, 16, !tPFAA, T, T, Materials.Iron);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lead", T, 40, 80, 16, !tPFAA, T, T, Materials.Lead);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.zinc", T, 30, 60, 12, !tPFAA, T, T, Materials.Zinc);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.gold", T, 20, 40, 8, !tPFAA, T, T, Materials.Gold);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.silver", T, 20, 40, 8, !tPFAA, T, T, Materials.Silver);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.nickel", T, 20, 40, 8, !tPFAA, T, T, Materials.Nickel);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lapis", T, 20, 40, 4, !tPFAA, F, F, Materials.Lapis);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.diamond", T, 5, 10, 2, !tPFAA, T, F, Materials.Diamond);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.emerald", T, 5, 250, 1, !tPFAA, T, F, Materials.Emerald);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.ruby", T, 5, 250, 1, !tPFAA, T, F, Materials.Ruby);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sapphire", T, 5, 250, 1, !tPFAA, T, F, Materials.Sapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.greensapphire", T, 5, 250, 1, !tPFAA, T, F, Materials.GreenSapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.olivine", T, 5, 250, 1, !tPFAA, T, F, Materials.Olivine);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.topaz", T, 5, 250, 1, !tPFAA, T, F, Materials.Topaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tanzanite", T, 5, 250, 1, !tPFAA, T, F, Materials.Tanzanite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amethyst", T, 5, 250, 1, !tPFAA, T, F, Materials.Amethyst);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.opal", T, 5, 250, 1, !tPFAA, T, F, Materials.Opal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.jasper", T, 5, 250, 1, !tPFAA, T, F, Materials.Jasper);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bluetopaz", T, 5, 250, 1, !tPFAA, T, F, Materials.BlueTopaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amber", T, 5, 250, 1, !tPFAA, T, F, Materials.Amber);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.foolsruby", T, 5, 250, 1, !tPFAA, T, F, Materials.FoolsRuby);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetred", T, 5, 250, 1, !tPFAA, T, F, Materials.GarnetRed);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetyellow", T, 5, 250, 1, !tPFAA, T, F, Materials.GarnetYellow);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.redstone", T, 5, 20, 8, !tPFAA, T, F, Materials.Redstone);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.platinum", T, 20, 40, 8, F, F, T, Materials.Platinum);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iridium", T, 20, 40, 8, F, F, T, Materials.Iridium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.netherquartz", T, 30, 120, 64, F, T, F, Materials.NetherQuartz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.saltpeter", T, 10, 60, 8, F, T, F, Materials.Saltpeter);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_n", T, 10, 60, 32, F, T, F, Materials.Sulfur);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_o", T, 5, 15, 8, !tPFAA, F, F, Materials.Sulfur);

        int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomSmallOreSlots", 16);
        for (int i = 0; i < j; i++) {
            new GT_Worldgen_GT_Ore_SmallPieces("ore.small.custom." + (i < 10 ? "0" : "") + i, F, 0, 0, 0, F, F, F, Materials._NULL);
        }
        new GT_Worldgen_GT_Ore_Layer("ore.mix.naquadah", F, 10, 60, 10, 5, 32, F, F, T, Materials.Naquadah, Materials.Naquadah, Materials.Naquadah, Materials.NaquadahEnriched);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lignite", T, 50, 130, 160, 8, 32, !tPFAA, F, F, Materials.Lignite, Materials.Lignite, Materials.Lignite, Materials.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.coal", T, 50, 80, 80, 6, 32, !tPFAA, F, F, Materials.Coal, Materials.Coal, Materials.Coal, Materials.Lignite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.magnetite", T, 50, 120, 160, 3, 32, !tPFAA, T, F, Materials.Magnetite, Materials.Magnetite, Materials.Iron, Materials.VanadiumMagnetite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.gold", T, 60, 80, 160, 3, 32, !tPFAA, F, F, Materials.Magnetite, Materials.Magnetite, Materials.VanadiumMagnetite, Materials.Gold);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.iron", T, 10, 40, 120, 4, 24, !tPFAA, T, F, Materials.BrownLimonite, Materials.YellowLimonite, Materials.BandedIron, Materials.Malachite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cassiterite", T, 40, 120, 50, 5, 24, !tPFAA, F, T, Materials.Tin, Materials.Tin, Materials.Cassiterite, Materials.Tin);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tetrahedrite", T, 80, 120, 70, 4, 24, !tPFAA, T, F, Materials.Tetrahedrite, Materials.Tetrahedrite, Materials.Copper, Materials.Stibnite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.netherquartz", T, 40, 80, 80, 5, 24, F, T, F, Materials.NetherQuartz, Materials.NetherQuartz, Materials.NetherQuartz, Materials.NetherQuartz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sulfur", T, 5, 20, 100, 5, 24, F, T, F, Materials.Sulfur, Materials.Sulfur, Materials.Pyrite, Materials.Sphalerite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.copper", T, 10, 30, 80, 4, 24, !tPFAA, T, F, Materials.Chalcopyrite, Materials.Iron, Materials.Pyrite, Materials.Copper);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.bauxite", T, 50, 90, 80, 4, 24, !tPFAA, tPFAA, F, Materials.Bauxite, Materials.Bauxite, Materials.Aluminium, Materials.Ilmenite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.salts", T, 50, 60, 50, 3, 24, !tPFAA, F, F, Materials.RockSalt, Materials.Salt, Materials.Lepidolite, Materials.Spodumene);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.redstone", T, 10, 40, 60, 3, 24, !tPFAA, T, F, Materials.Redstone, Materials.Redstone, Materials.Ruby, Materials.Cinnabar);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.soapstone", T, 10, 40, 40, 3, 16, !tPFAA, F, F, Materials.Soapstone, Materials.Talc, Materials.Glauconite, Materials.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.nickel", T, 10, 40, 40, 3, 16, !tPFAA, T, T, Materials.Garnierite, Materials.Nickel, Materials.Cobaltite, Materials.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.platinum", T, 40, 50, 5, 3, 16, !tPFAA, F, T, Materials.Cooperite, Materials.Palladium, Materials.Platinum, Materials.Iridium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pitchblende", T, 10, 40, 40, 3, 16, !tPFAA, F, F, Materials.Pitchblende, Materials.Pitchblende, Materials.Uranium, Materials.Uraninite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.plutonium", T, 20, 30, 10, 3, 16, !tPFAA, F, F, Materials.Uraninite, Materials.Uraninite, Materials.Plutonium, Materials.Uranium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.monazite", T, 20, 40, 30, 3, 16, !tPFAA, tPFAA, F, Materials.Bastnasite, Materials.Bastnasite, Materials.Monazite, Materials.Neodymium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.molybdenum", T, 20, 50, 5, 3, 16, !tPFAA, F, T, Materials.Wulfenite, Materials.Molybdenite, Materials.Molybdenum, Materials.Powellite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tungstate", T, 20, 50, 10, 3, 16, !tPFAA, F, T, Materials.Scheelite, Materials.Scheelite, Materials.Tungstate, Materials.Lithium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sapphire", T, 10, 40, 60, 3, 16, !tPFAA, tPFAA, tPFAA, Materials.Almandine, Materials.Pyrope, Materials.Sapphire, Materials.GreenSapphire);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.manganese", T, 20, 30, 20, 3, 16, !tPFAA, F, T, Materials.Grossular, Materials.Spessartine, Materials.Pyrolusite, Materials.Tantalite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quartz", T, 40, 80, 60, 3, 16, !tPFAA, tPFAA, F, Materials.Quartzite, Materials.Barite, Materials.CertusQuartz, Materials.CertusQuartz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.diamond", T, 5, 20, 40, 2, 16, !tPFAA, F, F, Materials.Graphite, Materials.Graphite, Materials.Diamond, Materials.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.olivine", T, 10, 40, 60, 3, 16, !tPFAA, F, T, Materials.Bentonite, Materials.Magnesite, Materials.Olivine, Materials.Glauconite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.apatite", T, 40, 60, 60, 3, 16, !tPFAA, F, F, Materials.Apatite, Materials.Apatite, Materials.Phosphorus, Materials.Phosphate);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.galena", T, 30, 60, 40, 5, 16, !tPFAA, F, F, Materials.Galena, Materials.Galena, Materials.Silver, Materials.Lead);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lapis", T, 20, 50, 40, 5, 16, !tPFAA, F, T, Materials.Lazurite, Materials.Sodalite, Materials.Lapis, Materials.Calcite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.beryllium", T, 5, 30, 30, 3, 16, !tPFAA, F, T, Materials.Beryllium, Materials.Beryllium, Materials.Emerald, Materials.Thorium);

        int j1 = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomLargeVeinSlots", 16);
        for (int i = 0; i < j1; i++) {
            new GT_Worldgen_GT_Ore_Layer("ore.mix.custom." + (i < 10 ? "0" : "") + i, F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        }
        /*new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.00", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.01", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.02", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.03", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.04", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.05", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.06", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.07", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.08", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.09", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.10", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.11", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.12", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.13", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.14", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.custom.15", F, 0, 0, 0, 0, 0, F, F, F, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);*/
    }
}
