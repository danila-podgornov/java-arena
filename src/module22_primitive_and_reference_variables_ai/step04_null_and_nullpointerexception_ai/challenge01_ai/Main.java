// AI-Generated
package module22_primitive_and_reference_variables_ai.step04_null_and_nullpointerexception_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * {@code Coat.java} is ready, and the method {@code find} returns the coat with the given ticket number, or {@code null} when no coat has it. The program reads a ticket number and hands out the coat, but it crashes when the ticket isn't found. Check what {@code find} returned before using it, and when it's {@code null}, print {@code No coat with ticket} and the number. With the input {@code 7} the program prints {@code Here is your gray wool coat}, and with the input {@code 5} it prints: see the expected output below.
     * Expected output
     * {@code No coat with ticket 5}
     * Hints
     * 1. For the ticket 5, {@code find} returns {@code null}, and {@code coat.getDescription()} then has no coat to run on. Check first: {@code if (coat == null) { ... } else { ... }}.
     * 2. When it's {@code null}, print {@code "No coat with ticket " + ticket}. Otherwise print the line that's already there.
     */
    public static void main(String[] args) {
        ArrayList<Coat> coats = new ArrayList<>();
        coats.add(new Coat(12, "red raincoat"));
        coats.add(new Coat(7, "gray wool coat"));
        coats.add(new Coat(31, "green parka"));

        Scanner scanner = new Scanner(System.in);
        int ticket = Integer.valueOf(scanner.nextLine());
        Coat coat = find(coats, ticket);
        System.out.println("Here is your " + coat.getDescription());
    }

    public static Coat find(ArrayList<Coat> coats, int ticket) {
        for (Coat coat : coats) {
            if (coat.getTicket() == ticket) {
                return coat;
            }
        }
        return null;
    }
}
