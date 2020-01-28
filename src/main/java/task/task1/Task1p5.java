package task.task1;

import java.util.Scanner;

public class Task1p5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the int");
        int n = scanner.nextInt();
        int[][] matrix = generateMatrix(n);
        printMatrix(matrix);
        System.out.println();
        printMatrix(rotateMatrix(matrix));
    }

    private static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            for (int i = layer; i < n - layer - 1; i++) {
                int x = matrix[layer][i];
                matrix[layer][i] = matrix[layer][n - layer - 1];
                matrix[layer][n - layer - 1] = matrix[n - layer - 1][n - i - 1];
                matrix[n - layer - 1][n - i - 1] = matrix[n - i - 1][layer];
                matrix[n - i - 1][layer] = x;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int[] line : matrix) {
            System.out.print(line[0]);
            for (int j = 1; j < n; j++) {
                System.out.print(" " + line[j]);
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) ((Math.random() - 0.5) * 180 + 10);
                //filled with two digits random numbers within range of -100 to 100
            }
        }
        return matrix;
    }
}
