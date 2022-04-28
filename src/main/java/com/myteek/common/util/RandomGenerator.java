package com.myteek.common.util;

import java.security.SecureRandom;
import java.util.Random;

public class RandomGenerator {

    private static final char[] DEFAULT_CODEC = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
            .toCharArray();

    private static Random random = new SecureRandom();

    /**
     * random generator
     * @param length length
     * @return
     */
    public static String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("generate length need greater than 0");
        }
        byte[] verifierBytes = new byte[length];
        random.nextBytes(verifierBytes);
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = DEFAULT_CODEC[((verifierBytes[i] & 0xFF) % DEFAULT_CODEC.length)];
        }
        return String.valueOf(chars);
    }

    /**
     * generate int string
     * @param length
     * @return
     */
    public static String generateIntString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(Math.abs(random.nextInt(10000)) % 10);
        }
        return sb.toString();
    }

    public static int generateInt(int bound) {
        return random.nextInt(bound);
    }

}
