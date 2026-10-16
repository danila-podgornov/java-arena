// AI-Generated
package module42_exceptions_ai.step03_checked_exceptions_and_throws_ai;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Challenge02Ai {
    /**
     * A writing app counts the words in an essay. The program doesn't compile: javac says {@code unreported exception IOException} in {@code countWords}. Make {@code countWords} pass the exception on with {@code throws}, and make {@code main} catch it: when the file can't be read, the program prints {@code Could not read essay.txt}. {@code countWords} gets no {@code try} of its own. For the file shown below, the program prints: see the expected output below.
     * Expected output
     * {@code Words: 9}
     * Hints
     * 1. Add {@code throws IOException} to {@code countWords}'s header, after the parentheses. Then javac's message moves to {@code main}, which calls it.
     * 2. In {@code main}, put the {@code println} in a {@code try} block, and print {@code Could not read essay.txt} in {@code catch (IOException e)}.
     */
    public static void main(String[] args) {
        System.out.println("Words: " + countWords("essay.txt"));
    }

    public static int countWords(String fileName) {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        int words = 0;
        for (String line : lines) {
            words += line.split(" ").length;
        }
        return words;
    }
}
