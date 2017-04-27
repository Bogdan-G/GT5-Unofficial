package gregtech.common.render;

import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Item;
import gregtech.api.util.GT_Utility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import static gregtech.api.enums.GT_Values.T;
import static gregtech.api.enums.GT_Values.F;

public class GT_MetaGenerated_Item_Renderer
        implements IItemRenderer {
    public GT_MetaGenerated_Item_Renderer() {
        for (GT_MetaGenerated_Item tItem : GT_MetaGenerated_Item.sInstances.values()) {
            if (tItem != null && tItem.useStandardMetaItemRenderer()) MinecraftForgeClient.registerItemRenderer(tItem, this);
        }
    }

    public boolean handleRenderType(ItemStack aStack, IItemRenderer.ItemRenderType aType) {
        if (!(GT_Utility.isStackInvalid(aStack)) && (aStack.getItemDamage() >= 0) && ((aType == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) || (aType == IItemRenderer.ItemRenderType.INVENTORY) || (aType == IItemRenderer.ItemRenderType.EQUIPPED) || (aType == IItemRenderer.ItemRenderType.ENTITY))) return T;
        return F;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType aType, ItemStack aStack, IItemRenderer.ItemRendererHelper aHelper) {
        if (!GT_Utility.isStackInvalid(aStack) && aType == IItemRenderer.ItemRenderType.ENTITY) return T;
        return F;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack aStack, Object... data) {
        //if (GT_Utility.isStackInvalid(aStack)) return;//null itemstack drop?
        short aMetaData = (short) aStack.getItemDamage();
        //if (aMetaData < 0) return;//at an earlier stage it was not checked?
        GT_MetaGenerated_Item aItem = (GT_MetaGenerated_Item) aStack.getItem();


        GL11.glEnable(3042);
        if (type == IItemRenderer.ItemRenderType.ENTITY) {
            if (RenderItem.renderInFrame) {
                GL11.glScalef(0.85F, 0.85F, 0.85F);
                GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
                GL11.glTranslatef(-0.5F, -0.42F, 0.0F);
            } else {
                GL11.glTranslatef(-0.5F, -0.42F, 0.0F);
            }
        }
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        if (aMetaData < aItem.mOffset) {
            IIconContainer aIcon = aItem.getIconContainer(aMetaData);
            IIcon tOverlay = null;
            IIcon tFluidIcon = null;
            IIcon tIcon;
            if (aIcon == null) {
                tIcon = aStack.getIconIndex();
            } else {
                tIcon = aIcon.getIcon();
                tOverlay = aIcon.getOverlayIcon();
            }
            if (tIcon == null) return;
            FluidStack tFluid = GT_Utility.getFluidForFilledItem(aStack, T);
            if ((tOverlay != null) && (tFluid != null) && (tFluid.getFluid() != null)) {
                tFluidIcon = tFluid.getFluid().getIcon(tFluid);
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
            GL11.glBlendFunc(770, 771);
            if (tFluidIcon == null) {
                short[] tModulation = aItem.getRGBa(aStack);
                GL11.glColor3f(tModulation[0] / 255.0F, tModulation[1] / 255.0F, tModulation[2] / 255.0F);
            }
            if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                GT_RenderUtil.renderItemIcon(tIcon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
            } else {
                ItemRenderer.renderItemIn2D(Tessellator.instance, tIcon.getMaxU(), tIcon.getMinV(), tIcon.getMinU(), tIcon.getMaxV(), tIcon.getIconWidth(), tIcon.getIconHeight(), 0.0625F);
            }
            if (tFluidIcon != null) {
                //assert (tFluid != null);
                int tColor = tFluid.getFluid().getColor(tFluid);
                GL11.glColor3f((tColor >> 16 & 0xFF) / 255.0F, (tColor >> 8 & 0xFF) / 255.0F, (tColor & 0xFF) / 255.0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);
                GL11.glBlendFunc(770, 771);
                GL11.glDepthFunc(514);
                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    GT_RenderUtil.renderItemIcon(tFluidIcon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
                } else {
                    ItemRenderer.renderItemIn2D(Tessellator.instance, tFluidIcon.getMaxU(), tFluidIcon.getMinV(), tFluidIcon.getMinU(), tFluidIcon.getMaxV(), tFluidIcon.getIconWidth(), tFluidIcon.getIconHeight(), 0.0625F);
                }
                GL11.glDepthFunc(515);
            }
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            if (tOverlay != null) {
                Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
                GL11.glBlendFunc(770, 771);
                if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                    GT_RenderUtil.renderItemIcon(tOverlay, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
                } else {
                    ItemRenderer.renderItemIn2D(Tessellator.instance, tOverlay.getMaxU(), tOverlay.getMinV(), tOverlay.getMinU(), tOverlay.getMaxV(), tOverlay.getIconWidth(), tOverlay.getIconHeight(), 0.0625F);
                }
            }
        } else {
            IIcon tIcon;
            if (aItem.mIconList[(aMetaData - aItem.mOffset)].length > 1) {
                Long[] tStats = (Long[]) aItem.mElectricStats.get(Short.valueOf(aMetaData));

                if ((tStats != null) && (tStats[3].longValue() < 0L)) {
                    long tCharge = aItem.getRealCharge(aStack);

                    if (tCharge <= 0L) {
                        tIcon = aItem.mIconList[(aMetaData - aItem.mOffset)][1];
                    } else {

                        if (tCharge >= tStats[0].longValue()) {
                            tIcon = aItem.mIconList[(aMetaData - aItem.mOffset)][8];
                        } else {
                            tIcon = aItem.mIconList[(aMetaData - aItem.mOffset)][(7 - (int) java.lang.Math.max(0L, java.lang.Math.min(5L, (tStats[0].longValue() - tCharge) * 6L / tStats[0].longValue())))];
                        }
                    }
                } else {
                    tIcon = aItem.mIconList[(aMetaData - aItem.mOffset)][0];
                }
            } else {
                tIcon = aItem.mIconList[(aMetaData - aItem.mOffset)][0];
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
            GL11.glBlendFunc(770, 771);
            if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                GT_RenderUtil.renderItemIcon(tIcon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
            } else {
                ItemRenderer.renderItemIn2D(Tessellator.instance, tIcon.getMaxU(), tIcon.getMinV(), tIcon.getMinU(), tIcon.getMaxV(), tIcon.getIconWidth(), tIcon.getIconHeight(), 0.0625F);
            }
        }
        GL11.glDisable(3042);
    }
}
