package practice.com.bank.service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PasswordEncoder {
    private static final int LENGTH_OF_SALT = 16;
    private static final int ITERATION_COUNT = 65536;
    private static final int KEY_LENGTH = 128;
    private static final String DEFAULT_VALUE_FOR_HASH = "********";
    private static final String PBKDF2_ALGORITHM_NAME = "PBKDF2WithHmacSHA1";
    private SecretKeyFactory hashFactory;

    public PasswordEncoder() {
        try {
            hashFactory = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[LENGTH_OF_SALT];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
        byte[] hash = DEFAULT_VALUE_FOR_HASH.getBytes();
        try {
            hash = hashFactory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return String.valueOf(hash);
    }
}
