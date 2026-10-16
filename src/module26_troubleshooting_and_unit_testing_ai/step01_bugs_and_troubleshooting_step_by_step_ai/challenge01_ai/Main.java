// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai.challenge01_ai;

public class Main {
    /**
     * A pantry keeps supplies of food, and {@code gramsOf} tells how many grams of a food there are. The program crashes:
     * <p>The program crashes with
     * <pre>{@code
     * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "Supply.getGrams()" because the return value of "Pantry.find(String)" is null
     * 	at Pantry.gramsOf(Pantry.java:24)
     * 	at Main.main(Main.java:7)
     * }</pre>
     * <p>{@code find} returns {@code null} when the pantry has no supply of that food, and {@code gramsOf} calls {@code getGrams()} on what it got. Change {@code gramsOf} in {@code Pantry.java} so it returns 0 for a food that isn't in the pantry. {@code Main.java} is ready, and with it the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 750
     * 0
     * }</pre>
     * Hints
     * 1. The first {@code at} line is {@code Pantry.gramsOf}, line 24 of {@code Pantry.java}, and the message says what was null there: the value {@code find} returned. So the fix goes in {@code gramsOf}, before {@code getGrams()} is called.
     * 2. Keep what {@code find} returns in a variable, {@code Supply supply = this.find(food);}, then {@code if (supply == null) { return 0; }}, and after that {@code return supply.getGrams();}.
     */
    public static void main(String[] args) {
        Pantry pantry = new Pantry();
        pantry.add(new Supply("rice", 500));
        pantry.add(new Supply("oats", 750));
        System.out.println(pantry.gramsOf("oats"));
        System.out.println(pantry.gramsOf("sugar"));
    }
}
