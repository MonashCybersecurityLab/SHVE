package edu.monash.shangqi.hve.generator;

import edu.monash.shangqi.hve.param.KeyGenerationParameter;
import edu.monash.shangqi.hve.param.KeyParameter;

public interface SecretKeyGenerator {

    void init(KeyGenerationParameter parameter);

    KeyParameter generateKey();
}
