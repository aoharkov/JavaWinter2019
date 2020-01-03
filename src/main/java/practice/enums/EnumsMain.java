package practice.enums;

import java.util.Scanner;

public class EnumsMain {
    public static void main(String[] args) {
        for (DaysOfWeek day :
                DaysOfWeek.values()) {
            if (day.isFlag()) {
                System.out.println(day);
            }
        }
        System.out.println("----------------------");
        System.out.print("Enter day of week -->");
        Scanner sc = new Scanner(System.in);
        System.out.println("Next day is " + DaysOfWeek.valueOf(sc.next().toUpperCase()).nextDay());
    }
}
