package edu.monash.shangqi.hve.core;

public interface PredicateOnlyEncryptionScheme extends SymmetricBlockCipher {
    byte[] process();

    boolean evaluate(byte[] in, int inOff, int len);

    boolean evaluate(byte[] in);
}