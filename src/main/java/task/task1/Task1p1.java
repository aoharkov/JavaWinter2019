package task.task1;

import java.util.Scanner;

public class Task1p1 {
    private static final int INT_LENGTH_IN_BITS = 32;

    public static void main(String[] args) {
        System.out.println("Please, enter the int");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printNecessaryRepresentations(n);
    }

    private static void printNecessaryRepresentations(int num) {
        printRepresentation(getRepresentation(num, 2));
        printRepresentation(getRepresentation(num, 8));
        printRepresentation(getRepresentation(num, 16));
    }

    private static void printRepresentation(char[] representation) {
        for (char ch :
                representation) {
            System.out.print(ch);
        }
        System.out.println();
    }

    private static char[] getRepresentation(int num, int base) {
        char[] invertedRepresentation = new char[INT_LENGTH_IN_BITS];
        int length = 0;
        while (num > 0) {
            invertedRepresentation[length] = getCharacter(num % base);
            num /= base;
            length++;
        }
        char[] representation = new char[length];
        for (int i = 0; i < length; i++) {
            representation[i] = invertedRepresentation[length - 1 - i];
        }
        return representation;
    }

    private static char getCharacter(int remainder) {
        if (remainder < 10) {
            return (char) ('0' + remainder);
        }
        return (char) ('A' + remainder - 10);
    }
}
