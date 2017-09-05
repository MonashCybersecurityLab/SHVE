package edu.monash.shangqi.hve.param;

public class KeyParameter implements CipherParameter {

    private boolean masterKey;

    public KeyParameter(boolean masterKey) {
        this.masterKey = masterKey;
    }

    public boolean isMaster() {
        return masterKey;
    }
}
