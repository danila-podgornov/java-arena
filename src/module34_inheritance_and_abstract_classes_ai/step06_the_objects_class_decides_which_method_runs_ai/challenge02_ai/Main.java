// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step06_the_objects_class_decides_which_method_runs_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The game wants to know who hits hardest. {@code Adventurer.java}, {@code Knight.java} and {@code Archer.java} are the lesson's. In {@code Main.java}, write the method {@code strongest(ArrayList<Adventurer> party)}, which returns the name of the member whose {@code attack()} is the highest. When several are equally strong, return the first of them. For an empty party, return {@code nobody}. The check runs:
     * <pre>{@code
     * ArrayList<Adventurer> party = new ArrayList<>();
     * party.add(new Archer("Lyra"));
     * party.add(new Adventurer("Pip"));
     * party.add(new Knight("Oren"));
     * System.out.println(strongest(party));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Oren}
     * Hints
     * 1. Return {@code nobody} first if {@code party.isEmpty()}. Otherwise keep the best member so far, starting with {@code party.get(0)}, and go through the party with a for-each loop.
     * 2. Replace the best member only when {@code member.attack() > best.attack()}, with {@code >}, so the first of equally strong members stays. Each call runs the object's own {@code attack}, so the method works for knights, archers and every other kind.
     */
    public static void main(String[] args) {
        ArrayList<Adventurer> party = new ArrayList<>();
        party.add(new Archer("Lyra"));
        party.add(new Adventurer("Pip"));
        party.add(new Knight("Oren"));
        System.out.println(strongest(party));
    }

    // Write the method strongest here.
}
