package edu.monash.shangqi.param;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;
import it.unisa.dia.gas.jpbc.ElementPowPreProcessing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import org.bouncycastle.crypto.CipherParameters;

public class HVEParameters implements CipherParameters {

    private PairingParameters parameters;
    private Element g;
    private ElementPowPreProcessing powG;
    private int n;
    private boolean preProcessed = false;

    public HVEParameters(PairingParameters parameters, Element g, int[] attributeLengths) {
        this.parameters = parameters;
        this.g = g.getImmutable();
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
