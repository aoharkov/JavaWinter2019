package task3.p1.model.service;

import task3.p1.model.domain.ToyItem;

import java.util.Arrays;
import java.util.Comparator;

public class Playroom<T extends ToyItem> {
    private T[] array;

    public Playroom(T[] array) {
        this.array = array;
    }

    public void sortByPrice() {
        Arrays.sort(array, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (T element :
                array) {
            sum += element.getPrice();
        }
        return sum;
    }

    public String parse () {
        StringBuilder str = new StringBuilder();
        for (T toy :
                array) {
            str.append(toy);
            str.append('\n');
        }
        return str.toString();
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
