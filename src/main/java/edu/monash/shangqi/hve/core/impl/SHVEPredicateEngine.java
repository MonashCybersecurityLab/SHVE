package edu.monash.shangqi.hve.core.impl;

import edu.monash.shangqi.hve.core.PredicateOnlyAESSymmetricBlockCipher;
import edu.monash.shangqi.hve.param.SHVEKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEEncryptionParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;
import edu.monash.shangqi.hve.util.AESUtil;

import javax.crypto.BadPaddingException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class SHVEPredicateEngine
        extends PredicateOnlyAESSymmetricBlockCipher {

    private long size;

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

        if (this.key instanceof SHVESecretKeyParameter) {   // evaluation
            ArrayList<byte[]> C;
            SHVESecretKeyParameter secretKey = (SHVESecretKeyParameter)this.key;
            C = new ArrayList<>();

            DataInputStream inputStream;
            inputStream = new DataInputStream(new ByteArrayInputStream(in));

            for(int i = 0; i < this.size; ++i) {
                try {
                    byte[] res = new byte[16];
                    inputStream.read(res);
                    C.add(res);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            byte[] z = secretKey.getD0();
            for(int i = 0; i < secretKey.getParameter().getSize(); ++i) {
                if (!secretKey.isStar(i)) {
                    byte[] c = C.get(i);
                    // use xor to predicate
                    for (int j = 0; j < z.length; j++) {
                        z[j] ^= c[j];
                    }
                }
            }
            try {
                AESUtil.decrypt(secretKey.getD1(), z);
                return new byte[]{(byte)(1)};
            } catch (RuntimeException e) {
                return new byte[]{(byte)(0)};
            }


        } else if (inLen <= this.inBytes && inLen >= this.inBytes) {    // encryption
            SHVEEncryptionParameter encParams = (SHVEEncryptionParameter)this.key;
            SHVEMasterSecretKeyParameter pk = encParams.getMasterSecretKey();

            ByteArrayOutputStream outputStream;
            try {
                outputStream = new ByteArrayOutputStream(this.getOutputBlockSize());
                for (int i = 0; i < this.size; ++i) {
                    int j = encParams.getAttributeAt(i);
                    outputStream.write(AESUtil.encode(String.valueOf(j)
                            .concat(String.valueOf(i)).getBytes(), pk.getMSK()));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return outputStream.toByteArray();
        }
        return null;
    }
}
