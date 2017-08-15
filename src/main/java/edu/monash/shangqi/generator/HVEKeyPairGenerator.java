package edu.monash.shangqi.generator;

import edu.monash.shangqi.param.HVEKeyGenerationParameter;
import edu.monash.shangqi.param.HVEParameter;
import edu.monash.shangqi.param.impl.HVEMasterSecretKeyParameter;
import edu.monash.shangqi.param.impl.HVEPublicKeyParameter;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

import java.util.ArrayList;
import java.util.List;

public class HVEKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    private HVEKeyGenerationParameter param;

    public HVEKeyPairGenerator() {
    }

    public void init(KeyGenerationParameters param) {
        this.param = (HVEKeyGenerationParameter)param;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        HVEParameter parameters = this.param.getParameters();
        parameters.preProcess();
        Pairing pairing = PairingFactory.getPairing(parameters.getParameters());
        Element g = parameters.getG();
        ElementPow powG = parameters.getElementPowG();
        int n = parameters.getN();
        Element y = pairing.getZr().newElement().setToRandom();
        Element Y = pairing.pairing(g, g).powZn(y);

        List<List<Element>> T = new ArrayList<>(n);
        List<List<Element>> t = new ArrayList<>(n);
        List<List<Element>> V = new ArrayList<>(n);
        List<List<Element>> v = new ArrayList<>(n);

        for(int i = 0; i < n; ++i) {
            int howMany = parameters.getAttributeNumAt(i);
            List<Element> T_i = new ArrayList<>();
            List<Element> t_i = new ArrayList<>();
            List<Element> V_i = new ArrayList<>();
            List<Element> v_i = new ArrayList<>();


            for(int j = 0; j < howMany; ++j) {
                Element t_j = pairing.getZr().newElement().setToRandom();
                T_i.add(powG.powZn(t_j).getImmutable());
                t_i.add(t_j.getImmutable());
                Element v_j = pairing.getZr().newElement().setToRandom();
                V_i.add(powG.powZn(v_j).getImmutable());
                v_i.add(v_j.getImmutable());
            }

            T.add(T_i);
            t.add(t_i);
            V.add(V_i);
            v.add(v_i);
        }
        return new AsymmetricCipherKeyPair(new HVEPublicKeyParameter(parameters, Y.getImmutable(), T, V)
                , new HVEMasterSecretKeyParameter(parameters, y.getImmutable(), t, v));
    }
}
