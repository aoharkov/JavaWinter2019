package task.task5.p2.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionGenerator {
    public static List<Integer> generateListFromRange(int startOfRange, int endOfRange, int size) {
        List<Integer> result = new ArrayList<>();
        int lenghtOfRange = endOfRange - startOfRange;
        for (int i = 0; i < size; i++) {
            result.add((int) (Math.random() * lenghtOfRange) + startOfRange);
        }
        return result;
    }

    public static Set<Integer> generateSet(int startOfRange, int endOfRange, int size) {
        Set<Integer> result = new HashSet<>();
        int lenghtOfRange = endOfRange - startOfRange;
        for (int i = 0; i < size; i++) {
            Integer newRandomInteger = generateIntegerInRange(startOfRange, lenghtOfRange);
            while (result.contains(newRandomInteger)) {
                newRandomInteger = generateIntegerInRange(startOfRange, lenghtOfRange);
            }
            result.add(newRandomInteger);
        }
        return result;
    }

    private static Integer generateIntegerInRange(int startOfRange, int lenghtOfRange) {
        return (int) (Math.random() * lenghtOfRange) + startOfRange;
    }
}
