package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEParameter;

public final class SHVEMasterSecretKeyGenerator implements SecretKeyGenerator {

    private SHVEMasterSecretKeyGenerationParameter keyParameter;

    public SHVEMasterSecretKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.keyParameter = (SHVEMasterSecretKeyGenerationParameter) parameter;
    }

    public KeyParameter generateKey() {
        SHVEParameter parameter = this.keyParameter.getParameter();
        byte[] MSK = this.keyParameter.getRandom();

        return new SHVEMasterSecretKeyParameter(parameter, MSK);
    }
}
