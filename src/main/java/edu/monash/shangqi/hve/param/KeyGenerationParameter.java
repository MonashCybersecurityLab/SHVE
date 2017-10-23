package edu.monash.shangqi.hve.param;

import edu.monash.shangqi.hve.util.RandomUtil;

public class KeyGenerationParameter {

    private int keyLength;

    public KeyGenerationParameter(int keyLength) {
        this.keyLength = keyLength;
    }

    public byte[] getRandom() {
        return RandomUtil.getRandom(this.keyLength - 1);
    }
}
