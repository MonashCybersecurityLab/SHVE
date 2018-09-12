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
    private Set<Integer> S;

    public SHVESecretKeyParameter(SHVEParameter parameter, byte[] D0, byte[] D1, Set<Integer> B) {
        super(false, parameter);
        this.D0 = Arrays.copyOf(D0, D0.length);
        this.D1 = Arrays.copyOf(D1, D1.length);
        // add non-wildcard positions in S
        this.S = new HashSet<>();
        this.S.addAll(B);
    }

    public boolean isStar(int index) {
        return !S.add(index);
    }

    public byte[] getD0() {
        return Arrays.copyOf(this.D0, this.D0.length);
    }

    public byte[] getD1() {
        return Arrays.copyOf(this.D1, this.D1.length);
    }

    public Set<Integer> getS() {
        return this.S;
    }
}
