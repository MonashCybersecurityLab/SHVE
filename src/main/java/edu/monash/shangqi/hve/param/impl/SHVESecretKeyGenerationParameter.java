package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.KeyGenerationParameter;

import java.util.Arrays;

public final class SHVESecretKeyGenerationParameter extends KeyGenerationParameter {

    private SHVEMasterSecretKeyParameter masterSecretKey;
    private int[] pattern;

    public SHVESecretKeyGenerationParameter(SHVEMasterSecretKeyParameter masterSecretKey, int... pattern) {
        super(-1);
        this.masterSecretKey = masterSecretKey;
        this.pattern = Arrays.copyOf(pattern, pattern.length);
    }

    public SHVEMasterSecretKeyParameter getMasterSecretKey() {
        return this.masterSecretKey;
    }

    public int[] getPattern() {
        return Arrays.copyOf(this.pattern, this.pattern.length);
    }

    public boolean isStarAt(int index) {
        return this.pattern[index] < 0;
    }

    public int getPatternAt(int index) {
        return this.pattern[index];
    }
}
