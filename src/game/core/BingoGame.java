package game.core;

import game.util.*;

public class BingoGame {
    private final Player[] players;
    private final RandomGen random;
    private final int[] calledNumbers;
    private int calledCount;
    private int playerCount;

    /**
     * Constructor to initialize the BingoGame
     * @param maxPlayers - The maximum number of players allowed
     */
    public BingoGame(int maxPlayers) {
        players = new Player[maxPlayers];
        random = new RandomGen();
        calledNumbers = new int[75];
        calledCount = 0;
        playerCount = 0;
    }

    /**
     * Method to add a player to the game
     * @param name - The name of the player
     */
    public void addPlayer(String name) {
        if (playerCount < players.length) {
            players[playerCount++] = new Player(name);
        } else {
            LoadGen.run();
            System.out.println("\tMaximum number of players reached!");
        }
    }

    /**
     * Method to start a new round in the Bingo game
     */
    public void startRound() {
        int number;
        boolean isDuplicate;

        do {
            number = random.nextInt(1, 75);
            isDuplicate = false;

            for (int i = 0; i < calledCount; i++) {
                if (calledNumbers[i] == number) {
                    isDuplicate = true;
                    break;
                }
            }
        } while (isDuplicate);

        calledNumbers[calledCount++] = number;
        LoadGen.run();
        System.out.println("\tNumber called: " + number);

        for (int i = 0; i < playerCount; i++) {
            players[i].markNumber(number);
        }

        System.out.print("\n\tUpdated Bingo Cards");
        LoadGen.runDot();
        System.out.println("\n");
        printPlayerCards();
    }

    /**
     * Method to check for a winner among the players
     * @return Player - The winning player, or null if no winner
     */
    public Player checkWinner() {
        for (int i = 0; i < playerCount; i++) {
            if (players[i].hasBingo()) {
                return players[i];
            }
        }
        return null;
    }

    /**
     * Method to print all players' bingo cards
     */
    public void printPlayerCards() {
        for (int i = 0; i < playerCount; i++) {
            players[i].printCard();
        }
    }
}
