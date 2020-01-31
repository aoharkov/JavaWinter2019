package com.bank.service;

import com.bank.service.passwordencoder.PasswordEncoder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PasswordEncoderTest {

    @Test
    public void encrypt() {
        assertEquals("[B@aec6354", new PasswordEncoder().encode("qwerty"));
    }
}