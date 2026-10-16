// AI-Generated
package module46_random_numbers_ai.step03_decimal_numbers_and_chances_ai;

public class Challenge02Ai {
    /**
     * A reaction game waits a random time before it shows {@code GO!}, so that players can't count along. Write the method {@code waitSeconds()}, which returns a random {@code double} from 1.5 up to 4.0 seconds (4.0 itself left out), using {@code Math.random()}.
     * <p>The check calls it 10000 times. It prints whether every wait was in the range, and whether the waits filled the range, with some below 1.6 seconds and some above 3.9: see the expected output below.
     * Expected output
     * <pre>{@code
     * all from 1.5 up to 4.0: true
     * some below 1.6: true
     * some above 3.9: true
     * }</pre>
     * Hints
     * 1. The range is 4.0 - 1.5 = 2.5 seconds wide, so multiply {@code Math.random()} by 2.5. That gives 0.0 up to 2.5.
     * 2. Then add 1.5, the shortest wait: {@code return 1.5 + Math.random() * 2.5;}
     */
    public static void main(String[] args) {
        System.out.println("Get ready...");
        System.out.println("Waiting " + waitSeconds() + " seconds");
        System.out.println("GO!");
    }

    public static double waitSeconds() {
        return 0.0;
    }
}
