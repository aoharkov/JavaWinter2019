package task5.p4.view;

public class RBTreeView {
    public void viewMessage(String message) {
        System.out.println(message);
    }

    public <T> void viewArray(T[] array) {
        if (array == null) {
            return;
        }
        if (array.length > 0) {
            System.out.print(array[0]);
            for (int i = 1; i < array.length; i++) {
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }
}
