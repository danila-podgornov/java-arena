// AI-Generated
package module23_objects_working_together_ai.step04_equal_objects_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * A parking app looks for one car by its license plate. {@code LicensePlate} has an {@code equals} method, but it has two problems. With the input {@code ABC-123}, the plates aren't equal, although the codes are the same: the codes are Strings, compared with {@code ==}. And comparing a plate with something that isn't a plate, such as the String {@code "ABC-123"}, crashes the program with a {@code ClassCastException}, since {@code (LicensePlate)} can't turn a String into a plate.
     * <p>Rewrite {@code equals} the way the lesson showed: the {@code this ==} check, {@code instanceof}, the cast, and the code compared with {@code equals}. {@code Main.java} is ready: it reads a code and prints whether that plate equals the wanted one, and then whether it equals the String {@code "ABC-123"}, which it never does, because a String isn't a plate. For the input {@code ABC-123} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. Before the cast, add the check: {@code if (!(compared instanceof LicensePlate)) { return false; }}. Then a String never reaches the cast. The {@code if (this == compared)} check goes first, as in the lesson.
     * 2. The codes are Strings, so the last line is {@code return this.code.equals(other.code);}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LicensePlate wanted = new LicensePlate("ABC-123");
        LicensePlate seen = new LicensePlate(scanner.nextLine());
        System.out.println(seen.equals(wanted));
        System.out.println(seen.equals("ABC-123"));
    }
}
