package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.param.impl.SHVEParameter;

public class SHVEParameterGenerator {

    private long attributeLengths;

    public SHVEParameterGenerator() {
    }

    public void init(long size) {
        this.attributeLengths = size;
    }

    public SHVEParameter generateParameters() {
        return new SHVEParameter(this.attributeLengths);
    }
}
