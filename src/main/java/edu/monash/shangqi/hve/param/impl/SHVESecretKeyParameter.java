package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.Arrays;

public final class SHVESecretKeyParameter extends SHVEKeyParameter {

    private String[] D;
    private int[] B;

    public SHVESecretKeyParameter(SHVEParameter parameter, String[] D, int[] B) {
        super(false, parameter);
        this.D = Arrays.copyOf(D, D.length);
        this.B = Arrays.copyOf(B, B.length);
    }

    public String[] getDs() {
        return (String[])Arrays.copyOf(this.D, this.D.length);
    }

    public int[] getBs() {
        return (int[])Arrays.copyOf(this.B, this.B.length);
    }
}
