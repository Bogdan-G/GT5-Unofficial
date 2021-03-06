package gregtech.api.util;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.objects.ItemData;
import gregtech.common.blocks.GT_Block_Ores;
import gregtech.common.blocks.GT_TileEntity_Ores;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import ic2.api.crops.ICropTile;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import speiger.src.crops.api.ICropCardInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static gregtech.api.enums.GT_Values.E;
import static gregtech.api.enums.GT_Values.T;
import static gregtech.api.enums.GT_Values.F;

public class GT_BaseCrop extends CropCard implements ICropCardInfo, java.io.Serializable {
    public static List<GT_BaseCrop> sCropList = new org.eclipse.collections.impl.list.mutable.FastList<GT_BaseCrop>();
    private String mName = E, mDiscoveredBy = "Gregorius Techneticies", mAttributes[];
    private int mTier = 0, mMaxSize = 0, mAfterHarvestSize = 0, mHarvestSize = 0, mStats[] = new int[5],  mGrowthSpeed = 0;
    private ItemStack mDrop = null, mSpecialDrops[] = null;
    private Materials mBlock = null;
    private static boolean bIc2NeiLoaded = Loader.isModLoaded("Ic2Nei");

    /**
     * To create new Crops
     *
     * @param aID           Default ID
     * @param aCropName     Name of the Crop
     * @param aDiscoveredBy The one who discovered the Crop
     * @param aDrop         The Item which is dropped by the Crop. must be != null
     * @param aBaseSeed     Baseseed to plant this Crop. null == crossbreed only
     * @param aTier         tier of the Crop. forced to be >= 1
     * @param aMaxSize      maximum Size of the Crop. forced to be >= 3
     * @param aGrowthSpeed  how fast the Crop grows. if < 0 then its set to Tier*300
     * @param aHarvestSize  the size the Crop needs to be harvested. forced to be between 2 and max size
     */
    public GT_BaseCrop(int aID, String aCropName, String aDiscoveredBy, ItemStack aDrop, ItemStack[] aSpecialDrops, ItemStack aBaseSeed, int aTier, int aMaxSize, int aGrowthSpeed, int aAfterHarvestSize, int aHarvestSize, int aStatChemical, int aStatFood, int aStatDefensive, int aStatColor, int aStatWeed, String[] aAttributes) {
        this(aID, aCropName, aDiscoveredBy, aDrop, aSpecialDrops, aBaseSeed, aTier, aMaxSize, aGrowthSpeed, aAfterHarvestSize, aHarvestSize, aStatChemical, aStatFood, aStatDefensive, aStatColor, aStatWeed, aAttributes, null);
    }
    
