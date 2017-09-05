package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.Arrays;

public final class SHVEMasterSecretKeyParameter extends SHVEKeyParameter {

    private byte[] MSK;

    public SHVEMasterSecretKeyParameter(SHVEParameter parameter, byte[] MSK) {
        super(true, parameter);
        this.MSK = Arrays.copyOf(MSK, MSK.length);
    }

    public byte[] getMSK() {
        return this.MSK;
    }
}
