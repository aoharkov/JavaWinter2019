package practice.lesson3.sortcomparable.impl;

import practice.lesson3.sortcomparable.SortComparable;

import java.util.Comparator;

public class QuickSortComparable implements SortComparable {
    private Comparator<Comparable> comparator;

    public QuickSortComparable() {
        comparator = Comparator.naturalOrder();
    }

    @Override
    public void sort(Comparable[] items) {
        quickSort(items, 0, items.length - 1);
    }

    @Override
    public void sort(Comparable[] items, Comparator comparator) {
        this.comparator = comparator;
        quickSort(items, 0, items.length - 1);
    }

    private void quickSort(Comparable[] items, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(items, begin, end);
        quickSort(items, begin, pivot - 1);
        quickSort(items, pivot + 1, end);
    }

    private int partition(Comparable[] items, int begin, int end) {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (comparator.compare(items[i], items[end]) < 0) {
                Comparable temp = items[counter];
                items[counter] = items[i];
                items[i] = temp;
                counter++;
            }
        }
        Comparable temp = items[end];
        items[end] = items[counter];
        items[counter] = temp;
        return counter;
    }
}
