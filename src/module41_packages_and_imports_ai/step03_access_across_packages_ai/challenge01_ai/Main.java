// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge01_ai;

import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge01_ai.vending.domain.Snack;

public class Main {
    /**
     * A vending machine's program keeps its snacks in the package {@code vending.domain}, but {@code Main.java} doesn't compile: Snack keeps too much to its own package. Make public exactly what Main uses, and nothing more. {@code refill} is only for the machine's service classes in {@code vending.domain}, so it stays package-private. Don't change {@code Main.java}. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * Pretzels: 0 left, 150 cents
     * }</pre>
     * Hints
     * 1. javac's first messages are about the class itself: {@code Snack is not public in vending.domain}. Write {@code public class Snack}, and run again: then javac gets to the constructor and to {@code getName}.
     * 2. Put {@code public} in front of the constructor and of {@code getName}. Leave {@code refill} as it is: Main doesn't call it.
     */
    public static void main(String[] args) {
        Snack pretzels = new Snack("Pretzels", 150, 1);
        System.out.println(pretzels.sell());
        System.out.println(pretzels.sell());
        System.out.println(pretzels.getName() + ": " + pretzels.getCount() + " left, " + pretzels.getPrice() + " cents");
    }
}
