package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

import java.util.List;

/**
 * Instance of Symmetric block cipher, the corresponding block cipher scheme
 * is AES (has 128 bits key, and process on 128 bits block)
 *
 * @author Shangqi
 */
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

    public List<byte[]> processBlock(List<byte[]> in, int inOff, int inLen) {
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

    public abstract List<byte[]> process(List<byte[]> in, int inOff, int inLen);
}
