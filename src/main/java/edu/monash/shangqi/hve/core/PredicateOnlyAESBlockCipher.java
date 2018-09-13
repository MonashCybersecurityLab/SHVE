package edu.monash.shangqi.hve.core;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Instance of predicate only engine which is
 * based on AES-128.
 *
 * @author Shangqi
 */
public abstract class PredicateOnlyAESBlockCipher
        extends AESBlockCipher
        implements PredicateOnlyEncryptionScheme {

    protected PredicateOnlyAESBlockCipher() {
        // set the input/output bytes to 0 for predicate only engine
        this.inBytes = 0;
        this.outBytes = 0;
    }

    @Override
    public int getInputBlockSize() {
        return this.forEncryption ? 0 : this.outBytes;
    }

    @Override
    public int getOutputBlockSize() {
        return this.forEncryption ? this.outBytes : 1;
    }

    /**
     * The predicate only engine inputs empty message (only one possible message "True")
     */
    public List<byte[]> process() {
        return this.processBlock(new ArrayList<>(), 0, 0);
    }

    public boolean evaluate(List<byte[]> in, int inOff, int len) {
        return new BigInteger(this.processBlock(in, 0, in.size()).get(0)).intValue() == 1;
    }

    public boolean evaluate(List<byte[]> in) {
        return new BigInteger(this.processBlock(in, 0, in.size()).get(0)).intValue() == 1;
    }

}
