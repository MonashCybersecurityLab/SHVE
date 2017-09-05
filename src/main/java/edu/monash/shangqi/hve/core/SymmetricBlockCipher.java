package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

public interface SymmetricBlockCipher {

    void init(boolean forEncryption, CipherParameter parameter);

    int getInputBlockSize();

    int getOutputBlockSize();

    byte[] processBlock(byte[] in, int inOff, int inLen);
}
