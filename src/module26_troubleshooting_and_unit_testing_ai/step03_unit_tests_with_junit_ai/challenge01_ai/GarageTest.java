// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge01_ai;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * {@code GarageTest} has a new test, {@code leavingFreesASpot}, that's nearly done: it makes a garage with 3 spots, parks two cars and lets one leave. But it doesn't check anything yet, so it passes whatever {@code leave} does. Add an {@code assertEquals} at its end that checks that 2 spots are free. The checks run your tests on the Garage as it is, where every test should pass, and on a Garage whose {@code leave} never frees a spot, where your test should fail.
 * Hints
 * 1. The test above it shows the shape: {@code assertEquals(} the number you expect, a comma, and the call that gives the real value {@code )}.
 * 2. Add {@code assertEquals(2, garage.freeSpots());} as the last line of {@code leavingFreesASpot}. The expected value, 2, goes first.
 */
public class GarageTest {
    @Test
    public void parkingTakesOneSpot() {
        Garage garage = new Garage(3);
        garage.park();
        assertEquals(2, garage.freeSpots());
    }

    @Test
    public void leavingFreesASpot() {
        Garage garage = new Garage(3);
        garage.park();
        garage.park();
        garage.leave();
        // Check here that 2 spots are free.
    }
}
