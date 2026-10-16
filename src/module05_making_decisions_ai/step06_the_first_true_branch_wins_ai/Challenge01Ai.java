// AI-Generated
package module05_making_decisions_ai.step06_the_first_true_branch_wins_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * This chain is in the wrong order, so it never prints {@code Gold}. Reorder the branches, so 1000 points or more gives {@code Gold}, 500 or more {@code Silver}, and anything less {@code Bronze}. For the input {@code 1200} the program prints {@code Gold}.
     * Input
     * {@code 1200}
     * Hints
     * 1. Every number that is at least 1000 is also at least 500, so the Silver check catches it first.
     * 2. Swap the two conditions and their messages: check {@code >= 1000} first.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = Integer.valueOf(scanner.nextLine());
        if (points >= 500) {
            System.out.println("Silver");
        } else if (points >= 1000) {
            System.out.println("Gold");
        } else {
            System.out.println("Bronze");
        }
    }
}
