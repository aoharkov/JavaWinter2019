package task3.p1;

import task3.p1.controller.ToyController;
import task3.p1.model.domain.Toy;

public class Main {
    public static void main(String[] args) {
        ToyController toyController = new ToyController();
        System.out.println(new Toy());
        System.out.println(new Toy());
        System.out.println(new Toy());
    }
}
