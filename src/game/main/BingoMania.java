package game.main;

import game.core.BingoGame;
import game.core.Player;
import game.util.LoadGen;

import java.util.*;

public class BingoMania {

    /**
     * Main method to execute the Bingo game application
     * @param args - Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoadGen.runDot();
        System.out.println("\n");

        String[] asciiArt = {
            "   ▀█████████▄   ▄█  ███▄▄▄▄      ▄██████▄   ▄██████▄    ",
            "     ███    ███ ███  ███▀▀▀██▄   ███    ███ ███    ███   ",
            "     ███    ███ ███▌ ███   ███   ███    █▀  ███    ███   ",
            "    ▄███▄▄▄██▀  ███▌ ███   ███  ▄███        ███    ███   ",
            "   ▀▀███▀▀▀██▄  ███▌ ███   ███ ▀▀███ ████▄  ███    ███   ",
            "     ███    ██▄ ███  ███   ███   ███    ███ ███    ███   ",
            "     ███    ███ ███  ███   ███   ███    ███ ███    ███   ",
            "   ▄█████████▀  █▀    ▀█   █▀    ████████▀   ▀██████▀    ",
            "                                                         ",
            "   ▄▄▄▄███▄▄▄▄      ▄████████ ███▄▄▄▄    ▄█     ▄████████",
            " ▄██▀▀▀███▀▀▀██▄   ███    ███ ███▀▀▀██▄ ███    ███    ███",
            " ███   ███   ███   ███    ███ ███   ███ ███▌   ███    ███",
            " ███   ███   ███   ███    ███ ███   ███ ███▌   ███    ███",
            " ███   ███   ███ ▀███████████ ███   ███ ███▌ ▀███████████",
            " ███   ███   ███   ███    ███ ███   ███ ███    ███    ███",
            " ███   ███   ███   ███    ███ ███   ███ ███    ███    ███",
            "  ▀█   ███   █▀    ███    █▀   ▀█   █▀  █▀     ███    █▀ "
        };

        int columnWidth = 80;
        for (String line : asciiArt) {
            int padding = (columnWidth - line.length()) / 2;
            String centeredLine = " ".repeat(Math.max(0, padding)) + line;
            System.out.println(centeredLine);
        }

        System.out.print("\n\n\n\tEnter the number of players (up to 10):  ");
        int playerCount = scanner.nextInt();
        scanner.nextLine();

        if (playerCount > 10) {
            System.out.println("\t\tMaximum number of players is 10. Setting to 10.");
            playerCount = 10;
        }

        BingoGame game = new BingoGame(playerCount);

        for (int i = 0; i < playerCount; i++) {
            System.out.print("\n\n\tEnter the name of player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            game.addPlayer(name);
            System.out.println();
            LoadGen.run();
        }

        System.out.print("\n\n\tStarting the game...");
        LoadGen.runDot();
        game.printPlayerCards();

        while (true) {
            LoadGen.run();
            System.out.print("\n\tPress Enter to draw a number");
            scanner.nextLine();

            game.startRound();
            Player winner = game.checkWinner();

            LoadGen.run();
            System.out.println("\n");
       
               
            if (winner != null) {
                LoadGen.runFast();
                System.out.println("\t╔╗   ╦  ╔╗╔  ╔═╗  ╔═╗  ┬");
                LoadGen.runFast();
                System.out.println("\t╠╩╗  ║  ║║║  ║ ╦  ║ ║  │");
                LoadGen.runFast();
                System.out.println("\t╚═╝  ╩  ╝╚╝  ╚═╝  ╚═╝  o");
                System.out.print("\t");
                System.out.println("\n\t" + winner.getName() + " wins!");
                winner.printCard();
                break;
            }

            System.out.println("\n\tNo Bingo yet! Keep playing.");
        }

        scanner.close();
    }
}
