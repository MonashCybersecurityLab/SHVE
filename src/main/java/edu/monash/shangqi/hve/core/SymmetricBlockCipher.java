package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;

import java.util.List;

public interface SymmetricBlockCipher {

    void init(boolean forEncryption, CipherParameter parameter);

    int getInputBlockSize();

    int getOutputBlockSize();

    List<byte[]> processBlock(List<byte[]> in, int inOff, int inLen);
}
