package task5.p1.view;

import java.util.Scanner;

public class LogEntryInput {
    private Scanner scanner = new Scanner(System.in);

    public String next() {
        return scanner.next();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
