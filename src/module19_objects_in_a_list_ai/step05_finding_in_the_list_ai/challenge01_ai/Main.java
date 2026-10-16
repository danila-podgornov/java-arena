// AI-Generated
package module19_objects_in_a_list_ai.step05_finding_in_the_list_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * {@code Swimmer.java} is ready. Write a method {@code fastest(ArrayList<Swimmer> swimmers)} that returns the swimmer with the smallest time. When two swimmers share the best time, return the one that comes first in the list. The list always has at least one swimmer. The check runs {@code System.out.println(fastest(swimmers));} for the list in {@code main} and expects: see the expected output below.
     * Expected output
     * {@code Tom (64 s)}
     * Hints
     * 1. The method returns a swimmer, so it starts <code>public static Swimmer fastest(ArrayList&lt;Swimmer&gt; swimmers) {</code>. Begin with {@code Swimmer best = swimmers.get(0);}.
     * 2. Replace {@code best} when {@code swimmer.getSeconds() < best.getSeconds()}. With {@code <} and not {@code <=}, the first of two equal times stays. Return {@code best} after the loop.
     */
    public static void main(String[] args) {
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        swimmers.add(new Swimmer("Ines", 71));
        swimmers.add(new Swimmer("Tom", 64));
        swimmers.add(new Swimmer("Mia", 68));
        System.out.println(fastest(swimmers));
    }

    // Write the fastest method here.
}
