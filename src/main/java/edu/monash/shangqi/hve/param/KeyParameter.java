package edu.monash.shangqi.hve.param;

/**
 * Key parameter abstraction for encryption scheme,
 * if masterKey is true, the corresponding instance is a master key
 * of the encryption scheme.
 *
 * @author Shangqi
 */
public class KeyParameter implements CipherParameter {

    private boolean masterKey;

    KeyParameter(boolean masterKey) {
        this.masterKey = masterKey;
    }

    public boolean isMaster() {
        return masterKey;
    }
}
