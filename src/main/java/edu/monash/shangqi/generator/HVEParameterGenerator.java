package edu.monash.shangqi.generator;

import edu.monash.shangqi.param.HVEParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.jpbc.PairingParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

import java.util.Arrays;

public class HVEParameterGenerator {

    private PairingParameters curveParams;
    private int[] attributeLengths;
    private Pairing pairing;

    public HVEParameterGenerator() {
    }

    public void init(PairingParameters curveParams, int... attributeLengths) {
        this.curveParams = curveParams;
        this.attributeLengths = Arrays.copyOf(attributeLengths, attributeLengths.length);
        this.pairing = PairingFactory.getPairing(curveParams);
    }

    public void init(int n, PairingParameters curveParams) {
        this.init(n, 1, curveParams);
    }

    public void init(int n, int numBitsPerAttribute, PairingParameters curveParams) {
        this.curveParams = curveParams;
        this.attributeLengths = new int[n];

        for(int i = 0; i < this.attributeLengths.length; ++i) {
            this.attributeLengths[i] = numBitsPerAttribute;
        }

        this.pairing = PairingFactory.getPairing(curveParams);
    }

    public HVEParameters generateParameters() {
        Element g = this.pairing.getGT().newElement().setToRandom();
        return new HVEParameters(this.curveParams, g.getImmutable(), this.attributeLengths);
    }

}
