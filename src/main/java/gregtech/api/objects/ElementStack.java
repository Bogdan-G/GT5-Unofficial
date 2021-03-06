package gregtech.api.objects;

import gregtech.api.enums.Element;

public final class ElementStack implements Cloneable, java.io.Serializable {
    public int mAmount;
    public Element mElement;
    private static final long serialVersionUID = 2302628094500062901L;

    public ElementStack() {}
    
    public ElementStack(Element aElement, int aAmount) {
        mElement = aElement == null ? Element._NULL : aElement;
        mAmount = aAmount;
    }

    public ElementStack copy(int aAmount) {
        return new ElementStack(mElement, aAmount);
    }

    @Override
    public ElementStack clone() {
        try { Object cloneES = super.clone();
        //return new ElementStack(mElement, mAmount);
        return (ElementStack) cloneES; } catch (Exception e) { return new ElementStack(mElement, mAmount); }
    }

    @Override
    public boolean equals(Object aObject) {
        if (aObject == this) return true;
        if (aObject == null) return false;
        if (aObject instanceof Element) {return aObject == mElement;}
        if (aObject instanceof ElementStack)
            return ((ElementStack) aObject).mElement == mElement && (mAmount < 0 || ((ElementStack) aObject).mAmount < 0 || ((ElementStack) aObject).mAmount == mAmount);
        return false;
    }

    @Override
    public String toString() {
        return mElement.toString() + mAmount;
    }

    @Override
    public int hashCode() {
        return mElement.hashCode();
    }
}