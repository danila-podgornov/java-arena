// AI-Generated
package module05_making_decisions_ai.step01_if_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * Fill in the condition, so the program prints {@code Too heavy for the cabin.} only when the bag weighs over 8 kilograms. Every run ends with {@code Have a good flight.}
     * Input
     * {@code 12}
     * Hints
     * 1. The condition compares {@code weight} with 8 using {@code >}.
     * 2. Exactly 8 is not over 8, so {@code weight > 8} is right and {@code weight >= 8} isn't.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int weight = Integer.valueOf(scanner.nextLine());
        if (___) {
            System.out.println("Too heavy for the cabin.");
        }
        System.out.println("Have a good flight.");
    }
}
