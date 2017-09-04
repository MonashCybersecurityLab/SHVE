package edu.monash.shangqi.hve.param;

import edu.monash.shangqi.hve.core.SHVE;
import edu.monash.shangqi.hve.util.RandomUtil;

public final class SHVEMasterSecretKeyParameter {
    SHVEParameter parameter;
    String MSK;

    public SHVEMasterSecretKeyParameter(SHVEMasterSecretKeyGenerationParameter parameter, String MSK) {
        this.parameter = parameter.getParameters();
        this.MSK = MSK;
    }

    public SHVEParameter getParameter() {
        return parameter;
    }

    public String getMSK() {
        return MSK;
    }
}
