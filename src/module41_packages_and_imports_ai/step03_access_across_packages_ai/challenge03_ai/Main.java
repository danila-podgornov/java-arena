// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai;

import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.domain.Machine;
import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.domain.Technician;
import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge03_ai.laundromat.dryers.Dryer;

public class Main {
    /**
     * A laundromat's program has three classes that use {@code Machine}, which is in the package {@code laundromat.domain}:
     * <ul>
     * <li>{@code Technician}, in the same package, calls {@code stopNow()}, to stop a machine in the middle of a cycle
     * <li>{@code Dryer}, a subclass of Machine in the package {@code laundromat.dryers}, changes {@code minutesLeft} directly, to add time to a running cycle
     * <li>{@code Main}, in the default package, creates machines and calls {@code start} and {@code pass}
     * </ul>
     * <p>In {@code Machine.java}, only the class and {@code toString} have a word in front of them yet, so the program doesn't compile. Give each variable, the constructor and each method the most restricted access that still works: {@code private} for what only Machine itself uses, nothing for what only its own package uses, {@code protected} for what a subclass in another package needs, and {@code public} for what Main uses. Change only {@code Machine.java}. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * Machine 4: 25 minutes left
     * Machine 9: 25 minutes left
     * Machine 4: free
     * }</pre>
     * Hints
     * 1. Go through Machine's parts one by one and ask who uses each. {@code number} appears only in Machine's own code. {@code minutesLeft} is also used by Dryer, a subclass in another package. Main calls the constructor, {@code start} and {@code pass}. Only Technician, in Machine's package, calls {@code stopNow}.
     * 2. So: {@code private int number;}, {@code protected int minutesLeft;}, {@code public Machine(int number)}, {@code public void start(...)} and {@code public void pass(...)}, and {@code stopNow()} stays as it is, with nothing in front.
     */
    public static void main(String[] args) {
        Machine washer = new Machine(4);
        Dryer dryer = new Dryer(9);
        washer.start(45);
        dryer.start(30);
        dryer.addTime(15);
        washer.pass(20);
        dryer.pass(20);
        System.out.println(washer);
        System.out.println(dryer);
        new Technician().stop(washer);
        System.out.println(washer);
    }
}
