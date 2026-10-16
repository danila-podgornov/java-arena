// AI-Generated
package module10_methods_and_parameters_ai.step02_calling_a_method_from_a_loop_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * Read how many cheers the crowd wants, and call {@code cheer()} that many times. For the input {@code 3} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Hip hip hooray!
     * Hip hip hooray!
     * Hip hip hooray!
     * }</pre>
     * Hints
     * 1. The loop runs {@code times} times instead of a fixed number.
     * 2. {@code for (int i = 0; i < times; i++) { cheer(); }}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.valueOf(scanner.nextLine());

    }

    public static void cheer() {
        System.out.println("Hip hip hooray!");
    }
}
