package edu.monash.shangqi.hve.generator;

import edu.monash.shangqi.hve.param.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.SHVESecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.SHVESecretKeyParameter;
import edu.monash.shangqi.hve.util.AESUtil;

public class SHVESecretKeyGenerator {
    protected SHVESecretKeyGenerationParameter param;
    protected int[] pattern;

    public SHVESecretKeyGenerator() {
    }

    public void init(SHVESecretKeyGenerationParameter param) {
        this.param = param;
        this.pattern = this.param.getPattern();
        if (this.pattern == null) {
            throw new IllegalArgumentException("pattern cannot be null.");
        } else {
            int n = this.param.getMasterSecretKey().getParameter().getSize();
            if (this.pattern.length != n) {
                throw new IllegalArgumentException("pattern length not valid.");
            }
        }
    }

    public SHVESecretKeyParameter generateKey() {
        SHVEMasterSecretKeyParameter masterSecretKey = this.param.getMasterSecretKey();
        int size = masterSecretKey.getParameter().getSize();
        String[] D = new String[size];
        int[] B = new int[size];

        for(int i = 0; i < size; ++i) {
            D[i] = AESUtil.encrypt(String.valueOf(this.param.getPatternAt(i)).concat(String.valueOf(i))
                    , masterSecretKey.getMSK());
            if (this.param.isStarAt(i)) {
                B[i] = 1;
            }
        }

        return new SHVESecretKeyParameter(D, B);
    }
}
