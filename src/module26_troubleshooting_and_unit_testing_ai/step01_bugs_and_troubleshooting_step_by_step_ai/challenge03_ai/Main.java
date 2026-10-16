// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai.challenge03_ai;

public class Main {
    /**
     * A bike shop rents bikes for 3 euros for the first hour and 2 euros for every hour after it. So 1 hour costs 3 euros, 2 hours cost 5 and 3 hours cost 7. Today three bikes were rented, for 1, 3 and 2 hours, and the program should print {@code Earnings: 15 euros}, but it prints {@code Earnings: 19 euros}. Nothing crashes, so no line is named for you.
     * <p>Use the checklist: try the methods one at a time with values you know the answer for, find the one wrong line, and fix it. The program then prints: see the expected output below.
     * Expected output
     * {@code Earnings: 15 euros}
     * Hints
     * 1. Narrow it down: in {@code main}, print {@code new Rental(1).fee()}, {@code new Rental(2).fee()} and {@code new Rental(3).fee()}. You know they should be 3, 5 and 7. Which ones are wrong?
     * 2. A 2-hour rental comes out as 7 instead of 5: {@code fee} charges 2 euros for every hour, the first one too, although the first hour is already in the 3 euros. The extra hours are {@code this.hours - 1}.
     */
    public static void main(String[] args) {
        BikeShop shop = new BikeShop();
        shop.rent(1);
        shop.rent(3);
        shop.rent(2);
        System.out.println("Earnings: " + shop.earnings() + " euros");
    }
}
