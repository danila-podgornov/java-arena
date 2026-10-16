// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step04_the_command_program_with_a_class_ai.challenge03_ai;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * In the procedural version of the station, the only way to try its rules was to run the whole command loop on a list of commands. Now the rules are in {@code BikeDock}, and a test can check them alone. {@code BikeDockTest} has one test, for renting. Add a second test, for the other rule: bringing back more bikes than there are free slots changes nothing. For example, make a station of 10 slots with 8 bikes, try to bring back 3, and check that {@code bringBack} returns {@code false} and that the station still has 8 bikes.
 * <p>The checks run your tests on the BikeDock as it is, where every test should pass, and on BikeDocks with a mistake in {@code bringBack}, where your new test should fail.
 * Hints
 * 1. A new test is a {@code public void} method with {@code @Test} on the line before it. Make its own BikeDock, with {@code new BikeDock(10, 8)}, so that only 2 slots are free.
 * 2. {@code assertFalse(dock.bringBack(3));} checks the answer, and {@code assertEquals(8, dock.getBikes());} checks that nothing changed. Check both: a mistake could get either one wrong.
 */
public class BikeDockTest {
    @Test
    public void rentingTakesBikes() {
        BikeDock dock = new BikeDock(10, 4);
        assertTrue(dock.rent(3));
        assertEquals(1, dock.getBikes());
    }

    // Write a test here for bringing back more bikes than there are free slots.
}
