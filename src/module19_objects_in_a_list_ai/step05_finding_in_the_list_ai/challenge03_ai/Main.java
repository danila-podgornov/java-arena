// AI-Generated
package module19_objects_in_a_list_ai.step05_finding_in_the_list_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A program to end the module, with a class of your own. First write {@code Crop}: a crop has a name and a weight in kilos, kept in private object variables, and it prints like {@code potatoes (42 kg)}. Then write {@code main}. Read crops, a name and then the kilos, until the name is an empty line. Then print:
     * <ul>
     * <li>{@code 10 kg or more:} and then every crop of at least 10 kilos, one per line;
     * <li>{@code Total: } with the kilos of all the crops added up, and {@code  kg};
     * <li>{@code Best: } and the heaviest crop (the first of them, if two weigh the same).
     * </ul>
     * <p>If no crops were entered, print only {@code No crops.} For the input {@code potatoes}, {@code 42}, {@code beans}, {@code 3}, {@code carrots}, {@code 12} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 10 kg or more:
     * potatoes (42 kg)
     * carrots (12 kg)
     * Total: 57 kg
     * Best: potatoes (42 kg)
     * }</pre>
     * Hints
     * 1. {@code Crop} needs {@code private String name;} and {@code private int kilos;}, a constructor {@code public Crop(String name, int kilos)}, a getter {@code getKilos()} and {@code toString()}.
     * 2. In {@code main}: the reading loop, then {@code if (crops.isEmpty())} for {@code No crops.}. One for-each loop can do the rest: print the crops of 10 kilos or more, add up the kilos, and keep the heaviest crop so far, starting from {@code crops.get(0)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Crop> crops = new ArrayList<>();

    }
}
