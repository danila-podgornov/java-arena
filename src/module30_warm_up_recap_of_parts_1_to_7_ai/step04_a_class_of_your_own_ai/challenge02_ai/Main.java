// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step04_a_class_of_your_own_ai.challenge02_ai;

public class Main {
    /**
     * The gym's staff have regraded a route, so a second object for it has a different grade. The class is the lesson's {@code ClimbingRoute}, shortened to the parts this program uses. What does this program print?
     * Hints
     * 1. {@code ClimbingRoute c = a;} copies the reference, not the object: {@code a} and {@code c} are two names for one route. So {@code a == c}, and both {@code climb()} calls count on that one route.
     * 2. {@code equals} compares only the wall and the color, not the grade, so {@code a} and {@code b} are equal even though they're two objects with different grades.
     */
    public static void main(String[] args) {
        ClimbingRoute a = new ClimbingRoute("overhang", "green", 4);
        ClimbingRoute b = new ClimbingRoute("overhang", "green", 6);
        ClimbingRoute c = a;
        a.climb();
        c.climb();
        b.climb();
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.getAscents() + " " + b.getAscents());
    }
}
