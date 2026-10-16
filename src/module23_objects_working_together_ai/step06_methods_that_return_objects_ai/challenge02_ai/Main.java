// AI-Generated
package module23_objects_working_together_ai.step06_methods_that_return_objects_ai.challenge02_ai;

public class Main {
    /**
     * A journey is made of legs. In {@code Leg.java}, write the method {@code then(Leg next)}. It returns a new Leg that starts where this leg starts and ends where the next leg ends, and its kilometers are the two legs' kilometers added up. Neither leg changes. The check runs:
     * <pre>{@code
     * Leg first = new Leg("Northport", "Eastvale", 120);
     * Leg second = new Leg("Eastvale", "Southby", 85);
     * Leg whole = first.then(second);
     * System.out.println(whole);
     * System.out.println(first);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Northport to Southby, 205 km
     * Northport to Eastvale, 120 km
     * }</pre>
     * Hints
     * 1. The method takes a Leg and returns a Leg: <code>public Leg then(Leg next) {</code>. Inside, {@code this.from} is where this leg starts, and {@code next.to} is where the next one ends.
     * 2. {@code return new Leg(this.from, next.to, this.km + next.km);}
     */
    public static void main(String[] args) {
        Leg first = new Leg("Northport", "Eastvale", 120);
        Leg second = new Leg("Eastvale", "Southby", 85);
        Leg whole = first.then(second);
        System.out.println(whole);
        System.out.println(first);
    }
}
