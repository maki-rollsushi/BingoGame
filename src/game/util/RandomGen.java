package game.util;

public class RandomGen {
    private long seed;

    /**
     * Constructor to initialize the RandomGen with the current time as the seed
     */
    public RandomGen() {
        seed = System.currentTimeMillis();
    }

    /**
     * Method to generate a random integer within a specified range
     * @param min - The minimum value (inclusive)
     * @param max - The maximum value (inclusive)
     * @return int - A random integer between min and max
     */
    public int nextInt(int min, int max) {
        do {
            seed = (seed * 1103515245 + 12345) & 0x7FFFFFFF;
        } while (seed <= 0); // Ensure seed is always positive

        return (int) (seed % (max - min + 1)) + min;
    }
}
