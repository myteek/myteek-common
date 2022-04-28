package com.myteek.common.crypto;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.regex.Pattern;

@Slf4j
public class BCryptPasswordEncoder {

    private static final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

    private static final String version = "$2y";

    private static final SecureRandom random = new SecureRandom();

    /**
     * encode password
     * @param rawPassword raw password
     * @return
     */
    public static String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("raw password cannot be null");
        }
        String salt = getSalt();
        return BCrypt.hashpw(rawPassword.toString(), salt);
    }

    private static String getSalt() {
        int strength = 10;
        return BCrypt.gensalt(version, strength, random);
    }

    /**
     * test password
     * @param rawPassword raw password
     * @param encodedPassword encoded password
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("raw password cannot be null");
        }
        if (encodedPassword == null || encodedPassword.length() == 0) {
            log.warn("Empty encoded password");
            return false;
        }
        if (!BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
            log.warn("Encoded password does not look like BCrypt");
            return false;
        }
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
    }

}
