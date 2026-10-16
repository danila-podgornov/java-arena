// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step05_putting_it_together_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A climbing gym rents out climbing shoes, and has 2 pairs of one size on the shelf. This program reads its commands from a String, as module 20 showed a Scanner can. What does it print?
     * Hints
     * 1. Go through the commands one at a time. {@code return} adds a pair back to the shelf, but it prints nothing. {@code list} isn't a command the program knows.
     * 2. When {@code pairs} is 0, {@code rent} only prints a message. {@code quit} ends the loop, so the {@code rent} after it is never read, and the last line prints the pairs on the shelf.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner("rent\nrent\nreturn\nrent\nlist\nrent\nquit\nrent\n");
        int pairs = 2;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                break;
            }
            if (command.equals("rent")) {
                if (pairs == 0) {
                    System.out.println("No shoes left");
                } else {
                    pairs--;
                    System.out.println("Rented, " + pairs + " left");
                }
            } else if (command.equals("return")) {
                pairs++;
            } else {
                System.out.println("Unknown: " + command);
            }
        }
        System.out.println("Pairs on the shelf: " + pairs);
    }
}
