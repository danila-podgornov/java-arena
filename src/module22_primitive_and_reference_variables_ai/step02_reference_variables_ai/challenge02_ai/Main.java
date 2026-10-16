// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * Ana and Ben each have a piggy bank. The program reads how much Ana puts in hers and then how much Ben puts in his, and prints both piggy banks. But it prints the same piggy bank twice, with both amounts in it. Find the line that leaves Ben without a piggy bank of his own, and fix it. For the input {@code 5} and {@code 3} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ana: 5 euros
     * Ben: 3 euros
     * }</pre>
     * Hints
     * 1. {@code PiggyBank ben = ana;} doesn't build a piggy bank. It copies the reference, so {@code ben} points at Ana's.
     * 2. Build Ben his own with {@code new}: {@code PiggyBank ben = new PiggyBank("Ben");}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PiggyBank ana = new PiggyBank("Ana");
        PiggyBank ben = ana;
        ana.deposit(Integer.valueOf(scanner.nextLine()));
        ben.deposit(Integer.valueOf(scanner.nextLine()));
        System.out.println(ana);
        System.out.println(ben);
    }
}
