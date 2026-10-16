// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step03_tostring_ai.challenge02_ai;

public class Main {
    /**
     * A {@code Chore} on a to-do list is either done or not. Add a {@code toString} that returns {@code [ ] } followed by the chore's title while it's not done, and {@code [x] } followed by the title once it's done. The check prints a new chore, marks it done and prints it again: see the expected output below.
     * Expected output
     * <pre>{@code
     * [ ] Water the plants
     * [x] Water the plants
     * }</pre>
     * Hints
     * 1. Return one text when {@code this.done} is true and another when it's false: an {@code if} with a {@code return}, and a {@code return} after it.
     * 2. {@code if (this.done) { return "[x] " + this.title; }}, and after it {@code return "[ ] " + this.title;}
     */
    public static void main(String[] args) {
        Chore chore = new Chore("Water the plants");
        System.out.println(chore);
        chore.markDone();
        System.out.println(chore);
    }
}
