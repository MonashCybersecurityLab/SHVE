package edu.monash.shangqi.core;

import edu.monash.shangqi.generator.HVEKeyPairGenerator;
import edu.monash.shangqi.generator.HVEParameterGenerator;
import edu.monash.shangqi.param.HVEKeyGenerationParameters;
import edu.monash.shangqi.param.HVEParameters;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;

import java.security.SecureRandom;

public class HVE {

    public HVE(){}

    public static AsymmetricCipherKeyPair setup(int n) {
        HVEKeyPairGenerator generator = new HVEKeyPairGenerator();
        generator.init(new HVEKeyGenerationParameters(new SecureRandom(), genBinaryParam(n)));

        return generator.generateKeyPair();
    }

    private static HVEParameters genBinaryParam(int n) {
        HVEParameterGenerator generator = new HVEParameterGenerator();
        generator.init(n, PairingFactory.getPairingParameters("params/curves/a.properties"));

        return generator.generateParameters();
    }


}
