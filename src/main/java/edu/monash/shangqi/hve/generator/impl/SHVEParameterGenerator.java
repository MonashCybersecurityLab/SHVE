package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.param.impl.SHVEParameter;

/**
 * Generator for SHVE parameter, it translates the field size and # of
 * attributes to the length of index vector.
 * <br>
 * In our implementation, the field size is 2 (fixed, GF(2)), which can
 * be represented by 1 bit, the length of index vector is equal to
 * the # of attributes.
 *
 * @author Shangqi
 */
public final class SHVEParameterGenerator {

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
