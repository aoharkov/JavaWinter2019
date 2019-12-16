package task3.p1;

import task3.p1.controller.ToyController;
import task3.p1.model.domain.Doll;
import task3.p1.model.domain.Puzzle;
import task3.p1.model.domain.Toy;
import task3.p1.model.domain.ToyVehicle;

public class Main {
    public static void main(String[] args) {
        ToyController toyController = new ToyController();
        System.out.println(new Toy());
        System.out.println(new Doll());
        System.out.println(new ToyVehicle());
        System.out.println(new ToyVehicle());
        System.out.println(new Toy());
        System.out.println(new Puzzle());
    }
}
