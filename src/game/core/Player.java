package game.core;

import game.util.*;

public class Player {
    private final String name;
    private final BingoCard card;

    /**
     * Constructor to initialize a Player with a name and a BingoCard
     * @param name - The name of the player
     */
    public Player(String name) {
        this.name = name;
        this.card = new BingoCard();
    }

    /**
     * Method to get the player's name
     * @return String - The name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the player's BingoCard
     * @return BingoCard - The player's BingoCard
     */
    public BingoCard getCard() {
        return card;
    }

    /**
     * Method to check if the player has a bingo
     * @return boolean - true if the player has a bingo
     */
    public boolean hasBingo() {
        return card.hasBingo();
    }

    /**
     * Method to mark a number on the player's BingoCard
     * @param number - The number to mark
     */
    public void markNumber(int number) {
        System.out.println("\t" + name + " is marking number: " + number);
        LoadGen.run();
        card.markNumber(number);
    }

    /**
     * Method to print the player's BingoCard
     */
    public void printCard() {
        LoadGen.run();
        System.out.println("\t" + name + "'s Bingo Card:");
        card.printCard();
    }
}
