package edu.monash.crypto.hve.param.impl;

import edu.monash.crypto.hve.param.SHVEKeyParameter;

import java.util.Arrays;

/**
 * The master secret key class, it keeps a 128-bit array
 * and is marked as master key.
 *
 * @author Shangqi
 */
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
