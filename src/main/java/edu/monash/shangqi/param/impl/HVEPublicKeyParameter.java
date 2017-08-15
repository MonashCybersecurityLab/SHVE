package edu.monash.shangqi.param.impl;

import edu.monash.shangqi.param.HVEKeyParameter;
import edu.monash.shangqi.param.HVEParameter;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;

import java.util.List;

public class HVEPublicKeyParameter extends HVEKeyParameter {

    private Element Y;
    private List<List<Element>> T;
    private List<List<Element>> V;
    private List<List<ElementPow>> preT;
    private List<List<ElementPow>> preV;
    private boolean preProcessed = false;

    public HVEPublicKeyParameter(HVEParameter parameters, Element Y, List<List<Element>> T, List<List<Element>> V) {
        super(false, parameters);
        this.Y = Y.getImmutable();
        this.T = T;
        this.V = V;
    }


}
