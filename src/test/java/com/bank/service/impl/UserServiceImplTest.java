package com.bank.service.impl;

import com.bank.domain.User;
import com.bank.dao.UserDao;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.bank.service.PasswordEncoder;
import com.bank.service.validator.UserValidator;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    private static final String ENCODED_PASSWORD = "encoded_password";
    private static final String PASSWORD = "password";
    private static final String INCORRECT_PASSWORD = "incorrect password";
    private static final String INCORRECT_ENCODED_PASSWORD = "incorrect encoded_password";

    private static final String EMAIL = "email";
    private static final User USER = User.builder()
            .withPassword(ENCODED_PASSWORD)
            .withEmail(EMAIL)
            .build();

    @Mock
    private UserDao userRepository;
    @Mock
    private UserValidator userValidator;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @After
    public void resetMocks() {
        Mockito.reset(userValidator, userRepository);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        when(passwordEncoder.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(EMAIL, PASSWORD);

        assertTrue(isLogin);

        verify(passwordEncoder).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(EMAIL));
        verifyZeroInteractions(userValidator);

    }

    @Test
    public void userShouldNotLoginAsThereIsNoAnyUserWithSuchEmail() {
        when(passwordEncoder.encrypt(eq(PASSWORD))).thenReturn(ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        final boolean isLogin = userService.login(EMAIL, PASSWORD);

        assertFalse(isLogin);

        verify(passwordEncoder).encrypt(eq(PASSWORD));
        verify(userRepository).findByEmail(eq(EMAIL));
        verifyZeroInteractions(userValidator);

    }

    @Test
    public void userShouldNotLoginAsThereIsIncorrectPassword() {
        when(passwordEncoder.encrypt(eq(INCORRECT_PASSWORD))).thenReturn(INCORRECT_ENCODED_PASSWORD);
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(USER));

        final boolean isLogin = userService.login(EMAIL, INCORRECT_PASSWORD);

        assertFalse(isLogin);

        verify(passwordEncoder).encrypt(eq(INCORRECT_PASSWORD));
        verify(userRepository).findByEmail(eq(EMAIL));
        verifyZeroInteractions(userValidator);

    }

    @Test
    public void userShouldRegisterSuccessfully() {
        doNothing().when(userValidator).validate(any(User.class));
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        doNothing().when(userValidator).validate(any(User.class));

        final User actual = userService.register(USER);

        assertEquals(USER, actual);

        verify(userValidator).validate(any(User.class));
        verify(userRepository).findByEmail(eq(EMAIL));
        verifyZeroInteractions(userValidator);
    }
}