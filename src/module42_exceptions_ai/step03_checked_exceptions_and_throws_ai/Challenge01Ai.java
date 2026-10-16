// AI-Generated
package module42_exceptions_ai.step03_checked_exceptions_and_throws_ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Challenge01Ai {
    /**
     * Fill in the blanks, so that {@code countGuests} passes the IOException on and {@code main} handles it. The program prints how many names {@code guests.txt} has, one per line, or {@code No guest list yet} when the file can't be read (one of the tests gives no file). For the file shown below, it prints: see the expected output below.
     * Expected output
     * {@code Guests: 3}
     * Hints
     * 1. The {@code try} block is followed by the block that runs when the reading fails: {@code catch}.
     * 2. A method declares the exceptions it passes on in its header, after the parameters, with the word {@code throws}.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Guests: " + countGuests("guests.txt"));
        } ___ (IOException e) {
            System.out.println("No guest list yet");
        }
    }

    public static int countGuests(String fileName) ___ IOException {
        List<String> names = Files.readAllLines(Paths.get(fileName));
        return names.size();
    }
}