    /**
     * To create new Crops
     *
     * @param aID           Default ID
     * @param aCropName     Name of the Crop
     * @param aDiscoveredBy The one who discovered the Crop
     * @param aDrop         The Item which is dropped by the Crop. must be != null
     * @param aBaseSeed     Baseseed to plant this Crop. null == crossbreed only
     * @param aTier         tier of the Crop. forced to be >= 1
     * @param aMaxSize      maximum Size of the Crop. forced to be >= 3
     * @param aGrowthSpeed  how fast the Crop grows. if < 0 then its set to Tier*300
     * @param aHarvestSize  the size the Crop needs to be harvested. forced to be between 2 and max size
     * @param aBlock        the block below needed for crop to grow. If null no block needed
     * @param aMeta         meta of the block below(-1 if no meta)
     */
    public GT_BaseCrop(int aID, String aCropName, String aDiscoveredBy, ItemStack aDrop, ItemStack[] aSpecialDrops, ItemStack aBaseSeed, int aTier, int aMaxSize, int aGrowthSpeed, int aAfterHarvestSize, int aHarvestSize, int aStatChemical, int aStatFood, int aStatDefensive, int aStatColor, int aStatWeed, String[] aAttributes, Materials aBlock) {
        mName = aCropName;
        aID = GT_Config.addIDConfig(ConfigCategories.IDs.crops, mName.replaceAll(" ", "_"), aID);
        if (aDiscoveredBy != null && !aDiscoveredBy.equals(E)) mDiscoveredBy = aDiscoveredBy;
        if (aDrop != null && aID > 0 && aID < 256) {
            mDrop = GT_Utility.copy(aDrop);
            mSpecialDrops = aSpecialDrops;
            mTier = Math.max(1, aTier);
            mMaxSize = Math.max(3, aMaxSize);
//			mGrowthSpeed = aGrowthSpeed>0?aGrowthSpeed:mTier*300;
            mHarvestSize = Math.min(Math.max(aHarvestSize, 2), mMaxSize);
            mAfterHarvestSize = Math.min(Math.max(aAfterHarvestSize, 1), mMaxSize - 1);
            mStats[0] = aStatChemical;
            mStats[1] = aStatFood;
            mStats[2] = aStatDefensive;
            mStats[3] = aStatColor;
            mStats[4] = aStatWeed;
            mAttributes = aAttributes;
            mBlock = aBlock;
            if(GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.crops, aCropName, T)){
            if (!Crops.instance.registerCrop(this, aID))
                throw new GT_ItsNotMyFaultException("Make sure the Crop ID is valid!");
            if (aBaseSeed != null) Crops.instance.registerBaseSeed(aBaseSeed, aID, 1, 1, 1, 1);
            sCropList.add(this);}
        }
        if (bIc2NeiLoaded) {
            try {
                Class.forName("speiger.src.crops.api.CropPluginAPI").getMethod("registerCropInfo", Class.forName("speiger.src.crops.api.ICropCardInfo")).invoke(Class.forName("speiger.src.crops.api.CropPluginAPI").getField("instance"), this);
            } catch (IllegalAccessException | IllegalArgumentException | java.lang.reflect.InvocationTargetException ex) {
                bIc2NeiLoaded = F;
            } catch (NoSuchFieldException | NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
                bIc2NeiLoaded = F;
            }
        }
    }

    @Override
    public byte getSizeAfterHarvest(ICropTile crop) {
        return (byte) mAfterHarvestSize;
    }

    @Override
    public int growthDuration(ICropTile aCrop) {
        if (mGrowthSpeed < 200) return super.growthDuration(aCrop);
        return tier() * mGrowthSpeed;
    }

    public int getrootslength(ICropTile crop) {
        return 5;
    }
    
    @Override
    public String[] attributes() {
        return mAttributes;
    }

    @Override
    public String discoveredBy() {
        return mDiscoveredBy;
    }

    @Override
    public final boolean canGrow(ICropTile aCrop) {
        if (mBlock != null && aCrop.getSize() == mMaxSize - 1) { return isBlockBelow(aCrop); }
        return aCrop.getSize() < maxSize();
    }

    @Override
    public final boolean canBeHarvested(ICropTile aCrop) {
        return aCrop.getSize() >= mHarvestSize;
    }

    @Override
    public boolean canCross(ICropTile aCrop) {
        return aCrop.getSize() + 2 > maxSize();
    }

    @Override
    public int stat(int n) {
        if (n < 0 || n >= mStats.length) return 0;
        return mStats[n];
    }

    @Override
    public String name() {
        return mName;
    }

    @Override
    public int tier() {
        return mTier;
    }

    @Override
    public int maxSize() {
        return mMaxSize;
    }

    @Override
    public ItemStack getGain(ICropTile aCrop) {
        int tDrop = 0;
        if (mSpecialDrops != null && (tDrop = java.util.concurrent.ThreadLocalRandom.current().nextInt(0, mSpecialDrops.length + 4)) < mSpecialDrops.length && mSpecialDrops[tDrop] != null) {
            return GT_Utility.copy(mSpecialDrops[tDrop]);
        }
        return GT_Utility.copy(mDrop);
    }

    @Override
    public boolean rightclick(ICropTile aCrop, EntityPlayer aPlayer) {
        if (!canBeHarvested(aCrop)) return F;
        return aCrop.harvest(aPlayer == null ? F : aPlayer instanceof EntityPlayerMP);
    }

    @Override
    public int getOptimalHavestSize(ICropTile crop) {
        return maxSize();
    }

    public boolean isBlockBelow(ICropTile aCrop) {
        if (aCrop == null) {
            return F;
        }
        for (int i = 1; i < this.getrootslength(aCrop); i++) {
            Block tBlock = aCrop.getWorld().getBlock(aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ);
            if ((tBlock instanceof GT_Block_Ores)) {
                TileEntity tTileEntity = aCrop.getWorld().getTileEntity(aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ);
                if ((tTileEntity instanceof GT_TileEntity_Ores)) {
                    Materials tMaterial = GregTech_API.sGeneratedMaterials[(((GT_TileEntity_Ores) tTileEntity).mMetaData % 1000)];
                    if ((tMaterial != null) && (tMaterial != Materials._NULL)) {
                        if (tMaterial == mBlock) {
                            return T;
                        } else {
                            return F;
                        }
                    }
                }
            } else {
                int tMetaID = aCrop.getWorld().getBlockMetadata(aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ);
                ItemData tAssotiation = GT_OreDictUnificator.getAssociation(new ItemStack(tBlock, 1, tMetaID));
                if ((tAssotiation != null) && (tAssotiation.mMaterial.mMaterial == mBlock) && (tAssotiation.mPrefix.toString().startsWith("ore") || (tAssotiation.mPrefix == OrePrefixes.block))) {
                    return T;
                }
            }
//	      Block block = aCrop.getWorld().getBlock(aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ);
//	      if (block.isAir(aCrop.getWorld(), aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ)) {
//	        return F;
//	      }
//	      if (block == mBlock) {
//	    	  int tMeta = aCrop.getWorld().getBlockMetadata(aCrop.getLocation().posX, aCrop.getLocation().posY - i, aCrop.getLocation().posZ);
//	    	  if(mMeta < 0 || tMeta == mMeta){
//	        return T;}
//	      }
        }
        return F;
    }

    public List<String> getCropInformation() {
        if (mBlock != null) {
            List<String> result = new org.eclipse.collections.impl.list.mutable.FastList<String>(1);
            result.add(String.format("Requires %s Ore or Block of %s as soil block to reach full growth.", mBlock.name(), mBlock.name()));
            return result;
        }
        return null;
    }

    public ItemStack getDisplayItem() {
        if (mSpecialDrops != null && mSpecialDrops[mSpecialDrops.length - 1] != null) {
            return GT_Utility.copy(mSpecialDrops[mSpecialDrops.length - 1]);
        }
        return GT_Utility.copy(mDrop);
    }

}
