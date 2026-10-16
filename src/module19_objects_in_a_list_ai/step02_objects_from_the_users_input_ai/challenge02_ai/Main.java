// AI-Generated
package module19_objects_in_a_list_ai.step02_objects_from_the_users_input_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Racers sign up for a race by name, and each one gets the next start number: the first racer gets 1, the second 2, and so on. {@code Racer.java} is ready. Read names until an empty line, create a {@code Racer} for each name with its start number, and add it to the list {@code racers}. Then print every racer. For the input {@code Ines}, {@code Tom}, {@code Mia} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * #1 Ines
     * #2 Tom
     * #3 Mia
     * }</pre>
     * Hints
     * 1. Before a racer is added, the list holds all the racers before it. So the next number is {@code racers.size() + 1}. (A counter variable works too.)
     * 2. {@code racers.add(new Racer(name, racers.size() + 1));} inside the reading loop, and a for-each loop after it to print.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Racer> racers = new ArrayList<>();

    }
}
