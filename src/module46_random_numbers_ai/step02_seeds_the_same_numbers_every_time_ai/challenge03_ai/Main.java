// AI-Generated
package module46_random_numbers_ai.step02_seeds_the_same_numbers_every_time_ai.challenge03_ai;

import java.util.Random;

public class Main {
    /**
     * A game's weather simulation starts at a given temperature, and every day the temperature changes by a random whole number of degrees from -3 to 3. In {@code WeatherSim.java}, write the class {@code WeatherSim} with:
     * <ul>
     * <li>a constructor {@code WeatherSim(int start, Random random)}
     * <li>{@code nextDay()}, which changes the temperature by {@code random.nextInt(7) - 3}, one call a day, and returns the new temperature
     * <li>{@code getTemperature()}, which returns the temperature now
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * WeatherSim sim = new WeatherSim(15, new Random(42));
     * for (int day = 1; day <= 5; day++) {
     *     System.out.println("Day " + day + ": " + sim.nextDay());
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Day 1: 13
     * Day 2: 15
     * Day 3: 18
     * Day 4: 18
     * Day 5: 20
     * }</pre>
     * Hints
     * 1. Keep the temperature and the Random in instance variables, set in the constructor, like DiceCup's in the lesson.
     * 2. {@code nextDay} adds {@code this.random.nextInt(7) - 3} to the temperature and returns it. Don't create a Random in the class: use the one from the constructor.
     */
    public static void main(String[] args) {
        WeatherSim sim = new WeatherSim(15, new Random(42));
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + ": " + sim.nextDay());
        }
    }
}
