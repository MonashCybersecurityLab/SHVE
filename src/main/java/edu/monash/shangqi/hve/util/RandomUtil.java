package edu.monash.shangqi.hve.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Generate pseudo random element.
 *
 * @author Shangqi
 * @version 0.1
 */
public final class RandomUtil {

    private static SecureRandom secureRandom;

    static {
        secureRandom = new SecureRandom();
    }

    /**
     * Generate a random HEX string with
     * specific length.
     *
     * @param numBits the length of random string(in a bit form)
     * @return a string in the HEX form
     */
    public static String getRandom(int numBits) {
        return new BigInteger(numBits, secureRandom).toString(16).toUpperCase();
    }
}
