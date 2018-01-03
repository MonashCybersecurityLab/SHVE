package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;
import edu.monash.shangqi.hve.util.AESUtil;
import edu.monash.shangqi.hve.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;

public final class SHVESecretKeyGenerator implements SecretKeyGenerator {

    private SHVESecretKeyGenerationParameter parameter;

    public SHVESecretKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.parameter = (SHVESecretKeyGenerationParameter) parameter;
        int[] pattern = this.parameter.getPattern();
        if (pattern == null) {
            throw new IllegalArgumentException("pattern cannot be null.");
        } else {
            long n = this.parameter.getMasterSecretKey().getParameter().getSize();
            if (pattern.length != n) {
                throw new IllegalArgumentException("pattern length not valid.");
            }
        }
    }

    public KeyParameter generateKey() {
        SHVEMasterSecretKeyParameter masterSecretKey = this.parameter.getMasterSecretKey();
        long size = masterSecretKey.getParameter().getSize();
        int[] B = new int[(int)size];
        byte[] D = new byte[16];

        for(int i = 0; i < size; ++i) {

            if (this.parameter.isStarAt(i)) {
                B[i] = 1;
            } else {
                byte[] d = AESUtil.encode(String.valueOf(this.parameter.getPatternAt(i))
                                .concat(String.valueOf(i)).getBytes(), masterSecretKey.getMSK());

                for(int j = 0; j < d.length; j++) {
                    D[j] ^= d[j];
                }
            }
        }

        return new SHVESecretKeyParameter(masterSecretKey.getParameter(), D, B);
    }
}
