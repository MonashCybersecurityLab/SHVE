package edu.monash.shangqi.hve.param;

import java.security.SecureRandom;

public class SHVEMasterSecretKeyGenerationParameter {
    SHVEParameter params;

    public SHVEMasterSecretKeyGenerationParameter(SHVEParameter params) {
        this.params = params;
    }

    public SHVEParameter getParameters() {
        return this.params;
    }
}
