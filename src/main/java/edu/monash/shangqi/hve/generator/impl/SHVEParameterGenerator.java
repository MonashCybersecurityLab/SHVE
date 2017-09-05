package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.param.impl.SHVEParameter;

public class SHVEParameterGenerator {

    private int[] attributeLengths;

    public SHVEParameterGenerator() {
    }

    public void init(int n) {
        this.init(n, 1);
    }

    public void init(int n, int numBitsPerAttribute) {

        this.attributeLengths = new int[n];

        for(int i = 0; i < this.attributeLengths.length; ++i) {
            this.attributeLengths[i] = numBitsPerAttribute;
        }
    }

    public SHVEParameter generateParameters() {
        return new SHVEParameter(this.attributeLengths);
    }
}
