package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public final class SHVESecretKeyParameter extends SHVEKeyParameter {

    private byte[] D;
    private int[] B;

    public SHVESecretKeyParameter(SHVEParameter parameter, byte[] D, int[] B) {
        super(false, parameter);
        this.D = Arrays.copyOf(D, D.length);
        this.B = Arrays.copyOf(B, B.length);
    }

    public boolean isStar(int index) {
        return this.getBAt(index) == 1;
    }

    public int getBAt(int index) {
        return this.B[index];
    }

    public byte[] getDs() {
        return Arrays.copyOf(this.D, this.D.length);
    }

    public int[] getBs() {
        return Arrays.copyOf(this.B, this.B.length);
    }
}
