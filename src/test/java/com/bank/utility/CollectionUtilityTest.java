package com.bank.utility;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CollectionUtilityTest {
    @Test
    public void nullSafeListInitializeShouldReturnEmptyListIfInputIsNull() {
        final List<Object> actual = CollectionUtility.nullSafeListInitialize(null);
        assertTrue(actual.isEmpty());
    }

}