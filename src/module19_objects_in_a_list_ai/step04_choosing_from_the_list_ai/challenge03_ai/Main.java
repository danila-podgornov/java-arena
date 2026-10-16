// AI-Generated
package module19_objects_in_a_list_ai.step04_choosing_from_the_list_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * Write a method {@code printFrom(ArrayList<Friend> friends, String city)} that prints the name of every friend who lives in {@code city}, one per line, and then how many there were, like {@code 2 in Lisbon}. {@code Friend.java} is ready. The check calls the method with the list in {@code main} (Ines and Mia in Lisbon, Tom in Leeds) and the city {@code Lisbon}, and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ines
     * Mia
     * 2 in Lisbon
     * }</pre>
     * Hints
     * 1. Compare Strings with {@code equals}: {@code if (friend.getCity().equals(city))}.
     * 2. Print {@code friend.getName()}, not the whole friend, and count the matches. The line {@code count + " in " + city} comes after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Ines", "Lisbon"));
        friends.add(new Friend("Tom", "Leeds"));
        friends.add(new Friend("Mia", "Lisbon"));
        printFrom(friends, "Lisbon");
    }

    // Write the printFrom method here.
}
