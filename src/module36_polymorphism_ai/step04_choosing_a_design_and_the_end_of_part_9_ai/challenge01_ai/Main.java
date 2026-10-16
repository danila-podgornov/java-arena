// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The game gets hot-air balloons that drift across the sky. A balloon flies, but it isn't an enemy: it has no health, and nobody fights it. So {@code Balloon} implements Flying and has no {@code extends}: its only superclass is Object. {@code Flying.java}, {@code Enemy.java} and {@code Bat.java} are step 2's. Write:
     * <ul>
     * <li>in {@code Balloon.java}, the class {@code Balloon}, with a constructor {@code Balloon(String color, int altitude)}, the method {@code altitude()} from Flying, and a {@code toString} that returns the color and the word {@code balloon}, like {@code red balloon}
     * <li>in {@code Main.java}, the method {@code lowest(ArrayList<Flying> flyers)}, which returns the flyer with the lowest altitude, the first of them when several are equally low, or {@code null} for an empty list
     * </ul>
     * <p>The check runs the following. A bat prints as every Enemy does, with its name and its health:
     * <pre>{@code
     * ArrayList<Flying> sky = new ArrayList<>();
     * sky.add(new Bat("Squeak", 9));
     * sky.add(new Balloon("red", 40));
     * sky.add(new Balloon("green", 6));
     * sky.add(new Bat("Flit", 12));
     * System.out.println(sky);
     * System.out.println(lowest(sky));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Squeak (8), red balloon, green balloon, Flit (8)]
     * green balloon
     * }</pre>
     * Hints
     * 1. <code>public class Balloon implements Flying {</code> with a private color and altitude, a constructor, {@code altitude()} with {@code @Override}, and {@code toString} returning {@code this.color + " balloon"}.
     * 2. In {@code lowest}, keep the lowest flyer so far in a {@code Flying} variable that starts as {@code null}. Replace it when it's still {@code null}, or when a flyer's {@code altitude()} is smaller, with {@code <} so that the first of equally low ones stays.
     */
    public static void main(String[] args) {
        ArrayList<Flying> sky = new ArrayList<>();
        sky.add(new Bat("Squeak", 9));
        sky.add(new Balloon("red", 40));
        sky.add(new Balloon("green", 6));
        sky.add(new Bat("Flit", 12));
        System.out.println(sky);
        System.out.println(lowest(sky));
    }

    // Write the method lowest here.
}
