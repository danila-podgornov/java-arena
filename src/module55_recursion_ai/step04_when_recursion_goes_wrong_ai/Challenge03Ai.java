// AI-Generated
package module55_recursion_ai.step04_when_recursion_goes_wrong_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * How much work does {@code ways} repeat? The program reads a number of steps, {@code n}, and prints the number of ways to climb them (the method of this step), then how many times {@code ways} was called in all, the first call included. Count the calls in a variable that {@code ways} adds one to each time it starts. A variable declared inside {@code ways} won't do, since each call gets its own. Declare it in the class, outside the methods, with {@code static}: {@code private static long calls = 0;}. A static variable belongs to the class itself, not to an object or a call, so every call of {@code ways} and {@code main} see the same one.
     * <p>For 4 steps, {@code ways(4)} calls {@code ways(3)} and {@code ways(2)}; {@code ways(3)} calls {@code ways(2)} and {@code ways(1)}; each {@code ways(2)} calls {@code ways(1)} and {@code ways(0)}. That's 9 calls. With the input {@code 20}, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ways: 10946
     * Calls: 21891
     * }</pre>
     * Hints
     * 1. Declare the counter in the class, outside the methods: {@code private static long calls = 0;}. Make {@code ways} add one to it as its first line, before the base case, so that every call is counted.
     * 2. Print the count after the line that prints the ways: the calls are counted while {@code ways(n)} runs.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        System.out.println("Ways: " + ways(n));
    }

    public static long ways(int steps) {
        if (steps <= 1) {
            return 1;
        }
        return ways(steps - 1) + ways(steps - 2);
    }
}
