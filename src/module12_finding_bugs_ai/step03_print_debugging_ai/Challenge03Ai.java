// AI-Generated
package module12_finding_bugs_ai.step03_print_debugging_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * This program reads two exam scores and should print their average with decimals. For 3 and 4 it prints {@code Average: 3.0} instead of {@code Average: 3.5}. Print the values along the way to see where the half goes missing, then fix it. With the input {@code 3} and {@code 4} it prints: see the expected output below.
     * Expected output
     * {@code Average: 3.5}
     * Hints
     * 1. {@code sum} is 7, which is right. The half is lost in the division: {@code sum / 2} divides two {@code int} values.
     * 2. Divide by {@code 2.0}, or cast first: {@code (double) sum / 2}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.valueOf(scanner.nextLine());
        int second = Integer.valueOf(scanner.nextLine());
        int sum = first + second;
        double average = sum / 2;
        System.out.println("Average: " + average);
    }
}
