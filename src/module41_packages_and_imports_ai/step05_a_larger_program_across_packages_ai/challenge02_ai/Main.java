// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai;

import java.util.Scanner;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.logic.Workroom;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.ui.TextUI;

public class Main {
    /**
     * A tailor's shop takes in clothes to alter, and its program is in three packages: {@code tailor.domain} with the class Garment, {@code tailor.logic} with the class Workroom, and {@code tailor.ui} with a TextUI. Main gives the user interface a Scanner that reads a String, as in module 25, so the program runs without anyone typing. What does it print?
     * Hints
     * 1. Follow the input line by line: {@code drop} reads a name and a garment and prints the order number that Workroom returns, and {@code pickup} reads an order number. {@code nextNumber} only grows: a garment that is picked up doesn't give its number back.
     * 2. The second {@code pickup} of order 1 finds nothing, since Nadia's trousers left the list the first time. At {@code quit}, Hugo's jacket and Greta's skirt are still waiting.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner("drop\nNadia\ntrousers\ndrop\nHugo\njacket\npickup\n1\npickup\n1\ndrop\nGreta\nskirt\nquit\n");
        TextUI ui = new TextUI(input, new Workroom());
        ui.start();
    }
}
