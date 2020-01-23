package practice.lesson3.sortcomparable.impl;

import practice.lesson3.sortcomparable.SortComparable;

import java.util.Comparator;

public class InsertionSortComparable implements SortComparable {
    private Comparator<Comparable> comparator;

    public InsertionSortComparable() {
        comparator = Comparator.naturalOrder();
    }

    @Override
    public void sort(Comparable[] items) {
        for (int indexOfFirstUnsorted = 1; indexOfFirstUnsorted < items.length; indexOfFirstUnsorted++) {
            Comparable current = items[indexOfFirstUnsorted];
            int indexOfSortedBefore = indexOfFirstUnsorted - 1;
            while (indexOfSortedBefore >= 0 && comparator.compare(current, items[indexOfSortedBefore]) < 0) {
                items[indexOfSortedBefore + 1] = items[indexOfSortedBefore];
                indexOfSortedBefore--;
            }
            items[indexOfSortedBefore + 1] = current;
        }
    }

    @Override
    public void sort(Comparable[] items, Comparator comparator) {
        this.comparator = comparator;
        sort(items);
    }
}
