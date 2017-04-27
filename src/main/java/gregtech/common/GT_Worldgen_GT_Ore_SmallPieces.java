package gregtech.common;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.world.GT_Worldgen;
import gregtech.common.blocks.GT_TileEntity_Ores;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class GT_Worldgen_GT_Ore_SmallPieces extends GT_Worldgen {
    public final short mMinY;
    public final short mMaxY;
    public final short mAmount;
    public final short mMeta;
    public final boolean mOverworld;
    public final boolean mNether;
    public final boolean mEnd;
    private static final String worldgen_text = "worldgen.";

    public GT_Worldgen_GT_Ore_SmallPieces(String aName, boolean aDefault, int aMinY, int aMaxY, int aAmount, boolean aOverworld, boolean aNether, boolean aEnd, Materials aPrimary) {
        super(aName, GregTech_API.sWorldgenList, aDefault);
        this.mOverworld = GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "Overworld", aOverworld);
        this.mNether = GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "Nether", aNether);
        this.mEnd = GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "TheEnd", aEnd);
        this.mMinY = ((short) GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "MinHeight", aMinY));
        this.mMaxY = ((short) Math.max(this.mMinY + 1, GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "MaxHeight", aMaxY)));
        this.mAmount = ((short) Math.max(1, GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "Amount", aAmount)));
        this.mMeta = ((short) GregTech_API.sWorldgenFile.get(worldgen_text + this.mWorldGenName, "Ore", aPrimary.mMetaItemSubID));
    }

    public boolean executeWorldgen(World aWorld, Random aRandom, String aBiome, int aDimensionType, int aChunkX, int aChunkZ, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
        //aRandom.nextInt(3) != 2 - decrease gen by 30%, for balance my modpack
        if (aRandom.nextInt(3) != 2) {if (!isGenerationAllowed(aWorld, aDimensionType, ((aDimensionType == -1) && (this.mNether)) || ((aDimensionType == 0) && (this.mOverworld)) || ((aDimensionType == 1) && (this.mEnd)) ? aDimensionType : aDimensionType ^ 0xFFFFFFFF)) {
            return false;
        }
        if (this.mMeta > 0) {
            int i = 0;
            for (int j = Math.max(1, ((int)this.mAmount >> 1) + (aRandom.nextInt(this.mAmount) >> 1)); i < j; i++) {
                GT_TileEntity_Ores.setOreBlock(aWorld, aChunkX + aRandom.nextInt(16), this.mMinY + aRandom.nextInt(Math.max(1, this.mMaxY - this.mMinY)), aChunkZ + aRandom.nextInt(16), this.mMeta + 16000);
            }
        }}
        return true;
    }
}
