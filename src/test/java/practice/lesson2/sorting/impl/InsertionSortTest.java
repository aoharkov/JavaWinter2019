package practice.lesson2.sorting.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import practice.lesson2.sorting.Sorting;
import practice.lesson2.sorting.impl.InsertionSort;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InsertionSortTest {
    private static int[] array;
    private static int[] sortedArray;

    @BeforeClass
    public static void setupArrays(){
        array = new int[]{4, 2, 3, 5, 1, 4, 3};
        sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
    }

    @Test
    public void sort() {
        Sorting sorting = new InsertionSort();
        sorting.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}