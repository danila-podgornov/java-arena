// AI-Generated
package module24_lists_inside_objects_ai.step01_lists_a_quick_review_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * {@code Runner.java} is ready: a runner has a name and a time in minutes, with the getters {@code getName()} and {@code getMinutes()}, and a toString that gives, for example, {@code Ada, 27 min}. In {@code Main.java}, write the method {@code printFaster(ArrayList<Runner> runners, int limit)}. It prints every runner whose time is less than {@code limit} minutes, one per line, in the order of the list. The check runs:
     * <pre>{@code
     * ArrayList<Runner> runners = new ArrayList<>();
     * runners.add(new Runner("Ada", 27));
     * runners.add(new Runner("Bo", 35));
     * runners.add(new Runner("Cy", 22));
     * printFaster(runners, 30);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ada, 27 min
     * Cy, 22 min
     * }</pre>
     * Hints
     * 1. The method starts <code>public static void printFaster(ArrayList&lt;Runner&gt; runners, int limit) {</code>. Inside it, go through the list with <code>for (Runner runner : runners) {</code>.
     * 2. In the loop, {@code runner.getMinutes()} is this runner's time. When it's less than {@code limit}, print the runner: {@code System.out.println(runner);} uses Runner's toString.
     */
    public static void main(String[] args) {
        ArrayList<Runner> runners = new ArrayList<>();
        runners.add(new Runner("Ada", 27));
        runners.add(new Runner("Bo", 35));
        runners.add(new Runner("Cy", 22));
        printFaster(runners, 30);
    }

    // Write the printFaster method here.
}
