package task3.p1.model.service;

import task3.p1.model.domain.*;

import java.util.Arrays;
import java.util.Comparator;

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

    public String showArrayOfToys(){
        return FromArrayOfToysToStringParser.parse(arrayOfToys);
    }

    private static class FromArrayOfToysToStringParser {
        static String parse (Toy[] array) {
            StringBuilder str = new StringBuilder();
            for (Toy toy :
                    array) {
                str.append(toy);
                str.append('\n');
            }
            return str.toString();
        }
    }



    public String sortByPrice(){
        Toy[] result = Arrays.copyOf(arrayOfToys, arrayOfToys.length);
        Arrays.sort(result, new Comparator<Toy>() {
            @Override
            public int compare(Toy o1, Toy o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        return FromArrayOfToysToStringParser.parse(result);
    }

    public int calculateTotalPrice(){
        int sum = 0;
        for (Toy toy :
                arrayOfToys) {
            sum += toy.getPrice();
        }
        return sum;
    }
}
