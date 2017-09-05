package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.KeyGenerationParameter;

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
