// AI-Generated
package module46_random_numbers_ai.step05_simulations_and_checking_random_results_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    /**
     * To finish the module, a random seating plan for a dinner party. In {@code SeatingPlan.java}, write the class {@code SeatingPlan} with:
     * <ul>
     * <li>a constructor {@code SeatingPlan(ArrayList<String> guests, int tables, Random random)}. It shuffles a copy of the guest list with {@code Collections.shuffle(copy, random)} (the list it's given keeps its order), and then deals the shuffled guests out to the tables in turn, the way cards are dealt: the first guest to table 1, the second to table 2, and so on, back to table 1 after the last table.
     * <li>{@code table(int number)}, which returns an {@code ArrayList<String>} of the guests at that table, in the order they were dealt. Tables are numbered from 1.
     * <li>{@code toString()}, which returns one line for each table, like {@code Table 1: Noor, Luca}, with the names separated by a comma and a space, and a line break between the tables.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * ArrayList<String> guests = new ArrayList<>();
     * guests.add("Noor");
     * guests.add("Emil");
     * guests.add("Sade");
     * guests.add("Luca");
     * guests.add("Mei");
     * guests.add("Arjun");
     * guests.add("Rosa");
     * SeatingPlan plan = new SeatingPlan(guests, 3, new Random(4));
     * System.out.println(plan);
     * System.out.println(plan.table(2).size() + " at table 2");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Table 1: Emil, Arjun, Luca
     * Table 2: Sade, Rosa
     * Table 3: Noor, Mei
     * 2 at table 2
     * }</pre>
     * Hints
     * 1. In the constructor, copy the guests, shuffle the copy with the Random, and keep the copy and the number of tables in instance variables. That shuffled order is all the plan needs.
     * 2. Dealing in turn puts the guest at index {@code i} of the shuffled list at table {@code i % tables + 1}. So {@code table(number)} collects the guests whose index gives {@code i % this.tables == number - 1}, and {@code toString} adds each table's names in a loop, with {@code ", "} before every name except the first, which an index loop can tell by {@code i > 0} (as in module 39).
     */
    public static void main(String[] args) {
        ArrayList<String> guests = new ArrayList<>();
        guests.add("Noor");
        guests.add("Emil");
        guests.add("Sade");
        guests.add("Luca");
        guests.add("Mei");
        guests.add("Arjun");
        guests.add("Rosa");
        SeatingPlan plan = new SeatingPlan(guests, 3, new Random(4));
        System.out.println(plan);
        System.out.println(plan.table(2).size() + " at table 2");
    }
}
