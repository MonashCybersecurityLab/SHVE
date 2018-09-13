package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.KeyGenerationParameter;

import java.util.Arrays;

/**
 * The generator parameter of sk, it uses the msk
 * and a given predicate vector to generate a tuple of
 * three elements (S, d0, d1).
 *
 * @author Shangqi
 */
public final class SHVESecretKeyGenerationParameter extends KeyGenerationParameter {

    // The master secret key
    private SHVEMasterSecretKeyParameter masterSecretKey;

    // Predicate vector
    private int[] pattern;

    public SHVESecretKeyGenerationParameter(SHVEMasterSecretKeyParameter masterSecretKey, int... pattern) {
        // The key length is invalid for sk, as it is a tuple
        // instead of a block key.
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

    // Check the wildcard element
    public boolean isStarAt(int index) {
        return getPatternAt(index) < 0;
    }

    public int getPatternAt(int index) {
        return this.pattern[index];
    }
}
