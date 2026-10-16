// AI-Generated
package module28_sorting_and_searching_ai.step02_swapping_and_sorting_by_hand_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * A relay team's running order is a list of names. Write the method {@code tradePlaces(ArrayList<String> order, int a, int b)}, which swaps the runners at indexes {@code a} and {@code b}. A list has no {@code [ ]}: read an element with {@code get}, and put a new one in its place with {@code set(index, value)} (module 14). The check runs:
     * <pre>{@code
     * ArrayList<String> order = new ArrayList<>();
     * order.add("Ada");
     * order.add("Bo");
     * order.add("Cy");
     * order.add("Dee");
     * tradePlaces(order, 1, 2);
     * System.out.println(order);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Ada, Cy, Bo, Dee]}
     * Hints
     * 1. It's the same three moves as {@code switchPlaces}, with list methods. The third glass is a String: {@code String temp = order.get(a);}.
     * 2. {@code order.set(a, order.get(b));} puts runner {@code b} at index {@code a}, and {@code order.set(b, temp);} puts the runner you kept in {@code temp} at index {@code b}.
     */
    public static void main(String[] args) {
        ArrayList<String> order = new ArrayList<>();
        order.add("Ada");
        order.add("Bo");
        order.add("Cy");
        order.add("Dee");
        tradePlaces(order, 1, 2);
        System.out.println(order);
    }

    // Write the method tradePlaces here.
}
