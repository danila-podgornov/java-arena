// AI-Generated
package module12_finding_bugs_ai.step02_names_and_comments_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * This program works, but its names hide what it does. It reads a distance in kilometers and a time in minutes, and prints the average speed in kilometers per hour. Rename the variables {@code a}, {@code b} and {@code c} to names that say what they hold (the output must stay the same). With the input {@code 42} and {@code 210} it prints: see the expected output below.
     * Expected output
     * {@code Average speed: 12.0 km/h}
     * Hints
     * 1. {@code a} is the distance, {@code b} the time in minutes, and {@code c} the speed. Change every place a name is used, not only where it's declared.
     * 2. For example {@code kilometers}, {@code minutes} and {@code kilometersPerHour}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.valueOf(scanner.nextLine());
        double b = Double.valueOf(scanner.nextLine());
        double c = a / (b / 60);
        System.out.println("Average speed: " + c + " km/h");
    }
}
