package task.task3.p1.model.service;

import task.task3.p1.model.domain.ToyItem;

import java.util.Arrays;

public class Playroom<T extends ToyItem> {
    private T[] array;

    public Playroom(T[] array) {
        this.array = array;
    }

    public void sortByPrice() {
        Arrays.sort(array, (o1, o2) -> o1.getPrice() - o2.getPrice());
    }

    public int calculateTotalPrice() {
        int sum = 0;
        for (T element :
                array) {
            sum += element.getPrice();
        }
        return sum;
    }

    public T[] filterWithinRangeByPrices(int start, int end) {
        boolean[] flag = new boolean[array.length];
        int filteredLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPrice() >= start && array[i].getPrice() <= end) {
                flag[i] = true;
                filteredLength++;
            }
        }
        T[] filtered = Arrays.copyOf(array, filteredLength);
        int iFiltered = 0;
        int iArray = 0;
        while (iFiltered < filteredLength && iArray < array.length) {
            if (flag[iArray]) {
                filtered[iFiltered] = array[iArray];
                iFiltered++;
            }
            iArray++;
        }
        return filtered;
    }

    public String parse() {
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
