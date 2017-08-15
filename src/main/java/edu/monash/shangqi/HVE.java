package edu.monash.shangqi;

import edu.monash.shangqi.generator.HVEKeyPairGenerator;
import edu.monash.shangqi.generator.HVEParameterGenerator;
import edu.monash.shangqi.param.HVEKeyGenerationParameter;
import edu.monash.shangqi.param.HVEParameter;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;

import java.security.SecureRandom;

public class HVE {

    public HVE(){}

    public static AsymmetricCipherKeyPair setup(int n) {
        HVEKeyPairGenerator generator = new HVEKeyPairGenerator();
        generator.init(new HVEKeyGenerationParameter(new SecureRandom(), genBinaryParam(n)));
        return generator.generateKeyPair();
    }

    private static HVEParameter genBinaryParam(int n) {
        HVEParameterGenerator generator = new HVEParameterGenerator();
        generator.init(n, PairingFactory.getPairingParameters("params/curves/a.properties"));

        return generator.generateParameters();
    }


    public static void main(String[] args) {
        HVE.setup(28755175);
    }
}
