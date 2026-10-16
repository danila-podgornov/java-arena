package module03_variables_and_types.step02_changing_a_value;

public class Challenge02 {
    /**
     * This program doesn't compile, because it creates the variable points twice. Fix it so it changes the value instead, and prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Points: 10
     * Points: 25
     * }</pre>
     */
    public static void main(String[] args) {
        int points = 10;
        System.out.println("Points: " + points);
        points = 25;
        System.out.println("Points: " + points);
    }
}
