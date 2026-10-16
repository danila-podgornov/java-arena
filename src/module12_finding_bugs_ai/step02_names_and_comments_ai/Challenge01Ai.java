// AI-Generated
package module12_finding_bugs_ai.step02_names_and_comments_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * In this ticket program, one line doesn't do what the comment above it says. Find it and fix the code (the comments are right). With the input {@code 5} it prints: see the expected output below.
     * Expected output
     * {@code Total: 5200 cents}
     * Hints
     * 1. Read each comment, then check the line under it against it, for a group of exactly 5.
     * 2. "5 or more" includes 5: the condition should be {@code tickets >= 5}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tickets = Integer.valueOf(scanner.nextLine());
        int priceInCents = 1250;
        // Groups of 5 or more get 20 percent off each ticket
        if (tickets > 5) {
            priceInCents = priceInCents * 80 / 100;
        }
        // A booking fee of 200 cents is added once per order
        int totalInCents = tickets * priceInCents + 200;
        System.out.println("Total: " + totalInCents + " cents");
    }
}
