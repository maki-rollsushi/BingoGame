package game.core;

import game.util.*;

public class BingoCard {
    private final int[][] card;
    private final boolean[][] marked;
    private final RandomGen random;

    public BingoCard() {
        card = new int[5][5];
        marked = new boolean[5][5];
        random = new RandomGen();
        generateCard();
    }

    /**
     * Method to generate a bingo card
     */
    private void generateCard() {
        int min = 1, max = 15;
        int currNum;
        boolean isUnique;

        for (int col = 0; col < 5; col++) {
            currNum = 0;
            for (int row = 0; row < 5; row++) {
                if (col == 2 && row == 2) {
                    card[row][col] = 0;
                    marked[row][col] = true;
                    continue;
                }

                while (currNum < 5) {
                    int num = random.nextInt(min, max + 1);
                    isUnique = true;
                    for (int i = 0; i < row; i++) {
                        if (card[i][col] == num) {
                            isUnique = false;
                            break;
                        }
                    }

                    if (isUnique) {
                        card[row][col] = num;
                        currNum++;
                        break;
                    }
                }
            }
            min += 15;
            max += 15;
        }
    }

    /**
     * Method to print the bingo card
     */
    public void printCard() {
        System.out.println("\n\t----------------------------------------------");
        LoadGen.runFast();
        System.out.println("\t|   ╔╗   |    ╦   |  ╔╗╔   |  ╔═╗   |  ╔═╗   |");
        LoadGen.runFast();
        System.out.println("\t|   ╠╩╗  |    ║   |  ║║║   |  ║ ╦   |  ║ ║   |");
        LoadGen.runFast();
        System.out.println("\t|   ╚═╝  |    ╩   |  ╝╚╝   |  ╚═╝   |  ╚═╝   |");
        LoadGen.runFast();
        System.out.println("\t----------------------------------------------");
        LoadGen.runFast();
        System.out.print("\t");

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == 2 && col == 2) {
                    System.out.print("|  FREE  ");
                    LoadGen.runFast();
                } else if (marked[row][col]) {
                    System.out.print("|   X    ");
                    LoadGen.runFast();
                } else {
                    System.out.printf("|   %2d   ", card[row][col]);
                    LoadGen.runFast();
                }
            }
            System.out.print("|");
            System.out.println("\n\t----------------------------------------------");
            System.out.print("\t");
        }
        System.out.println();
    }

    /**
     * Method to mark a number on the bingo card
     * @param number - The number to mark
     */
    public void markNumber(int number) {
        boolean found = false;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (card[row][col] == number) {
                    marked[row][col] = true;
                    found = true;
                    System.out.println("\tMarked number " + number + " at position (" + (row + 1) + ", " + (col + 1) + ")\n");
                    LoadGen.runFast();
                }
            }
        }
        if (!found) {
            System.out.println("\tNumber " + number + " not found on the card.\n");
            LoadGen.runFast();
        }
    }

    /**
     * Method to check if the card has a bingo
     * @return boolean - true if bingo is achieved
     */
    public boolean hasBingo() {
        for (int i = 0; i < 5; i++) {
            if (isRowBingo(i) || isColumnBingo(i)) return true;
        }
        return isDiagonalBingo();
    }

    /**
     * Method to check if a row has bingo
     * @param row - The row index to check
     * @return boolean - true if the row has bingo
     */
    private boolean isRowBingo(int row) {
        for (int col = 0; col < 5; col++) {
            if (!marked[row][col]) return false;
        }
        return true;
    }

    /**
     * Method to check if a column has bingo
     * @param col - The column index to check
     * @return boolean - true if the column has bingo
     */
    private boolean isColumnBingo(int col) {
        for (int row = 0; row < 5; row++) {
            if (!marked[row][col]) return false;
        }
        return true;
    }

    /**
     * Method to check if any diagonal has bingo
     * @return boolean - true if any diagonal has bingo
     */
    private boolean isDiagonalBingo() {
        boolean leftToRight = true, rightToLeft = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) leftToRight = false;
            if (!marked[i][4 - i]) rightToLeft = false;
        }
        return leftToRight || rightToLeft;
    }
}
