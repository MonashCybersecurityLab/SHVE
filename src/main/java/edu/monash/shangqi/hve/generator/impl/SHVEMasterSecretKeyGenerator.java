package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEParameter;
import edu.monash.shangqi.hve.util.RandomUtil;

/**
 * Master secret key (msk) generator uses the msk generation parameter
 * to generate a msk.
 *
 * @author Shangqi
 */
public final class SHVEMasterSecretKeyGenerator implements SecretKeyGenerator {

    private SHVEMasterSecretKeyGenerationParameter keyParameter;

    public SHVEMasterSecretKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.keyParameter = (SHVEMasterSecretKeyGenerationParameter) parameter;
    }

    // generate a key with the given security parameter
    public KeyParameter generateKey() {
        SHVEParameter parameter = this.keyParameter.getParameter();
        byte[] MSK = RandomUtil.getRandom(keyParameter.keyLength - 1);

        return new SHVEMasterSecretKeyParameter(parameter, MSK);
    }
}
