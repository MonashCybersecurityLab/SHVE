package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVESecretKeyParameter;
import edu.monash.shangqi.hve.util.AESUtil;

import java.util.ArrayList;

public final class SHVESecretKeyGenerator implements SecretKeyGenerator {

    private SHVESecretKeyGenerationParameter parameter;
    private int[] pattern;

    public SHVESecretKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.parameter = (SHVESecretKeyGenerationParameter) parameter;
        this.pattern = this.parameter.getPattern();
        if (this.pattern == null) {
            throw new IllegalArgumentException("pattern cannot be null.");
        } else {
            int n = this.parameter.getMasterSecretKey().getParameter().getSize();
            if (this.pattern.length != n) {
                throw new IllegalArgumentException("pattern length not valid.");
            }
        }
    }

    public KeyParameter generateKey() {
        SHVEMasterSecretKeyParameter masterSecretKey = this.parameter.getMasterSecretKey();
        int size = masterSecretKey.getParameter().getSize();
        ArrayList<byte[]> D = new ArrayList<>();
        int[] B = new int[size];

        for(int i = 0; i < size; ++i) {

            if (this.parameter.isStarAt(i)) {
                B[i] = 1;
                D.add(null);
            } else {
                D.add(AESUtil.encrypt(String.valueOf(this.parameter.getPatternAt(i))
                                .concat(String.valueOf(i)).getBytes()
                        , masterSecretKey.getMSK()));
            }
        }

        return new SHVESecretKeyParameter(masterSecretKey.getParameter(), D, B);
    }
}
