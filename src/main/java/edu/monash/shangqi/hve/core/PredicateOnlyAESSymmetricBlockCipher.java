package edu.monash.shangqi.hve.core;

public abstract class PredicateOnlyAESSymmetricBlockCipher
        extends AESSymmetricBlockCipher
        implements PredicateOnlyEncryptionScheme{

    protected PredicateOnlyAESSymmetricBlockCipher() {}

    public int getInputBlockSize() {
        return this.forEncryption ? 0 : this.outBytes;
    }

    public int getOutputBlockSize() {
        return this.forEncryption ? this.outBytes : 1;
    }

}
