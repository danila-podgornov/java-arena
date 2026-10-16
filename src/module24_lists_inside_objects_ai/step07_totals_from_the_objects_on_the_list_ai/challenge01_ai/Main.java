// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge01_ai;

public class Main {
    /**
     * A trip is made of legs, and {@code Leg.java} is ready: a leg goes from one place to another, and {@code getKm()} returns its length in kilometers. In {@code Trip.java}, write the method {@code totalKm()}: it returns the length of the whole trip, the sum of its legs. A trip with no legs is 0 km. The check runs:
     * <pre>{@code
     * Trip trip = new Trip();
     * trip.add(new Leg("Harbor", "Mill", 12));
     * trip.add(new Leg("Mill", "Pine Hill", 30));
     * trip.add(new Leg("Pine Hill", "Camp", 8));
     * System.out.println(trip.totalKm());
     * System.out.println(new Trip().totalKm());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 50
     * 0
     * }</pre>
     * Hints
     * 1. The method returns a whole number: <code>public int totalKm() {</code>. Start a local total at 0 before the loop.
     * 2. In {@code for (Leg leg : this.legs)}, add each leg's length: {@code total = total + leg.getKm();}. Return the total after the loop.
     */
    public static void main(String[] args) {
        Trip trip = new Trip();
        trip.add(new Leg("Harbor", "Mill", 12));
        trip.add(new Leg("Mill", "Pine Hill", 30));
        trip.add(new Leg("Pine Hill", "Camp", 8));
        System.out.println(trip.totalKm());
        System.out.println(new Trip().totalKm());
    }
}
