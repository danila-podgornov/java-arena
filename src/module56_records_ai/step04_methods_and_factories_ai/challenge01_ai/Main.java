// AI-Generated
package module56_records_ai.step04_methods_and_factories_ai.challenge01_ai;

public class Main {
    /**
     * A hiking app marks waypoints on a map, each at a point {@code x}, {@code y} (in kilometers). In {@code Waypoint.java}, add to the record {@code Waypoint(double x, double y)} the method {@code distanceTo(Waypoint other)}, which returns the straight-line distance between this waypoint and the other one: the square root ({@code Math.sqrt}) of the x difference squared plus the y difference squared. The check runs:
     * <pre>{@code
     * Waypoint camp = new Waypoint(1.0, 2.0);
     * Waypoint lake = new Waypoint(4.0, 6.0);
     * System.out.println(camp.distanceTo(lake));
     * System.out.println(lake.distanceTo(camp));
     * System.out.println(camp.distanceTo(camp));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 5.0
     * 5.0
     * 0.0
     * }</pre>
     * Hints
     * 1. The header is {@code public double distanceTo(Waypoint other)}, inside the record's braces. {@code this.x} and {@code other.x} are the two x values.
     * 2. Keep the differences in variables: {@code double dx = this.x - other.x;} and the same for y. Then {@code return Math.sqrt(dx * dx + dy * dy);}. Squaring makes a negative difference positive, so the order doesn't matter.
     */
    public static void main(String[] args) {
        Waypoint camp = new Waypoint(1.0, 2.0);
        Waypoint lake = new Waypoint(4.0, 6.0);
        System.out.println(camp.distanceTo(lake));
        System.out.println(lake.distanceTo(camp));
        System.out.println(camp.distanceTo(camp));
    }
}
