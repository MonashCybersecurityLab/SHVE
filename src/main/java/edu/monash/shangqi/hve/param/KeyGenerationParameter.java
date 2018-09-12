package edu.monash.shangqi.hve.param;

/**
 * The parameter for key generator. It keeps the length
 * of key (depends on security parameter and the type of the key).
 * We use AES-128, so the length is 128 bits if it is the msk.
 *
 * @author Shangqi
 */
public class KeyGenerationParameter {

    public int keyLength;

    public KeyGenerationParameter(int keyLength) {
        this.keyLength = keyLength;
    }
}
