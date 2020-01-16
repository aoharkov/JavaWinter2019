package practice.com.bank.utility;

import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
import static practice.com.bank.utility.CollectionUtility.nullSafeListInitialize;

public class CollectionUtilityTest {
    @Test
    public void nullSafeListInitializeShouldReturnEmptyListIfInputIsNull() {
        final List<Object> actual = nullSafeListInitialize(null);
        assertTrue(actual.isEmpty());
    }

}