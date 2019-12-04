package task1;

import java.util.Scanner;

public class Task1p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printAllPerfectNumbersBeforeN(findAllPerfectNumbersBeforeN(n));
    }

    private static void printAllPerfectNumbersBeforeN(int[] allPerfectNumbersBeforeN) {
        if (allPerfectNumbersBeforeN.length > 0) {
            System.out.print(allPerfectNumbersBeforeN[0]);
            if (allPerfectNumbersBeforeN.length > 1) {
                for (int i = 1; i < allPerfectNumbersBeforeN.length; i++) {
                    System.out.print(" " + allPerfectNumbersBeforeN[i]);
                }
            }
        }
        System.out.println();
    }

    private static int[] findAllPerfectNumbersBeforeN(int n) {
        int[] store = new int[52];//As of 2019 there are 51 known perfect numbers
        int lenght = 0;
        for (int i = 2; i <= n; i++) {
            if (isPerfect(i)) {
                store[lenght] = i;
                lenght++;
            }
        }
        int[] allPerfectNumbersBeforeN = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            allPerfectNumbersBeforeN[i] = store[i];
        }
        return allPerfectNumbersBeforeN;
    }

    private static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (num / (i * 1.0) > Math.sqrt(num)) {
                    sum += num / i;
                }
            }
        }
        if (sum == num) {
            return true;
        }
        return false;
    }
}
