package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

import java.util.List;

/**
 * The abstraction for symmetric block cipher, it operates
 * on the fixed size block of bits.
 *
 * @author Shangqi
 */
public interface SymmetricBlockCipher {

    /**
     * Initialise the encryption scheme.
     *
     * @param forEncryption indicate whether it is initialise for enc or dec
     * @param parameter the key
     */
    void init(boolean forEncryption, CipherParameter parameter);

    int getInputBlockSize();

    int getOutputBlockSize();

    // Apply function on block
    List<byte[]> processBlock(List<byte[]> in, int inOff, int inLen);
}
