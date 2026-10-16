// AI-Generated
package module42_exceptions_ai.step04_exceptions_and_resources_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Settings files often have comment lines, which start with {@code #}, and empty lines. Write the method {@code countSettings(String fileName)}, which returns how many lines of the file are settings: lines that aren't empty and don't start with {@code #}. When the file can't be read, it returns -1. Read the file with a Scanner in a try-with-resources. The check runs {@code System.out.println(countSettings("settings.txt"));} with the file shown below, and expects: see the expected output below.
     * Expected output
     * {@code 2}
     * Hints
     * 1. Make a counter before the {@code try}, count the lines that are settings inside the loop, and return it after the whole {@code try} and {@code catch}.
     * 2. The {@code catch} block returns -1. A line is a setting when {@code !line.isEmpty() && !line.startsWith("#")}.
     */
    public static void main(String[] args) {
        System.out.println(countSettings("settings.txt"));
    }

    public static int countSettings(String fileName) {
        return 0;
    }
}
