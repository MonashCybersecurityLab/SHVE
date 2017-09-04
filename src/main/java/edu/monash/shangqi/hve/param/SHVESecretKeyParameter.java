package edu.monash.shangqi.hve.param;

import java.util.Arrays;

public final class SHVESecretKeyParameter {

    private String[] D;
    private int[] B;

    public SHVESecretKeyParameter(String[] D, int[] B) {
        this.D = Arrays.copyOf(D, D.length);
        this.B = Arrays.copyOf(B, B.length);
    }

    public String[] getYs() {
        return (String[])Arrays.copyOf(this.D, this.D.length);
    }

    public int[] getLs() {
        return (int[])Arrays.copyOf(this.B, this.B.length);
    }
}
