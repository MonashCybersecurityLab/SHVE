package edu.monash.shangqi.hve.param;

import edu.monash.shangqi.hve.param.impl.SHVEParameter;

public class SHVEKeyParameter extends KeyParameter {

    private SHVEParameter parameter;

    public SHVEKeyParameter(boolean isMaster, SHVEParameter parameter) {
        super(isMaster);
        this.parameter = parameter;
    }

    public SHVEParameter getParameter() {
        return this.parameter;
    }
}
