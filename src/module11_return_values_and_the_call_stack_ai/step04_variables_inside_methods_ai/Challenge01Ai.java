// AI-Generated
package module11_return_values_and_the_call_stack_ai.step04_variables_inside_methods_ai;

public class Challenge01Ai {
    /**
     * {@code main} tries to use the method's variable {@code total}, so the program doesn't compile. Fix {@code main} by using the value {@code calculateTotal} returns. The program prints: see the expected output below.
     * Expected output
     * {@code Total: 7}
     * Hints
     * 1. The {@code total} inside {@code calculateTotal} doesn't exist in {@code main}.
     * 2. Store the returned value: {@code int total = calculateTotal(3, 4);}
     */
    public static void main(String[] args) {
        calculateTotal(3, 4);
        System.out.println("Total: " + total);
    }

    public static int calculateTotal(int first, int second) {
        int total = first + second;
        return total;
    }
}
