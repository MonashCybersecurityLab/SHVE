package edu.monash.shangqi.hve.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * URL operation package.
 * </br>
 * version 0.2: Add some function to tackle with
 * the encode/decode of byte array.
 * </br>
 * version 0.3: Support Base64 coding.
 *
 * @author Shangqi
 * @version 0.3
 */
public final class CodecUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * Encode to get an URL form string.
     *
     * @param source string in Java form
     * @return string in URL form
     */
    public static String encodeURL(String source) {
        String target;
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("Unable to encode URL", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * Decode to get a Java form string.
     *
     * @param source string in URL form
     * @return string in Java form
     */
    public static String decodeURL(String source) {
        String target;
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (Exception e) {
            LOGGER.error("Unable to decode URL", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * Encode a byte array to a hexadecimal string
     *
     * @since 0.2
     * @param source a byte array
     * @return a string represents the value of {@param source}
     */
    public static String encodeHexString(byte[] source) {
        StringBuilder hex = new StringBuilder();
        for(byte b : source) {
            hex.append(String.format("%02X", b));
        }
        return hex.toString();
    }

    /**
     * Encode a byte array in Base64 coding scheme.
     *
     * @param source a byte array
     * @return a string in Base64 coding
     */
    public static String encodeBase64(byte[] source) {
        return Base64.getEncoder().encodeToString(source);
    }

    /**
     * Decode a Base64 string to byte array.
     *
     * @param source a string in Base64 coding
     * @return a byte array
     */
    public static byte[] decodeBase64(String source) {
        return Base64.getDecoder().decode(source);
    }
}
