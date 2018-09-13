package edu.monash.crypto.hve.param.impl;

import edu.monash.crypto.hve.param.CipherParameter;

/**
 * The scheme parameter of SHVE, it indicates the length of
 * index/predicate vector.
 *
 * @author Shangqi
 */
public final class SHVEParameter implements CipherParameter {

    // length of index/predicate vector
    private long attributeLengths;

    public SHVEParameter(long attributeLengths) {
        this.attributeLengths = attributeLengths;
    }

    public long getSize() {
        return this.attributeLengths;
    }
}
