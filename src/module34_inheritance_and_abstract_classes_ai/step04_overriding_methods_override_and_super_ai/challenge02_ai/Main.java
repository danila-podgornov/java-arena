// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge02_ai;

public class Main {
    /**
     * A museum runs day tours and night tours. {@code NightTour} overrides both of Tour's methods, and calls Tour's version in each. What does this program print?
     * Hints
     * 1. A NightTour runs NightTour's versions. Each one prints its own line and calls Tour's version with {@code super.}, in the order the lines are written.
     * 2. In {@code start}, NightTour's own line comes before {@code super.start()}. In {@code end}, it comes after {@code super.end()}. The plain Tour runs only Tour's {@code start}.
     */
    public static void main(String[] args) {
        NightTour night = new NightTour();
        night.start();
        night.end();
        Tour day = new Tour();
        day.start();
    }
}
