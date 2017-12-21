package edu.monash.shangqi.hve.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * This is an integrated AES package, it contains
 * not only encrypt/decrypt function, but also the functions
 * that can manipulate the string/byte array. All functions
 * are static here, so it can be easily used without
 * create any class instance.
 * </br>
 * version 0.2: Compare with Cong's version, I fix some warnings in
 * old version, and add essential comments for it.
 *
 * @author Cong, Shangqi
 * @version 0.2
 */
public final class AESUtil {

    /**
     * Encrypt a byte array by using AES.
     *
     * @param content the plain text
     * @param password secret key of AES
     * @return encrypted {@param content}
     */
    public static byte[] encrypt(byte[] content, byte[] password){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password);
            keyGenerator.init(128, random);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Decrypt a cipher text by using AES decryption.
     *
     * @param content the cipher text
     * @param password secret key of AES
     * @return decrypted {@param content}
     */
    public static byte[] decrypt(byte[] content, byte[] password) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password);
            keyGenerator.init(128, random);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}