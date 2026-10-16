// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge03_ai;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A treadmill's speed goes up and down 1 km/h at a time, but never below 1 or above 12. The Treadmill class is right. {@code TreadmillTest} isn't: one of its tests fails, and the other passes but has its two values the wrong way around.
 * <p>Run the tests and read the report. Fix the test that expects the wrong number (the class does what it should, so the test is what's wrong), and put the expected value first in the other one. The fixed tests should pass on the Treadmill and still catch a treadmill that goes below 1 km/h.
 * Hints
 * 1. The report says {@code expected:<0> but was:<1>}. From 3, three steps down would be 0, but the treadmill stops at 1, as it should. So the test's 0 is the mistake.
 * 2. Change the 0 to 1 in {@code neverSlowerThanOne}, and write the other one as {@code assertEquals(6, treadmill.getSpeed());}.
 */
public class TreadmillTest {
    @Test
    public void fasterAddsOne() {
        Treadmill treadmill = new Treadmill(5);
        treadmill.faster();
        assertEquals(treadmill.getSpeed(), 6);
    }

    @Test
    public void neverSlowerThanOne() {
        Treadmill treadmill = new Treadmill(3);
        treadmill.slower();
        treadmill.slower();
        treadmill.slower();
        assertEquals(0, treadmill.getSpeed());
    }
}
