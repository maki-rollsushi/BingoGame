package game.util;

public class LoadGen {

    /**
     * Method to simulate a loading process with dots
     */
    public static void runDot() {
        int dots = 0;
        while (dots < 5) {
            System.out.print(".");
            System.out.flush();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dots++;
        }
        System.out.println();
    }

    /**
     * Method to simulate a short loading process
     */
    public static void run() {
        int dots = 0;
        while (dots < 2) {
            System.out.flush();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dots++;
        }
    }

    /**
     * Method to simulate a very fast loading process
     */
    public static void runFast() {
        int dots = 0;
        while (dots < 1) {
            System.out.flush();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dots++;
        }
    }
}
