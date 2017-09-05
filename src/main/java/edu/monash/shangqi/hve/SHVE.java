package edu.monash.shangqi.hve;

import edu.monash.shangqi.hve.core.impl.SHVEPredicateEngine;
import edu.monash.shangqi.hve.generator.impl.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVEParameterGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVESecretKeyGenerator;
import edu.monash.shangqi.hve.param.*;
import edu.monash.shangqi.hve.param.impl.*;

public class SHVE {

    public SHVE() {}

    /**
     * Setup the system with the size
     * of message.
     *
     * @param size size of message
     */
    public static KeyParameter setup(int size) {
        SHVEMasterSecretKeyGenerator generator = new SHVEMasterSecretKeyGenerator();
        generator.init(new SHVEMasterSecretKeyGenerationParameter(genBinaryParam(size)));

        return generator.generateKey();
    }

    private static SHVEParameter genBinaryParam(int size) {
        SHVEParameterGenerator generator = new SHVEParameterGenerator();
        generator.init(size);

        return generator.generateParameters();
    }

    public static KeyParameter keyGen(KeyParameter masterSecretKey, int... pattern) {
        SHVESecretKeyGenerator generator = new SHVESecretKeyGenerator();
        generator.init(new SHVESecretKeyGenerationParameter((SHVEMasterSecretKeyParameter) masterSecretKey, pattern));

        return generator.generateKey();
    }

    public static byte[] enc(KeyParameter masterSecretKey, int... attributes) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(true, new SHVEEncryptionParameter((SHVEMasterSecretKeyParameter) masterSecretKey, attributes));
        //return engine.process();
        return null;
    }

    public static void main(String[] args) {
        int n = 5;
        KeyParameter MSK = setup(n);

        int[][] vectors = {{1,1,-1,0,1},{1,1,0,0,1}};

        SHVESecretKeyParameter sk = (SHVESecretKeyParameter) keyGen(MSK, vectors[0]);
    }
}
