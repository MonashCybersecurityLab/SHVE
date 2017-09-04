package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.generator.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.SHVEParameterGenerator;
import edu.monash.shangqi.hve.generator.SHVESecretKeyGenerator;
import edu.monash.shangqi.hve.param.*;
import edu.monash.shangqi.hve.util.RandomUtil;

import java.security.SecureRandom;

public class SHVE {

    /**
     * Setup the system with the size
     * of message.
     *
     * @param size size of message
     */
    public static SHVEMasterSecretKeyParameter setup(int size) {
        SHVEMasterSecretKeyGenerator generator = new SHVEMasterSecretKeyGenerator();
        generator.init(new SHVEMasterSecretKeyGenerationParameter(genBinaryParam(size)));

        return generator.generateMSK();
    }

    private static SHVEParameter genBinaryParam(int size) {
        SHVEParameterGenerator generator = new SHVEParameterGenerator();
        generator.init(size);

        return generator.generateParameters();
    }

    public static SHVESecretKeyParameter keyGen(SHVEMasterSecretKeyParameter privateKey, int... pattern) {
        SHVESecretKeyGenerator generator = new SHVESecretKeyGenerator();
        generator.init(new SHVESecretKeyGenerationParameter(privateKey, pattern));

        return generator.generateKey();
    }

    public static byte[] enc(SHVEMasterSecretKeyParameter publicKey, int... attributes) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(true, new HVEIP08EncryptionParameters((HVEIP08PublicKeyParameters) publicKey, attributes));
        return engine.process();
    }

    public static void main(String[] args) {
        int n = 5;
        SHVEMasterSecretKeyParameter MSK = setup(n);

        int[][] vectors = {{1,1,-1,0,1},{1,1,0,0,1}};

        SHVESecretKeyParameter sk = keyGen(MSK, vectors[0]);
    }
}
