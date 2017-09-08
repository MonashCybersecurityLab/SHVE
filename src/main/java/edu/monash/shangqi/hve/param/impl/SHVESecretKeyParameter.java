package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.ArrayList;
import java.util.Arrays;

public final class SHVESecretKeyParameter extends SHVEKeyParameter {

    private ArrayList<byte[]> D;
    private int[] B;

    public SHVESecretKeyParameter(SHVEParameter parameter, ArrayList<byte[]> D, int[] B) {
        super(false, parameter);
        this.D = new ArrayList<>(D);
        this.B = Arrays.copyOf(B, B.length);
    }

    public boolean isStar(int index) {
        return this.getBAt(index) == 1;
    }

    public byte[] getDAt(int index) {
        return this.D.get(index);
    }

    public int getBAt(int index) {
        return this.B[index];
    }

    public ArrayList<byte[]> getDs() {
        return new ArrayList<>(this.D);
    }

    public int[] getBs() {
        return (int[])Arrays.copyOf(this.B, this.B.length);
    }
}
