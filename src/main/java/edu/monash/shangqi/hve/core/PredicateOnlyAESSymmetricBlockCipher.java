package edu.monash.shangqi.hve.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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

    public List<byte[]> process() {
        return this.processBlock(new ArrayList<>(1), 0, 0);
    }

    public boolean evaluate(List<byte[]> in, int inOff, int len) {
        return new BigInteger(this.processBlock(in, 0, in.size()).get(0)).intValue() == 1;
    }

    public boolean evaluate(List<byte[]> in) {
        return new BigInteger(this.processBlock(in, 0, in.size()).get(0)).intValue() == 1;
    }

}
