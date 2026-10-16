// AI-Generated
package module54_libraries_maven_and_databases_ai.step05_packaging_other_tools_and_the_end_of_the_course_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * An e-scooter app has several ways to charge for a ride, and the interface {@code Tariff.java} describes them all: {@code int price(int minutes)} returns a ride's price in cents. {@code PerMinuteTariff.java} is ready. Write two things:
     * <ul>
     * <li>the class {@code CappedTariff}, which implements {@code Tariff}: {@code new CappedTariff(centsPerMinute, cap)} charges {@code centsPerMinute} for every minute, but never more than {@code cap} cents for a ride
     * <li>in {@code Main.java}, the method {@code cheapest(List<Tariff> tariffs, int minutes)}, which returns the lowest price any of the tariffs gives for a ride of that many minutes (the list is never empty)
     * </ul>
     * <p>The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 150
     * 600
     * 500
     * }</pre>
     * Hints
     * 1. {@code CappedTariff implements Tariff}, keeps both numbers in instance variables, and its {@code price} returns the smaller of the full price and the cap: {@code Math.min(minutes * this.centsPerMinute, this.cap)}.
     * 2. {@code cheapest} starts from the first tariff's price and goes through the list, keeping the lowest price so far. It only calls {@code price}, so it works for any kind of Tariff.
     */
    public static void main(String[] args) {
        Tariff capped = new CappedTariff(30, 600);
        System.out.println(capped.price(5));
        System.out.println(capped.price(40));

        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(new PerMinuteTariff(25));
        tariffs.add(capped);
        System.out.println(cheapest(tariffs, 20));
    }

    public static int cheapest(List<Tariff> tariffs, int minutes) {
        return 0;
    }
}
