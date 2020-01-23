package practice.lesson3.sortcomparable.impl;

import practice.lesson3.sortcomparable.SortComparable;

import java.util.Comparator;

public class BubbleSortComparable implements SortComparable {
    private Comparator<Comparable> comparator;

    public BubbleSortComparable() {
        comparator = Comparator.naturalOrder();
    }

    @Override
    public void sort(Comparable[] items) {
        boolean isSorted = false;
        Comparable temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < items.length - 1; i++) {
                if (comparator.compare(items[i], items[i + 1]) > 0) {
                    temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }

    @Override
    public void sort(Comparable[] items, Comparator comparator) {
        this.comparator = comparator;
        sort(items);
    }
}
