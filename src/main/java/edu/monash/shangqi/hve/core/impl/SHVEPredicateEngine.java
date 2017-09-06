package edu.monash.shangqi.hve.core.impl;

import edu.monash.shangqi.hve.core.PredicateOnlyAESSymmetricBlockCipher;
import edu.monash.shangqi.hve.param.SHVEKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEEncryptionParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;

public class SHVEPredicateEngine
        extends PredicateOnlyAESSymmetricBlockCipher {

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

    public byte[] process(byte[] in, int inOff, int inLen) {
        if (this.key instanceof SHVESecretKeyParameter) {   // decryption

        } else if (inLen <= this.inBytes && inLen >= this.inBytes) {    // encryption
            SHVEEncryptionParameter encParams = (SHVEEncryptionParameter)this.key;
            SHVEMasterSecretKeyParameter pk = encParams.getMasterSecretKey();
        }
        return null;
    }
}
