package edu.monash.shangqi.hve.core.impl;

import edu.monash.shangqi.hve.core.SymmetricBlockCipher;
import edu.monash.shangqi.hve.param.SHVEKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEEncryptionParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;

public class SHVEPredicateEngine extends SymmetricBlockCipher {

    private int size;

    public SHVEPredicateEngine() {
    }

    public void initialize() {
        if (this.forEncryption) {
            if (!(this.key instanceof SHVEEncryptionParameter)) {
                throw new IllegalArgumentException("SHVEEncryptionParameter are required for encryption.");
            }
        } else if(!(this.key instanceof SHVESecretKeyParameter)) {
            throw new IllegalArgumentException("SHVESecretKeyParameter are required for decryption.");
        }

        SHVEKeyParameter hveKey = (SHVEKeyParameter) this.key;
        this.size = hveKey.getParameter().getSize();
    }
}
