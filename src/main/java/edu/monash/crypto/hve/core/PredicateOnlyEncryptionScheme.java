package edu.monash.crypto.hve.core;

import java.util.List;

/**
 * The abstraction of the predicate only engine upon symmetric
 * block cipher.
 *
 * @author Shangqi
 */
public interface PredicateOnlyEncryptionScheme extends SymmetricBlockCipher {
    List<byte[]> process();

    // evaluate the the predicate function on block cipher
    boolean evaluate(List<byte[]> in, int inOff, int len);

    boolean evaluate(List<byte[]> in);
}