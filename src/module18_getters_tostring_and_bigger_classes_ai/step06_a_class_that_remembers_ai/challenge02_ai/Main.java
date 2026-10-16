// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step06_a_class_that_remembers_ai.challenge02_ai;

public class Main {
    /**
     * A dry spell is a run of dry days in a row. Add a method {@code longestDrySpell()} that returns the most dry days in a row so far (0 when there hasn't been a dry day). The log has to remember two more things: how many dry days in a row there have been up to now, and the longest run so far. Add instance variables for them, and update them in {@code add}: a dry day makes the current run one day longer, and a day with rain ends it. The check records 3, 0, 0 and 5 mm and asks, then records 0, 0, 0 and 2 mm and asks again: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 3
     * }</pre>
     * Hints
     * 1. Add {@code private int currentSpell;} and {@code private int longestSpell;}, both 0 at the start. {@code longestDrySpell()} returns {@code this.longestSpell}.
     * 2. In {@code add}: on a dry day, {@code this.currentSpell++}, and when it's now longer than {@code this.longestSpell}, store it there. On a day with rain, {@code this.currentSpell = 0;}
     */
    public static void main(String[] args) {
        RainLog log = new RainLog();
        log.add(3);
        log.add(0);
        log.add(0);
        log.add(5);
        log.add(0);
        System.out.println("Longest dry spell: " + log.longestDrySpell() + " days");
    }
}
