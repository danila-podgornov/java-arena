// AI-Generated
package module11_return_values_and_the_call_stack_ai.step06_the_call_stack_ai;

public class Challenge02Ai {
    /**
     * What does this program print? Three methods call each other.
     * Hints
     * 1. {@code first} doesn't end until {@code second} has finished.
     * 2. The order is: main starts, first starts, second, first ends, main ends.
     */
    public static void main(String[] args) {
        System.out.println("main starts");
        first();
        System.out.println("main ends");
    }

    public static void first() {
        System.out.println("first starts");
        second();
        System.out.println("first ends");
    }

    public static void second() {
        System.out.println("second");
    }
}
