package edu.monash.shangqi.hve;

import edu.monash.shangqi.hve.core.impl.SHVEPredicateEngine;
import edu.monash.shangqi.hve.generator.impl.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVEParameterGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVESecretKeyGenerator;
import edu.monash.shangqi.hve.param.*;
import edu.monash.shangqi.hve.param.impl.*;
import xerial.larray.LBitArray;
import xerial.larray.LByteArray;

import java.util.Random;

public class SHVE {

    public SHVE() {}

    /**
     * Setup the system with the size
     * of message.
     *
     * @param size size of message
     */
    public static KeyParameter setup(long size) {
        SHVEMasterSecretKeyGenerator generator = new SHVEMasterSecretKeyGenerator();
        generator.init(new SHVEMasterSecretKeyGenerationParameter(genBinaryParam(size)));

        return generator.generateKey();
    }

    private static SHVEParameter genBinaryParam(long size) {
        SHVEParameterGenerator generator = new SHVEParameterGenerator();
        generator.init(size);

        return generator.generateParameters();
    }

    public static KeyParameter keyGen(KeyParameter masterSecretKey, int... pattern) {
        SHVESecretKeyGenerator generator = new SHVESecretKeyGenerator();
        generator.init(new SHVESecretKeyGenerationParameter((SHVEMasterSecretKeyParameter) masterSecretKey, pattern));

        return generator.generateKey();
    }

    public static KeyParameter keyGen(KeyParameter masterSecretKey, LBitArray pattern) {
        return null;
    }


    public static byte[] enc(KeyParameter masterSecretKey, int... attributes) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(true, new SHVEEncryptionParameter((SHVEMasterSecretKeyParameter) masterSecretKey, attributes));
        return engine.process();
    }

    public static LByteArray enc(KeyParameter masterSecretKey, LBitArray... attributes) {
        return null;
    }

    public static boolean evaluate(KeyParameter secretKey, LByteArray ct) {
        return false;
    }

    public static boolean evaluate(KeyParameter secretKey, byte[] ct) {
        SHVEPredicateEngine engine = new SHVEPredicateEngine();
        engine.init(false, secretKey);
        return engine.evaluate(ct);
    }


    public static int[][] createNonMatchingVectors(long size) {
        int[][] result = new int[2][(int)size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            if (i != 0  && i != 1 && random.nextBoolean()) {// it's a star
                result[0][i] = -1;
                result[1][i] = random.nextInt(2);
            } else {
                result[0][i] = random.nextInt(2);
                result[1][i] = 1 - result[0][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 10000000;
        long start, end;

        KeyParameter MSK = setup(n);

        //int[][] vectors = {{1,1,-1,0,1},{1,1,0,0,1}};
        int[][] vectors = createNonMatchingVectors(n);

        start = System.nanoTime();
        SHVESecretKeyParameter sk = (SHVESecretKeyParameter) keyGen(MSK, vectors[0]);
        end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        byte[] res = enc(MSK, vectors[1]);
        end = System.nanoTime();
        System.out.println(end - start);

        start = System.nanoTime();
        System.out.println(evaluate(sk, res));
        end = System.nanoTime();
        System.out.println(end - start);
    }
}
