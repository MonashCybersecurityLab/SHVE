package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.KeyParameter;

import java.util.Arrays;

public class SHVERandomKeyParameter extends KeyParameter {

    private byte[] randomKey;

    public SHVERandomKeyParameter(byte[] randomKey) {
        super(false);
        this.randomKey = Arrays.copyOf(randomKey, randomKey.length);
    }
}
