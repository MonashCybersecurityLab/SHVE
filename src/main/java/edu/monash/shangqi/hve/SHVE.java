package edu.monash.shangqi.hve;

import edu.monash.shangqi.hve.core.impl.SHVEPredicateEngine;
import edu.monash.shangqi.hve.generator.impl.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVEParameterGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVESecretKeyGenerator;
import edu.monash.shangqi.hve.param.*;
import edu.monash.shangqi.hve.param.impl.*;
import edu.monash.shangqi.hve.util.AESUtil;

import java.util.List;
import java.util.Random;

public class SHVE {

    public SHVE() {}

    // Generate the master secret key (MSK)
    public static KeyParameter setup(long size) {
        SHVEMasterSecretKeyGenerator generator = new SHVEMasterSecretKeyGenerator();
        generator.init(new SHVEMasterSecretKeyGenerationParameter(genBinaryParam(size)));

        return generator.generateKey();
    }

    // Set the length of predicate vector
    private static SHVEParameter genBinaryParam(long size) {
        SHVEParameterGenerator generator = new SHVEParameterGenerator();
        generator.init(size);

        return generator.generateParameters();
    }

    // Use MSK and a given pattern to generate query token (sk)
    public static KeyParameter keyGen(KeyParameter masterSecretKey, int... pattern) {
        SHVESecretKeyGenerator generator = new SHVESecretKeyGenerator();
        generator.init(new SHVESecretKeyGenerationParameter((SHVEMasterSecretKeyParameter) masterSecretKey, pattern));

        return generator.generateKey();
    }

    // Use MSK to encrypt an attribute vector and get HVE ciphertext (c)
    public static List<byte[]> enc(KeyParameter masterSecretKey, int... attributes) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(true, new SHVEEncryptionParameter((SHVEMasterSecretKeyParameter) masterSecretKey, attributes));
        return engine.process();
    }

    // Use sk to check whether the pattern is in c
    public static boolean evaluate(KeyParameter secretKey, List<byte[]> ct) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(false, secretKey);
        return engine.evaluate(ct);
    }

    // Test function, create an unmatched vector to test the correctness of SHVE
    private static int[][] createNonMatchingVectors(long size) {
        int[][] result = new int[2][(int)size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (i != 0  && i != 1 && random.nextBoolean()) {// it's a star
                result[0][i] = random.nextInt(2);
                result[1][i] = 1 - result[0][i];
            } else {
                result[0][i] = random.nextInt(2);
                result[1][i] = 1 - result[0][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 10000;
        long start, end;

        KeyParameter MSK = setup(n);

        // warm-up AES here, warm-up phase is used to load all static java classes into
        // memory, which can avoid extra classloader overhead
        AESUtil.encode("test".getBytes(), ((SHVEMasterSecretKeyParameter) MSK).getMSK());

        // This is used to test the case when pattern is matched with attributes
        //int[][] vectors = {{1,1,-1,0,1},{1,1,0,0,1}};
        int[][] vectors = createNonMatchingVectors(n);

        start = System.nanoTime();
        SHVESecretKeyParameter sk = (SHVESecretKeyParameter) keyGen(MSK, vectors[0]);
        end = System.nanoTime();
        System.out.println("KeyGen Time: " + (end - start));

        start = System.nanoTime();
        List<byte[]> c = enc(MSK, vectors[1]);
        end = System.nanoTime();
        System.out.println("Enc Time: " + (end - start));

        start = System.nanoTime();
        System.out.println("Query Result: " + evaluate(sk, c));
        end = System.nanoTime();
        System.out.println("Query Time: " + (end - start));

    }
}
