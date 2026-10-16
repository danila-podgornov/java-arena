// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * A weather station's {@code Thermometer} used to keep a list of every reading. Someone rewrote it to keep only the number of readings and the lowest and highest one. The user interface didn't change, but the answers did: for the input shown, the program now says the lowest reading is 0, although no reading was 0. Fix {@code Thermometer}, keeping its public methods, so that the program answers as it did before. For the input shown, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Recorded 12
     * > Recorded 17
     * > Recorded 9
     * > Lowest: 9
     * > Highest: 17
     * > Station off
     * }</pre>
     * Hints
     * 1. The lowest reading starts at 0, and a reading of 9 isn't lower than 0, so it's never kept. The same goes for the highest when every reading is below 0. Whatever the start value, the first reading must become both the lowest and the highest.
     * 2. In {@code record}, before {@code this.count++}, the first reading is the one that comes when {@code this.count == 0}. Add that to both conditions: {@code if (this.count == 0 || degrees < this.lowest)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Thermometer thermometer = new Thermometer();
        UserInterface ui = new UserInterface(scanner, thermometer);
        ui.start();
    }
}
