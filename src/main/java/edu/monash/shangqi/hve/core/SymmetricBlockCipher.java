package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

import java.util.List;

/**
 * The abstraction for symmetric block cipher, it uses
 * a symmetric key to initialise {@link #init(boolean, CipherParameter)}
 * and operates on the fixed size block of bits {@link #processBlock(List, int, int)}.
 *
 * @author Shangqi
 */
public interface SymmetricBlockCipher {

    void init(boolean forEncryption, CipherParameter parameter);

    int getInputBlockSize();

    int getOutputBlockSize();

    // Apply function on block
    List<byte[]> processBlock(List<byte[]> in, int inOff, int inLen);
}
