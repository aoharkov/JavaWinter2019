package practice.lesson3.sorting;

import org.junit.Test;
import practice.lesson3.exception.A;

import java.sql.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void sort() {
        int[] array = new int[]{4, 2, 3, 5, 1, 4, 3};
        int[] array2 = Arrays.copyOf(array, array.length);
        Sorting sorting = new BubbleSort();
        sorting.sort(array);
        Arrays.sort(array2);
        assertArrayEquals(array2, array);
    }
}