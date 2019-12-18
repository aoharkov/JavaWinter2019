package task3.p1.model.service;

import task3.p1.model.domain.Toy;

import java.util.Arrays;
import java.util.Comparator;

public class Playroom<T extends Toy> {
    public T[] sortByPrice(T[] array) {
        T[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(result, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        return result;
    }

    public int calculateTotalPrice(T[] array) {
        int sum = 0;
        for (T element :
                array) {
            sum += element.getPrice();
        }
        return sum;
    }

}
