// AI-Generated
package module37_streams_and_lambdas_ai.step05_streams_of_input_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The station sends {@code -} for a reading it missed. Fill in the blank, a method reference that turns a line into a number, so that the program prints the average of the real readings. The average is the stream's own {@code average()}: the sum divided by the count. For the input shown, it prints: see the expected output below.
     * Expected output
     * {@code Average: 2.5}
     * Hints
     * 1. {@code mapToInt} needs something that turns a String into a number. As a method reference, that's the class's name, {@code ::}, and the method's name, with no parentheses.
     * 2. {@code Integer::valueOf} is short for {@code line -> Integer.valueOf(line)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        double average = lines.stream()
                .filter(line -> !line.equals("-"))
                .mapToInt(___)
                .average()
                .getAsDouble();
        System.out.println("Average: " + average);
    }
}
