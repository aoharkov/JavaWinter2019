package task3.p1.model.service;

import task3.p1.model.domain.PlasticToyType;
import task3.p1.model.domain.TabletopGameType;
import task3.p1.model.domain.plastictoys.*;
import task3.p1.model.domain.tabletopgames.BoardGame;
import task3.p1.model.domain.tabletopgames.CardGame;
import task3.p1.model.domain.tabletopgames.TabletopGame;

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

    public static TabletopGame[] generateArrayOfTabletopGames(int length, TabletopGameType type) {
        TabletopGame[] arrayOfTabletopGames = null;
        switch (type) {
            case BOARDGAME:
                arrayOfTabletopGames = new BoardGame[length];
                for (int i = 0; i < length; i++) {
                    arrayOfTabletopGames[i] = new BoardGame(generateHypeName(i) + " Board Game", 30 + i, i % 4 + 2);
                }
                break;
            case CARDGAME:
                arrayOfTabletopGames = new CardGame[length];
                for (int i = 0; i < length; i++) {
                    arrayOfTabletopGames[i] = new CardGame(generateHypeName(i) + " Card Game", 10 + i, i % 4 + 2);
                }
                break;
            default:
                System.out.println("Unknown type of toy");
        }
        return arrayOfTabletopGames;
    }

    private static String generateHypeName(int hash) {
        String[] realNames = {"Monopoly", "Scrabble", "Risk", "Catan"};
        String[] randomWords = {"Space", "Digital", "Underground"};
        StringBuilder name = new StringBuilder();
        name.append(realNames[hash%realNames.length]);
        hash /= realNames.length;
        if (hash > 0) {
            name.append(" ");
            name.append(randomWords[hash%randomWords.length]);
            hash /= randomWords.length;
        }
        if (hash > 0) {
            name.append(" ");
            name.append(hash + 1);
        }
        return name.toString();
    }
}
