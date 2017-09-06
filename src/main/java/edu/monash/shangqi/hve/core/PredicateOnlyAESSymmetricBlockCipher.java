package edu.monash.shangqi.hve.core;

public abstract class PredicateOnlyAESSymmetricBlockCipher
        extends AESSymmetricBlockCipher
        implements PredicateOnlyEncryptionScheme{

    protected PredicateOnlyAESSymmetricBlockCipher() {}

    @Override
    public int getInputBlockSize() {
        return this.forEncryption ? 0 : this.outBytes;
    }

    @Override
    public int getOutputBlockSize() {
        return this.forEncryption ? this.outBytes : 1;
    }

    public byte[] process() {
        return this.processBlock(new byte[0], 0, 0);
    }

    public boolean evaluate(byte[] in, int inOff, int len) {
        return this.processBlock(in, 0, len)[0] == 1;
    }

    public boolean evaluate(byte[] in) {
        return this.processBlock(in, 0, in.length)[0] == 1;
    }

}
