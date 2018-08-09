package edu.monash.shangqi.hve.core;

import java.util.List;

public interface PredicateOnlyEncryptionScheme extends SymmetricBlockCipher {
    List<byte[]> process();

    boolean evaluate(List<byte[]> in, int inOff, int len);

    boolean evaluate(List<byte[]> in);
}