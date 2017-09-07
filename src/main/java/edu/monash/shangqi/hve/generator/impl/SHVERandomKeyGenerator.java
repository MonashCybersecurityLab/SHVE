package edu.monash.shangqi.hve.generator.impl;

import edu.monash.shangqi.hve.generator.SecretKeyGenerator;
import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVERandomKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVERandomKeyParameter;

public class SHVERandomKeyGenerator implements SecretKeyGenerator {

    private SHVERandomKeyGenerationParameter keyParameter;

    public SHVERandomKeyGenerator() {
    }

    public void init(KeyGenerationParameter parameter) {
        this.keyParameter = (SHVERandomKeyGenerationParameter) parameter;
    }

    public KeyParameter generateKey() {
        return new SHVERandomKeyParameter(this.keyParameter.getRandom());
    }

}
