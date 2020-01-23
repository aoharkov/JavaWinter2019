package practice.lesson3.sortcomparable;

import java.util.Comparator;

public interface SortComparable<T extends Comparable> {

    void sort(T[] items);

    void sort(T[] items, Comparator<T> comparator);
}
