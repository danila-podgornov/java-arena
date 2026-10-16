// AI-Generated
package module15_arrays_ai.step04_searching_an_array_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads the five jumps of a long jump contest, in centimeters. Fill in the blanks, so it finds the longest jump and the round it was in (the round is the index plus one). For the input {@code 540}, {@code 575}, {@code 612}, {@code 598} and {@code 602} it prints: see the expected output below.
     * Expected output
     * {@code Best jump: 612 cm, in round 3}
     * Hints
     * 1. Each jump is compared with the best one so far.
     * 2. When a jump is better, the loop remembers both its value and its index, which is {@code i}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] jumps = new int[5];
        for (int i = 0; i < jumps.length; i++) {
            jumps[i] = Integer.valueOf(scanner.nextLine());
        }
        int best = jumps[0];
        int bestIndex = 0;
        for (int i = 1; i < jumps.length; i++) {
            if (jumps[i] > ___) {
                best = jumps[i];
                bestIndex = ___;
            }
        }
        System.out.println("Best jump: " + best + " cm, in round " + (bestIndex + 1));
    }
}
