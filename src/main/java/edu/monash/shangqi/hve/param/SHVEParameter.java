package edu.monash.shangqi.hve.param;

import java.util.Arrays;

public final class SHVEParameter {

    private int size;
    private int[] attributeLengths;
    private int attributesLengthInBytes;
    private int[] attributeLengthsInBytes;
    private int[] attributeNums;

    public SHVEParameter(int[] attributeLengths) {
        this.size = attributeLengths.length;
        this.attributeLengths = Arrays.copyOf(attributeLengths, attributeLengths.length);
        this.attributesLengthInBytes = 0;
        this.attributeLengthsInBytes = new int[this.size];
        this.attributeNums = new int[this.size];

        for(int i = 0; i < attributeLengths.length; ++i) {
            int attributeLength = attributeLengths[i];
            this.attributeLengthsInBytes[i] = attributeLength / 8 + 1;
            this.attributesLengthInBytes += this.attributeLengthsInBytes[i];
            this.attributeNums[i] = (int)Math.pow(2.0D, (double)attributeLength);
        }
    }

    public int getSize() {
        return this.size;
    }

    public int[] getAttributeLengths() {
        return Arrays.copyOf(this.attributeLengths, this.attributeLengths.length);
    }

    public int getAttributesLengthInBytes() {
        return this.attributesLengthInBytes;
    }

    public int getAttributeLengthInBytesAt(int index) {
        return this.attributeLengthsInBytes[index];
    }

    public int getAttributeNumAt(int index) {
        return this.attributeNums[index];
    }
}
