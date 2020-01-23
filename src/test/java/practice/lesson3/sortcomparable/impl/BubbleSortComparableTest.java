package practice.lesson3.sortcomparable.impl;

import org.junit.Before;
import org.junit.Test;
import practice.lesson3.sortcomparable.SortComparable;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortComparableTest {
    private static Integer[] array;
    private static Integer[] sortedArray;

    @Before
    public void setupArrays() {
        array = new Integer[]{4, 2, 3, 5, 1, 4, 3};
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    @Test
    public void testSort() {
        SortComparable sortComparable = new BubbleSortComparable();
        sortComparable.sort(array);
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSortWithNaturalOrderComparator() {
        SortComparable sortComparable = new BubbleSortComparable();
        sortComparable.sort(array, Comparator.naturalOrder());
        assertArrayEquals(sortedArray, array);
    }

    @Test
    public void testSortWithReverseOrderComparator() {
        SortComparable sortComparable = new BubbleSortComparable();
        sortComparable.sort(array, Comparator.reverseOrder());
        Arrays.sort(sortedArray, Comparator.reverseOrder());
        assertArrayEquals(sortedArray, array);
    }
}