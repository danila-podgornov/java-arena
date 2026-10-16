// AI-Generated
package module43_writing_files_ai.step02_adding_to_a_file_ai;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A reading log. The program reads the title of a book you've just finished, adds it as a new line at the end of {@code books.txt}, and prints {@code Added: } and the title. Fill in the blanks, so that the titles already in the file stay, and the file is created if there isn't one yet. For the input {@code Dune} and the file shown below, it prints:
     * {@code Added: Dune}
     * <p>and {@code books.txt} then ends with the line {@code Dune}.
     * Hints
     * 1. The class that can append to a file is {@code FileWriter}, and the PrintWriter writes through it.
     * 2. FileWriter's second parameter says whether to append: {@code true} keeps what the file holds and writes after it.
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        PrintWriter writer = new PrintWriter(new ___("books.txt", ___));
        writer.println(title);
        writer.close();
        System.out.println("Added: " + title);
    }
}
