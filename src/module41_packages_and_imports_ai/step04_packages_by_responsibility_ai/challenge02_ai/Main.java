// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai;

import java.util.Scanner;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.logic.Cattery;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.ui.TextUI;

public class Main {
    /**
     * A cattery's program works, but its logic prints: {@code checkIn} and {@code checkOut} in {@code Cattery} print their own messages. No other user interface could use them, and nothing can ask them whether they worked.
     * <p>Change the two methods in {@code Cattery.java} so that they print nothing and return a {@code boolean}: {@code checkIn} returns whether the cat got a pen, and {@code checkOut} whether a cat of that name was there to go home. Then make {@code TextUI.java} print the messages, which stay exactly as they are. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Mochi checked in
     * > Bella checked in
     * > No free pen for Max
     * > Cats: 2
     * > No cat called Max
     * > Mochi went home
     * > Cats: 1
     * > Bye!
     * }</pre>
     * Hints
     * 1. In Cattery, the headers become {@code public boolean checkIn(Cat cat)} and {@code public boolean checkOut(String name)}. Each {@code System.out.println} turns into {@code return true;} or {@code return false;}: the cat got a pen or didn't, the cat was found or wasn't.
     * 2. In TextUI, use what the method returns: <code>if (this.cattery.checkIn(new Cat(name))) {</code> prints {@code name + " checked in"}, and its {@code else} prints the message about the full cattery. {@code out} works the same way.
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI(new Scanner(System.in), new Cattery(2));
        ui.start();
    }
}
