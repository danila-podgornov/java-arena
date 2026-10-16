// AI-Generated
package module19_objects_in_a_list_ai.step03_several_values_for_each_object_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A cinema takes bookings. {@code Booking.java} is ready. Read the bookings: for each one, the name of the person and then the row number. The input ends with an empty line where the next name would be. Create a {@code Booking} for each and add it to the list {@code bookings}, and then print every booking. For the input {@code Ines}, {@code 12}, {@code Tom}, {@code 3} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ines: row 12
     * Tom: row 3
     * }</pre>
     * Hints
     * 1. Read the name and check it with {@code isEmpty()} first. Only after that, read the row: {@code int row = Integer.valueOf(scanner.nextLine());}.
     * 2. {@code bookings.add(new Booking(name, row));} ends each round. Print the bookings with a for-each loop after the reading loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Booking> bookings = new ArrayList<>();

    }
}
