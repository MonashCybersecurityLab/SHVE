package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.Arrays;

/**
 * The secret key for a given
 */
public final class SHVESecretKeyParameter extends SHVEKeyParameter {

    private byte[] D0;
    private byte[] D1;
    private int[] B;

    public SHVESecretKeyParameter(SHVEParameter parameter, byte[] D0, byte[] D1, int[] B) {
        super(false, parameter);
        this.D0 = Arrays.copyOf(D0, D0.length);
        this.D1 = Arrays.copyOf(D1, D1.length);
        this.B = Arrays.copyOf(B, B.length);
    }

    public boolean isStar(int index) {
        return this.getBAt(index) == 1;
    }

    public int getBAt(int index) {
        return this.B[index];
    }

    public byte[] getD0() {
        return Arrays.copyOf(this.D0, this.D0.length);
    }

    public byte[] getD1() {
        return Arrays.copyOf(this.D1, this.D1.length);
    }

    public int[] getBs() {
        return Arrays.copyOf(this.B, this.B.length);
    }
}
