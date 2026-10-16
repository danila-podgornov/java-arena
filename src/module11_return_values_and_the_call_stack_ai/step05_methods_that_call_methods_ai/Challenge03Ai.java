// AI-Generated
package module11_return_values_and_the_call_stack_ai.step05_methods_that_call_methods_ai;

public class Challenge03Ai {
    /**
     * Write {@code printTable(int from, int to)}, which prints the rows from {@code from} to {@code to} by calling the {@code printRow} method that's already there. The check runs {@code printTable(2, 4);} and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 squared is 4
     * 3 squared is 9
     * 4 squared is 16
     * }</pre>
     * Hints
     * 1. {@code printTable} is {@code void}: it prints, and returns nothing.
     * 2. A loop from {@code from} to {@code to} that calls {@code printRow(i);}
     */
    public static void main(String[] args) {
        printTable(2, 4);
    }

    public static void printRow(int number) {
        System.out.println(number + " squared is " + number * number);
    }

    // Write the printTable method here.
}
