package gregtech.api.objects;

import gregtech.api.enums.Materials;

public final class MaterialStack implements Cloneable, java.io.Serializable {
    public long mAmount;
    public Materials mMaterial;
    private static final long serialVersionUID = 2302628494524442001L;

    public MaterialStack() {}
    
    public MaterialStack(Materials aMaterial, long aAmount) {
        mMaterial = aMaterial == null ? Materials._NULL : aMaterial;
        mAmount = aAmount;
    }

    public MaterialStack copy(long aAmount) {
        return new MaterialStack(mMaterial, aAmount);
    }

    @Override
    public MaterialStack clone() {
        try { Object cloneMS = super.clone();
        //return new MaterialStack(mMaterial, mAmount);
        return (MaterialStack) cloneMS;} catch (Exception e) { return new MaterialStack(mMaterial, mAmount); }
    }

    @Override
    public boolean equals(Object aObject) {
        if (aObject == this) return true;
        if (aObject == null) return false;
        if (aObject instanceof Materials) {return aObject == mMaterial;}
        if (aObject instanceof MaterialStack)
            return ((MaterialStack) aObject).mMaterial == mMaterial && (mAmount < 0 || ((MaterialStack) aObject).mAmount < 0 || ((MaterialStack) aObject).mAmount == mAmount);
        return false;
    }

    @Override
    public String toString() {
        String temp1 = "", temp2 = mMaterial.getToolTip(true), temp3 = "", temp4 = "";
        if (mAmount > 1) {
          temp4 = String.valueOf(mAmount);
          if (mMaterial.mMaterialList.size() > 1) {
            temp1 = "(";
            temp3 = ")";
          }
        }
        String concatenate = String.valueOf(new StringBuilder().append(temp1).append(temp2).append(temp3).append(temp4));
        //return (mMaterial.mMaterialList.size() > 1 && mAmount > 1 ? "(" : "") + mMaterial.getToolTip(true) + (mMaterial.mMaterialList.size() > 1 && mAmount > 1 ? ")" : "") + (mAmount > 1 ? mAmount : "");
        return concatenate;
    }

    @Override
    public int hashCode() {
        return mMaterial.hashCode();
    }
}