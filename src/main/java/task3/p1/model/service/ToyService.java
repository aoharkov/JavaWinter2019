package task3.p1.model.service;

import task3.p1.model.domain.*;

public class ToyService {
    private Toy[] arrayOfToys;
    public void generateArrayOfType(int length, ToyType type) {
        switch (type) {
            case TOY:
                arrayOfToys = new Toy[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new Toy();
                }
                break;
            case DOLL:
                arrayOfToys = new Doll[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new Doll();
                }
                break;
            case PUZZLE:
                arrayOfToys = new Puzzle[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new Puzzle();
                }
                break;
            case TOYCAR:
                arrayOfToys = new ToyCar[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new ToyCar();
                }
                break;
            case TOYBOAT:
                arrayOfToys = new ToyBoat[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new ToyBoat();
                }
                break;
            case TOYVEHICLE:
                arrayOfToys = new ToyVehicle[length];
                for (int i = 0; i < length; i++) {
                    arrayOfToys[i] = new ToyVehicle();
                }
                break;
            default:
                System.out.println("Unknown type of toy");
        }
    }

    public String sortByPrice(){
        return null;
    }

    public String calculateTotalPrice(){
        return null;
    }
}
