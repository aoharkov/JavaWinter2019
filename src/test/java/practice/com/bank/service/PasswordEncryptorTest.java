package practice.com.bank.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordEncryptorTest {

    @Test
    public void encript() {
        assertEquals("[B@1810399e", PasswordEncryptor.encript("qwerty"));
    }
}