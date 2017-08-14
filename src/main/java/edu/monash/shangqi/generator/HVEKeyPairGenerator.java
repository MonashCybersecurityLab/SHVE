package edu.monash.shangqi.generator;

import edu.monash.shangqi.param.HVEKeyGenerationParameter;
import edu.monash.shangqi.param.HVEParameter;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

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

        return null;
    }
}
