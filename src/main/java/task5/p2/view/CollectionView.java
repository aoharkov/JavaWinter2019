package task5.p2.view;

import task5.p2.model.CollectionGenerator;

import java.util.*;

public class CollectionView {
    public static <T extends Comparable<T>> void displayCollection(Collection<T> collection, String name, int startOfRange, int endOfRange, int size) {
        System.out.println(String.format(
                "Generated %s in range from %d to %d of size %d:",
                name, startOfRange, endOfRange, size));
        System.out.println(collection);
        System.out.println(String.format("Same %s, but sorted:", name));
        System.out.println(asSortedList(collection));
    }
    private static <T extends Comparable<T>> List<T> asSortedList(Collection<T> collection) {
        List<T> list = new ArrayList<>(collection);
        Collections.sort(list);
        return list;
    }
}
