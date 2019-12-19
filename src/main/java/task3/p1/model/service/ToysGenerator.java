package task3.p1.model.service;

import task3.p1.model.domain.PlasticToyType;
import task3.p1.model.domain.plastictoys.*;

public class ToysGenerator {
    public static PlasticToy[] generateArrayOfPlasticToys(int length, PlasticToyType type) {
        PlasticToy[] arrayOfPlasticToys = null;
        switch (type) {
            case DOLL:
                arrayOfPlasticToys = new Doll[length];
                for (int i = 0; i < length; i++) {
                    arrayOfPlasticToys[i] = new Doll();
                }
                break;
            case PUZZLE:
                arrayOfPlasticToys = new Puzzle[length];
                for (int i = 0; i < length; i++) {
                    arrayOfPlasticToys[i] = new Puzzle();
                }
                break;
            case TOYCAR:
                arrayOfPlasticToys = new ToyCar[length];
                for (int i = 0; i < length; i++) {
                    arrayOfPlasticToys[i] = new ToyCar();
                }
                break;
            case TOYBOAT:
                arrayOfPlasticToys = new ToyBoat[length];
                for (int i = 0; i < length; i++) {
                    arrayOfPlasticToys[i] = new ToyBoat();
                }
                break;
            default:
                System.out.println("Unknown type of toy");
        }
        return arrayOfPlasticToys;
    }
}
