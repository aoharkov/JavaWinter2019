package task3.p1.model.service;

import task3.p1.model.domain.PlasticToyType;
import task3.p1.model.domain.plastictoys.*;

import java.util.Arrays;
import java.util.Comparator;

public class ToyService {
    private PlasticToy[] arrayOfPlasticToys;
    public void generateArrayOfType(int length, PlasticToyType type) {
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
    }

    public String showArrayOfToys(){
        return FromArrayOfToysToStringParser.parse(arrayOfPlasticToys);
    }

    private static class FromArrayOfToysToStringParser {
        static String parse (PlasticToy[] array) {
            StringBuilder str = new StringBuilder();
            for (PlasticToy plasticToy :
                    array) {
                str.append(plasticToy);
                str.append('\n');
            }
            return str.toString();
        }
    }



    public String sortByPrice(){
        PlasticToy[] result = Arrays.copyOf(arrayOfPlasticToys, arrayOfPlasticToys.length);
        Arrays.sort(result, new Comparator<PlasticToy>() {
            @Override
            public int compare(PlasticToy o1, PlasticToy o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        return FromArrayOfToysToStringParser.parse(result);
    }

    public int calculateTotalPrice(){
        int sum = 0;
        for (PlasticToy plasticToy :
                arrayOfPlasticToys) {
            sum += plasticToy.getPrice();
        }
        return sum;
    }
}
