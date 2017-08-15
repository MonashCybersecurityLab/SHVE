package edu.monash.shangqi.param;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class HVEKeyParameter extends AsymmetricKeyParameter {

    private HVEParameter parameter;

    public HVEKeyParameter(boolean isPrivate, HVEParameter parameter) {
        super(isPrivate);
        this.parameter = parameter;
    }

    public HVEParameter getParameter() {
        return parameter;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof HVEKeyParameter)) {
            return false;
        } else {
            HVEKeyParameter that = (HVEKeyParameter)o;
            if (this.parameter != null) {
                if (!this.parameter.equals(that.parameter)) {
                    return false;
                }
            } else if (that.parameter != null) {
                return false;
            }

            return true;
        }
    }

    public int hashCode() {
        return this.parameter != null ? this.parameter.hashCode() : 0;
    }
}
