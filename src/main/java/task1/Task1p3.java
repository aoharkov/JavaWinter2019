package task1;

import java.util.Scanner;

public class Task1p3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the int");
        int n = scanner.nextInt();
        printPyramid(getPyramid(n));
    }

    private static void printPyramid(int[][] pyramid) {
        for (int i = 0; i < pyramid.length; i++) {
            printBlank(pyramid.length - 1 - i);
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j]);
            }
            printBlank(pyramid.length - 1 - i);
            System.out.println();
        }
    }

    private static int[][] getPyramid(int n) {
        int[][] pyramid = new int[n][];
        for (int i = 0; i < n; i++) {
            pyramid[i] = getLayer(i);
        }
        return pyramid;
    }

    private static int[] getLayer(int lvl) {
        int[] layer = new int[lvl * 2 + 1];
        for (int i = 0; i < lvl; i++) {
            layer[i] = 1 + i;
            layer[layer.length - 1 - i] = 1 + i;
        }
        layer[lvl] = 1 + lvl;
        return layer;
    }

    private static void printBlank(int k) {
        for (int i = 0; i < k; i++) {
            System.out.print(" ");
        }
    }
}
