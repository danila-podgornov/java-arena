// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step05_objects_as_keys_in_practice_ai.challenge03_ai;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    /**
     * The board game from the lesson wants to know which squares get the most traffic. Read the squares that tokens land on, such as {@code C4}, one per line, until an empty line, and count the landings on each square in a {@code HashMap<Square, Integer>}. After the empty line comes one more line: the number of a row. Print that row's squares from column A to F, one per line, each with how many times a token landed there, like {@code C4: 2}. A square nobody landed on gets 0.
     * <p>{@code Square.java} has the column, the row and a {@code toString} that gives names like {@code C4}: write its {@code equals} and {@code hashCode}. In {@code Main.java}, a line such as {@code C4} gives the column with {@code line.substring(0, 1)} and the row with {@code Integer.valueOf(line.substring(1))}. For the output, don't go through the map: go through the columns A to F (an array {@code {"A", "B", "C", "D", "E", "F"}} works well) and look each square up with a new Square. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * A4: 0
     * B4: 1
     * C4: 2
     * D4: 0
     * E4: 0
     * F4: 1
     * }</pre>
     * Hints
     * 1. Square's {@code equals} compares the column with {@code equals} and the row with {@code ==}, and {@code hashCode} can be {@code 31 * this.column.hashCode() + this.row}, as in step 3. Without both, every new C4 counts as a different square, and the counts stay at 0 or 1.
     * 2. Count in a {@code while (true)} loop that breaks at the empty line: {@code landings.put(square, landings.getOrDefault(square, 0) + 1);}. Then read the row with {@code Integer.valueOf(scanner.nextLine())}, and for each column of the array make {@code new Square(column, row)} and print it with {@code landings.getOrDefault(square, 0)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Square, Integer> landings = new HashMap<>();

    }
}
