package edu.monash.crypto.hve.generator;

import edu.monash.crypto.hve.param.KeyGenerationParameter;
import edu.monash.crypto.hve.param.KeyParameter;

/**
 * The abstraction of secret key generator, it uses the generator
 * parameter to initialise the generator {@link #init(KeyGenerationParameter)},
 * and generate the key from the parameter {@link #generateKey()}.
 *
 * @author Shangqi
 */
public interface SecretKeyGenerator {

    void init(KeyGenerationParameter parameter);

    KeyParameter generateKey();
}
