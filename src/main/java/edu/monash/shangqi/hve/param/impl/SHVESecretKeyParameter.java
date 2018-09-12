package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.*;

/**
 * The secret key (sk) for a given predicate vector.
 * D0: Masked secret key
 * D1: Encrypted "0"
 * S: non-wildcard position
 *
 * @author Shangqi
 */
public final class SHVESecretKeyParameter extends SHVEKeyParameter {

    // Tuple of sk
    private byte[] D0;
    private byte[] D1;
    private int[] S;

    public SHVESecretKeyParameter(SHVEParameter parameter, byte[] D0, byte[] D1, int[] S) {
        super(false, parameter);
        this.D0 = Arrays.copyOf(D0, D0.length);
        this.D1 = Arrays.copyOf(D1, D1.length);
        // add non-wildcard positions in S
        this.S = Arrays.copyOf(S, S.length);
    }

    public boolean isStar(int index) {
        return getSAt(index) == 1;
    }

    private int getSAt(int index) {
        return this.S[index];
    }

    public byte[] getD0() {
        return Arrays.copyOf(this.D0, this.D0.length);
    }

    public byte[] getD1() {
        return Arrays.copyOf(this.D1, this.D1.length);
    }
}
