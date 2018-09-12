package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.Arrays;

/**
 * The parameter for SHVE Encryption algorithm,
 * it combines the msk and index vector.
 *
 * @author Shangqi
 */
public class SHVEEncryptionParameter extends SHVEKeyParameter {

    // msk
    private SHVEMasterSecretKeyParameter masterSecretKey;

    // index vector
    private int[] attributes;

    public SHVEEncryptionParameter(SHVEMasterSecretKeyParameter masterSecretKey, int[] attributes) {
        super(true, masterSecretKey.getParameter());
        this.masterSecretKey = masterSecretKey;
        this.attributes = Arrays.copyOf(attributes, attributes.length);
    }

    public SHVEMasterSecretKeyParameter getMasterSecretKey() {
        return this.masterSecretKey;
    }

    public int getAttributeAt(int index) {
        return this.attributes[index];
    }

    public int getLength() {
        return this.attributes.length;
    }
}
