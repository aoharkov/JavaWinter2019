package com.bank.utility;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CollectionUtilityTest {
    @Test
    public void nullSafeListInitializeShouldReturnEmptyListIfInputIsNull() {
        final List<Object> actual = CollectionUtility.nullSafeListInitialize(null);
        assertTrue(actual.isEmpty());
    }
}