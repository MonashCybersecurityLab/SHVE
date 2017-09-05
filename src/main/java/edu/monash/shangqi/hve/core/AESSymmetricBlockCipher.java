package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

public abstract class AESSymmetricBlockCipher implements SymmetricBlockCipher {

    protected boolean forEncryption;
    protected CipherParameter key;
    protected int inBytes = 0;
    protected int outBytes = 0;

    protected AESSymmetricBlockCipher() {}

    public int getInputBlockSize() {
        return this.forEncryption ? this.inBytes : this.outBytes;
    }

    public int getOutputBlockSize() {
        return this.forEncryption ? this.outBytes : this.inBytes;
    }

    public void init(boolean forEncryption, CipherParameter parameter) {
        this.forEncryption = forEncryption;
        this.key = parameter;
        this.initialize();
    }

    public byte[] processBlock(byte[] in, int inOff, int inLen) {
        if (this.key == null) {
            throw new IllegalStateException("Engine not initialized");
        } else {
            int maxLength = this.getInputBlockSize();
            if (inLen < maxLength) {
                throw new RuntimeException("Input too small for the cipher.");
            } else {
                return this.process(in, inOff, inLen);
            }
        }
    }

    public abstract void initialize();

    public abstract byte[] process(byte[] in, int inOff, int inLen);
}
