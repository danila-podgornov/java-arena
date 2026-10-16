// AI-Generated
package module16_working_with_strings_ai.step08_putting_it_together_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Read lines in the form {@code name,city} until an empty line. Then read one more line, a city, and print the names of everyone from that city, in the order they were read. If nobody is from there, print {@code Nobody from } and the city. For the input {@code Aino,Oulu}, {@code Ben,Turku}, {@code Carla,Oulu}, an empty line and {@code Oulu} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Aino
     * Carla
     * }</pre>
     * Hints
     * 1. The first loop is like the ones in the last step: stop at an empty line, split, and add {@code parts[0]} to {@code names} and {@code parts[1]} to {@code cities}.
     * 2. Then read the city to look for, and loop over the indexes: when {@code cities.get(i).equals(wanted)}, print {@code names.get(i)}. Count the matches, so that at the end you know whether there were none.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();

    }
}
