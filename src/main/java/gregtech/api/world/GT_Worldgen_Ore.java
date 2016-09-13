package gregtech.api.world;

import gregtech.api.GregTech_API;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.collections.impl.list.mutable.FastList;

public abstract class GT_Worldgen_Ore extends GT_Worldgen {
    public final int mBlockMeta, mAmount, mSize, mMinY, mMaxY, mProbability, mDimensionType;
    public final Block mBlock;
    public final Collection<String> mBiomeList;//all id biomes from 0-256? then it may be static?
    public final boolean mAllowToGenerateinVoid;
    private static final String worldgen_text = "worldgen.";

    public GT_Worldgen_Ore(String aName, boolean aDefault, Block aBlock, int aBlockMeta, int aDimensionType, int aAmount, int aSize, int aProbability, int aMinY, int aMaxY, Collection<String> aBiomeList, boolean aAllowToGenerateinVoid) {
        super(aName, GregTech_API.sWorldgenList, aDefault);
        mDimensionType = aDimensionType;
        mBlock = aBlock;
        mBlockMeta = Math.min(Math.max(aBlockMeta, 0), 15);
        mProbability = GregTech_API.sWorldgenFile.get(worldgen_text + mWorldGenName, "Probability", aProbability);
        mAmount = GregTech_API.sWorldgenFile.get(worldgen_text + mWorldGenName, "Amount", aAmount);
        mSize = GregTech_API.sWorldgenFile.get(worldgen_text + mWorldGenName, "Size", aSize);
        mMinY = GregTech_API.sWorldgenFile.get(worldgen_text + mWorldGenName, "MinHeight", aMinY);
        mMaxY = GregTech_API.sWorldgenFile.get(worldgen_text + mWorldGenName, "MaxHeight", aMaxY);
        if (aBiomeList == null) mBiomeList = new FastList<String>();
        else mBiomeList = aBiomeList;
        mAllowToGenerateinVoid = aAllowToGenerateinVoid;
    }
}