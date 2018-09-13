package edu.monash.crypto.hve.param.impl;

import edu.monash.crypto.hve.param.KeyGenerationParameter;

/**
 * The generator parameter of msk. It includes the length of index vector.
 * As we use AES-128, the key length is fixed. (i.e. 128 bits/16 bytes).
 *
 * @author Shangqi
 */
public class SHVEMasterSecretKeyGenerationParameter extends KeyGenerationParameter {
    private SHVEParameter parameter;

    public SHVEMasterSecretKeyGenerationParameter(SHVEParameter parameter) {
        super(16);
        this.parameter = parameter;
    }

    public SHVEParameter getParameter() {
        return this.parameter;
    }
}
