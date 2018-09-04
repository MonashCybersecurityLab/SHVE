package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.CipherParameter;

public final class SHVEParameter implements CipherParameter {

    private long attributeLengths;

    public SHVEParameter(long attributeLengths) {
        this.attributeLengths = attributeLengths;
    }

    public long getSize() {
        return this.attributeLengths;
    }
}
