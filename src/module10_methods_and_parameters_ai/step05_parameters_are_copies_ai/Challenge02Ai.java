// AI-Generated
package module10_methods_and_parameters_ai.step05_parameters_are_copies_ai;

public class Challenge02Ai {
    /**
     * What does this program print? Watch which value goes to which parameter.
     * Hints
     * 1. The first argument goes to the first parameter, whatever the names are.
     * 2. The call is {@code show(y, x)}, so the method's {@code x} gets 2 and its {@code y} gets 1.
     */
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        show(y, x);
    }

    public static void show(int x, int y) {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
