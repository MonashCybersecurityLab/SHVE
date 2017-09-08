package edu.monash.shangqi.hve.param.impl;

import edu.monash.shangqi.hve.param.SHVEKeyParameter;

import java.util.Arrays;

public class SHVEEncryptionParameter extends SHVEKeyParameter {

    private SHVEMasterSecretKeyParameter masterSecretKey;
    private int[] attributes;

    public SHVEEncryptionParameter(SHVEMasterSecretKeyParameter masterSecretKey, int[] attributes) {
        super(true, masterSecretKey.getParameter());
        this.masterSecretKey = masterSecretKey;
        this.attributes = Arrays.copyOf(attributes, attributes.length);
    }

    public SHVEMasterSecretKeyParameter getMasterSecretKey() {
        return this.masterSecretKey;
    }

    public int[] getAttributes() {
        return Arrays.copyOf(this.attributes, this.attributes.length);
    }

    public int getAttributeAt(int index) {
        return this.attributes[index];
    }

    public int getLength() {
        return this.attributes.length;
    }
}
