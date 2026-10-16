// AI-Generated
package module42_exceptions_ai.step06_exceptions_and_interfaces_ai.challenge02_ai;

import java.io.IOException;

public class Main {
    /**
     * This keypad locks itself after too many wrong codes. Its {@code isValid} throws no checked exception, but it may throw an unchecked one. What does the program print?
     * Hints
     * 1. Only wrong codes are counted: after {@code 1111} and {@code 3333} there are two. The right code in between returns {@code true} and changes nothing.
     * 2. The fourth call finds two wrong codes already, and throws before it looks at the code. Its {@code println} never prints, and the IllegalStateException block prints the message. The IOException block never runs, but it has to be there, since {@code codes} is a DoorCodes.
     */
    public static void main(String[] args) {
        DoorCodes codes = new LimitedCode("2468", 2);
        String[] tries = {"1111", "2468", "3333", "2468"};
        for (String code : tries) {
            try {
                System.out.println(code + ": " + codes.isValid(code));
            } catch (IOException e) {
                System.out.println("out of order");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
