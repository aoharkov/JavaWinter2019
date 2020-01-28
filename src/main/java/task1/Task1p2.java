package task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1p2 {
    private static final int MAX_AMOUNT_OF_KNOWN_PERFECT_NUMBERS_AS_OF_2019 = 51;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the int");
        int n = scanner.nextInt();
        System.out.print("All perfect numbers before " + n + ": ");
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
        int[] storeOfPerfectNumbersBeforeN = new int[MAX_AMOUNT_OF_KNOWN_PERFECT_NUMBERS_AS_OF_2019];
        int lenght = 0;
        for (int i = 2; i <= n; i++) {
            if (isPerfect(i)) {
                storeOfPerfectNumbersBeforeN[lenght] = i;
                lenght++;
            }
        }
        return Arrays.copyOf(storeOfPerfectNumbersBeforeN, lenght);
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
        return sum == num;
    }
}
