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
                    arrayOfTabletopGames[i] = new BoardGame(generateNameForBoardGame(i), 30 + i, i % 4 + 2);
                }
                break;
            case CARDGAME:
                arrayOfTabletopGames = new CardGame[length];
                for (int i = 0; i < length; i++) {
                    arrayOfTabletopGames[i] = new CardGame(generateNameForCardGame(i), 10 + i, i % 4 + 2);
                }
                break;
            default:
                System.out.println("Unknown type of toy");
        }
        return arrayOfTabletopGames;
    }

    private static String generateHypeName(int hash, String[] realNames, String[] randomWords) {
        StringBuilder name = new StringBuilder();
        if (hash < realNames.length) {
            name.append(realNames[hash % realNames.length]);
            return name.toString();
        }
        name.append(randomWords[hash % randomWords.length]);
        hash /= randomWords.length;
        name.append(" ");
        name.append(realNames[hash % realNames.length]);
        hash /= realNames.length;
        if (hash > 0) {
            name.append(" ");
            name.append(hash + 1);
        }
        return name.toString();
    }

    private static String generateNameForBoardGame(int hash) {
        String[] realNames = {"Scrabble", "Monopoly", "Risk", "Catan"};
        String[] randomWords = {"Space", "Digital", "Underground"};
        return generateHypeName(hash, realNames, randomWords);
    }

    private static String generateNameForCardGame(int hash) {
        String[] realNames = {"Poker", "Blackjack"};
        String[] randomWords = {"Space", "Digital", "Underground"};
        return generateHypeName(hash, realNames, randomWords);
    }
}
