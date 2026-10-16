// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step03_contains_and_indexof_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * The program reads a seat and says whether it's taken. Fill in the blank with the right list method. For the input {@code B4} it prints: see the expected output below.
     * Expected output
     * {@code Seat B4 is taken}
     * Hints
     * 1. The method that answers {@code true} or {@code false} to "is this value in the list?"
     * 2. {@code taken.contains(seat)}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> taken = new ArrayList<>();
        taken.add("A1");
        taken.add("A2");
        taken.add("B4");

        String seat = scanner.nextLine();
        if (taken.___(seat)) {
            System.out.println("Seat " + seat + " is taken");
        } else {
            System.out.println("Seat " + seat + " is free");
        }
    }
}
