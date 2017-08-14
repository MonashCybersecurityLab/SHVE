package edu.monash.shangqi.param;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;
import it.unisa.dia.gas.jpbc.ElementPowPreProcessing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.CipherParameters;

import java.util.Arrays;

public class HVEParameter implements CipherParameters {

    private PairingParameters parameters;
    private Element g;
    private ElementPowPreProcessing powG;
    private int n;
    private int[] attributeLengths;
    private int attributesLengthInBytes;
    private int[] attributeLengthsInBytes;
    private int[] attributeNums;
    private boolean preProcessed = false;

    public HVEParameter(PairingParameters parameters, Element g, int[] attributeLengths) {
        this.parameters = parameters;
        this.g = g.getImmutable();
        this.n = attributeLengths.length;
        this.attributeLengths = Arrays.copyOf(attributeLengths, attributeLengths.length);
        this.attributesLengthInBytes = 0;
        this.attributeLengthsInBytes = new int[this.n];
        this.attributeNums = new int[this.n];

        for(int i = 0; i < attributeLengths.length; ++i) {
            int attributeLength = attributeLengths[i];
            this.attributeLengthsInBytes[i] = attributeLength / 8 + 1;  // transform bit to byte
            this.attributesLengthInBytes += this.attributeLengthsInBytes[i];
            this.attributeNums[i] = (int)Math.pow(2.0D, (double)attributeLength);
        }
    }

    public PairingParameters getParameters() {
        return this.parameters;
    }

    public Element getG() {
        return this.g;
    }

    public ElementPow getElementPowG() {
        return (this.preProcessed ? this.powG : this.g);
    }

    public int getN() {
        return this.n;
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

    public void preProcess() {
        if (!this.preProcessed) {
            this.powG = this.g.getElementPowPreProcessing();
            this.preProcessed = true;
        }
    }

    public boolean isPreProcessed() {
        return this.preProcessed;
    }
}
