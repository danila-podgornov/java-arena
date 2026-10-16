// AI-Generated
package module42_exceptions_ai.step04_exceptions_and_resources_ai.challenge02_ai;

public class Main {
    /**
     * Here's a faucet that prints a word when it's turned on and off. The bath is filled with two of them, as two resources of one {@code try}. What does the program print?
     * Hints
     * 1. The resources are created from left to right, and closed the other way around: the one created last is closed first.
     * 2. They're closed as soon as the {@code try} block ends, before the {@code catch} block runs. The {@code finally} block comes last.
     */
    public static void main(String[] args) {
        try (Faucet hot = new Faucet("hot"); Faucet cold = new Faucet("cold")) {
            System.out.println("filling");
            int level = 10 / 0;
            System.out.println("level " + level);
        } catch (ArithmeticException e) {
            System.out.println("caught");
        } finally {
            System.out.println("towel");
        }
    }
}
