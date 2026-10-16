// AI-Generated
package module46_random_numbers_ai.step03_decimal_numbers_and_chances_ai.challenge03_ai;

import java.util.Random;

public class Main {
    /**
     * A capsule machine at a fair gives a {@code sticker} 50% of the time, a {@code keychain} 25% of the time, a {@code badge} 20% of the time and a {@code plush toy} the other 5%. In {@code PrizeMachine.java}, write the class {@code PrizeMachine} with a constructor {@code PrizeMachine(Random random)} and a method {@code prize()}. {@code prize()} draws one {@code nextDouble()} from the machine's Random and returns the prize: a sticker below 0.5, a keychain below 0.75, a badge below 0.95, and a plush toy otherwise. The check runs:
     * <pre>{@code
     * PrizeMachine machine = new PrizeMachine(new Random(24));
     * for (int i = 0; i < 6; i++) {
     *     System.out.println(machine.prize());
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * keychain
     * badge
     * sticker
     * sticker
     * keychain
     * plush toy
     * }</pre>
     * Hints
     * 1. Keep the Random in an instance variable. In {@code prize()}, draw the number once: {@code double draw = this.random.nextDouble();}
     * 2. Then {@code if (draw < 0.5)} gives a sticker, {@code else if (draw < 0.75)} a keychain (0.5 + 0.25), {@code else if (draw < 0.95)} a badge (0.75 + 0.2), and {@code else} a plush toy.
     */
    public static void main(String[] args) {
        PrizeMachine machine = new PrizeMachine(new Random(24));
        for (int i = 0; i < 6; i++) {
            System.out.println(machine.prize());
        }
    }
}
