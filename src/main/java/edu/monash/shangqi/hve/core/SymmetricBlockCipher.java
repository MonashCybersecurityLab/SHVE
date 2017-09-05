package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.KeyParameter;

public abstract class SymmetricBlockCipher implements CipherEngine {

    protected boolean forEncryption;
    protected KeyParameter key;

    protected SymmetricBlockCipher() {}

    public void init(boolean forEncryption, KeyParameter parameter) {
        this.forEncryption = forEncryption;
        this.key = parameter;
    }

    public abstract void initialize();
}
