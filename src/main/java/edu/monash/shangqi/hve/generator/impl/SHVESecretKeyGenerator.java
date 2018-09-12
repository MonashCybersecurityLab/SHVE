package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;
import edu.monash.shangqi.hve.util.AESUtil;
import edu.monash.shangqi.hve.util.RandomUtil;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> S = new HashSet<>();
        byte[] D0 = new byte[16];

        for(int i = 0; i < size; ++i) {
            if (!this.parameter.isStarAt(i)) {
                S.add(i);
                byte[] d = AESUtil.encode(String.valueOf(this.parameter.getPatternAt(i))
                                .concat(String.valueOf(i)).getBytes(), masterSecretKey.getMSK());

                for(int j = 0; j < d.length; j++) {
                    D0[j] ^= d[j];
                }
            }
        }

        byte[] K = RandomUtil.getRandom(D0.length * 8 - 1);

        byte[] D1 = AESUtil.encrypt(BigInteger.valueOf(0).toByteArray(), K);
        for(int i = 0; i < D0.length; i++) {
            D0[i] ^= K[i];
        }

        return new SHVESecretKeyParameter(masterSecretKey.getParameter(), D0, D1, S);
    }
}
