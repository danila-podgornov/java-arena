// AI-Generated
package module11_return_values_and_the_call_stack_ai.step06_the_call_stack_ai;

public class Challenge01Ai {
    /**
     * What does this program print?
     * Hints
     * 1. Each call to {@code greet} prints B, and then {@code main} carries on from where it was.
     * 2. {@code main} prints A, calls greet (B), prints C, and calls greet again (B).
     */
    public static void main(String[] args) {
        System.out.println("A");
        greet();
        System.out.println("C");
        greet();
    }

    public static void greet() {
        System.out.println("B");
    }
}
