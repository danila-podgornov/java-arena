// AI-Generated
package module19_objects_in_a_list_ai.step01_a_list_of_objects_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * {@code Main.java} makes a list of hikes and prints it, but {@code Hike} has no {@code toString} yet, so each line shows only the class name, an {@code @} and a code. Add a {@code toString} method to {@code Hike} that returns the name, a colon and a space, and then the length, followed by {@code  km}. The program then prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lake loop: 12 km
     * Ridge path: 7 km
     * Old mill: 4 km
     * }</pre>
     * Hints
     * 1. The method goes inside the class, after the constructor: {@code public String toString() { ... }}.
     * 2. It returns the text, it doesn't print it: {@code return this.name + ": " + this.km + " km";}
     */
    public static void main(String[] args) {
        ArrayList<Hike> hikes = new ArrayList<>();
        hikes.add(new Hike("Lake loop", 12));
        hikes.add(new Hike("Ridge path", 7));
        hikes.add(new Hike("Old mill", 4));

        for (Hike hike : hikes) {
            System.out.println(hike);
        }
    }
}
