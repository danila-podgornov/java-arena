// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge01_ai;

import module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge01_ai.planetarium.logic.Schedule;

public class Main {
    /**
     * A planetarium's program has its classes in two packages, {@code planetarium.domain} and {@code planetarium.logic}, but it has four mistakes about packages: a wrong package line, a missing import and two missing {@code public}s. Read javac's messages, fix one mistake at a time, and run again after each fix. Don't change what the program does. It should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * 100 minutes of shows
     * Longest: Black Holes (40 minutes)
     * }</pre>
     * Hints
     * 1. Start with {@code Show.java}: it's in the folder {@code planetarium/domain/}, so its package line is {@code package planetarium.domain;}. Many of javac's messages go away with that fix.
     * 2. Then: Main uses {@code Show} without importing it ({@code import planetarium.domain.Show;}), Main calls Schedule's constructor, which isn't public, and Schedule, in another package, calls Show's {@code getMinutes()}, which isn't public either.
     */
    public static void main(String[] args) {
        Schedule saturday = new Schedule();
        saturday.add(new Show("Journey to Mars", 35));
        saturday.add(new Show("The Night Sky", 25));
        saturday.add(new Show("Black Holes", 40));
        System.out.println(saturday.totalMinutes() + " minutes of shows");
        System.out.println("Longest: " + saturday.longest());
    }
}
