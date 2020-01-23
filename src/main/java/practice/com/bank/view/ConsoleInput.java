package practice.com.bank.view;

import java.util.Scanner;

public class ConsoleInput {
    private Scanner scanner = new Scanner(System.in);
    public String nextLine() {
        return scanner.nextLine();
    }
    public int nextInt() {
        return scanner.nextInt();
    }
}
