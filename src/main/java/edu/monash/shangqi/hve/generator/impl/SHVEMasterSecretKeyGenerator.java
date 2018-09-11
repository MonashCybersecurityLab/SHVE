package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEParameter;
import edu.monash.shangqi.hve.util.RandomUtil;

public final class SHVEMasterSecretKeyGenerator implements SecretKeyGenerator {

    private SHVEMasterSecretKeyGenerationParameter keyParameter;

    public SHVEMasterSecretKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.keyParameter = (SHVEMasterSecretKeyGenerationParameter) parameter;
    }

    public KeyParameter generateKey() {
        SHVEParameter parameter = this.keyParameter.getParameter();
        byte[] MSK = RandomUtil.getRandom(keyParameter.keyLength - 1);

        return new SHVEMasterSecretKeyParameter(parameter, MSK);
    }
}
