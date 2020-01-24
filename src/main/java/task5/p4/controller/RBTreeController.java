package task5.p4.controller;

import task5.p4.model.RBTree;
import task5.p4.model.TraverseType;
import task5.p4.view.RBTreeView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RBTreeController implements Runnable {
    private RBTree<Integer> tree;
    private RBTreeView view;

    public RBTreeController() {
        this.tree = new RBTree<>();
        this.view = new RBTreeView();
    }

    @Override
    public void run() {
        //demo(new Integer[]{11, 2, 14, 1, 7, 15, 5, 8, 4});
        demo(generateRandomIntArray(10));
    }

    private void demo(Integer[] array) {
        view.viewMessage("Random array:");
        view.viewArray(array);
        demoTraverse(array);
        view.viewMessage("Case of sorted array:");
        Arrays.sort(array);
        demoTraverse(array);
    }

    private void demoTraverse(Integer[] array) {
        tree.generateFromArray(array);
        view.viewMessage("Inorder traversed tree:");
        view.viewArray(tree.traverse(TraverseType.INORDER).toArray());
        view.viewMessage("Preorder traversed tree:");
        view.viewArray(tree.traverse(TraverseType.PREORDER).toArray());
        view.viewMessage("Postorder traversed tree:");
        view.viewArray(tree.traverse(TraverseType.POSTORDER).toArray());
        view.viewMessage("Traversed tree by level:");
        view.viewArray(tree.traverse(TraverseType.BYLEVEL).toArray());
    }

    private Integer[] generateRandomIntArray(int size) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Integer x = (int) (Math.random() * (100 + size));
            while (result.contains(x)) {
                x = (int) (Math.random() * (100 + size));
            }
            result.add(x);
        }
        return result.toArray(new Integer[size]);
    }
}
