package edu.monash.shangqi.param.impl;

import edu.monash.shangqi.param.HVEKeyParameter;
import edu.monash.shangqi.param.HVEParameter;
import it.unisa.dia.gas.jpbc.Element;

import java.util.List;

public class HVEMasterSecretKeyParameter extends HVEKeyParameter {

    private Element y;
    private List<List<Element>> t;
    private List<List<Element>> v;
    private List<List<Element>> preT;
    private List<List<Element>> preV;
    private boolean preProcessed = false;

    public HVEMasterSecretKeyParameter(HVEParameter parameters, Element y, List<List<Element>> t, List<List<Element>> v) {
        super(true, parameters);
        this.y = y.getImmutable();
        this.t = t;
        this.v = v;
    }
}
