package edu.monash.shangqi.generator;

import edu.monash.shangqi.param.HVEKeyGenerationParameters;
import edu.monash.shangqi.param.HVEParameters;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.ElementPow;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class HVEKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    private HVEKeyGenerationParameters param;

    public HVEKeyPairGenerator() {
    }

    public void init(KeyGenerationParameters param) {
        this.param = (HVEKeyGenerationParameters)param;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        HVEParameters parameters = this.param.getParameters();
        parameters.preProcess();
        Pairing pairing = PairingFactory.getPairing(parameters.getParameters());
        Element g = parameters.getG();
        ElementPow powG = parameters.getElementPowG();

        return null;
    }
}
