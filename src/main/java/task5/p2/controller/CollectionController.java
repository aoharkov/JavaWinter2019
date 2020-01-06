package task5.p2.controller;

import task5.p2.model.CollectionGenerator;
import task5.p2.view.CollectionView;

import java.util.List;
import java.util.Set;

public class CollectionController implements Runnable {

    @Override
    public void run() {
        int startOfRange = -5;
        int endOfRange = 10;
        int size = 10;
        List<Integer> list = CollectionGenerator.generateListFromRange(startOfRange, endOfRange, size);
        CollectionView.displayCollection(list, "list", startOfRange, endOfRange, size);
        Set<Integer> set = CollectionGenerator.generateSet(startOfRange, endOfRange, size);
        CollectionView.displayCollection(set, "set", startOfRange, endOfRange, size);
    }
}
