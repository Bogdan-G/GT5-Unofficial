package gregtech.api.util;

import ic2.api.item.IBoxable;
import net.minecraft.item.ItemStack;

import static gregtech.api.enums.GT_Values.T;

public class GT_IBoxableWrapper implements IBoxable {
    @Override
    public boolean canBeStoredInToolbox(ItemStack itemstack) {
        return T;
    }
}