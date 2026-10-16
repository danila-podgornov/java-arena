// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge02_ai;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The countdown from this step gets a new method, {@code reset()}, which starts it over from the seconds it was made with. It's in {@code Countdown.java} as an empty shell. Work test first:
 * <ol>
 * <li>In {@code CountdownTest}, write a new test that makes a countdown, ticks a few times, calls {@code reset()} and checks {@code secondsLeft()}. Run the tests: your new test should fail.
 * <li>Then write {@code reset()}, and run the tests again: now all of them should pass.
 * </ol>
 * <p>The checks run your tests on your Countdown, where all should pass, and on the Countdown with the empty {@code reset()}, where your new test should fail. Then they run tests of their own on your {@code reset()}.
 * Hints
 * 1. The test: {@code Countdown countdown = new Countdown(60);}, two {@code countdown.tick();} calls, {@code countdown.reset();} and {@code assertEquals(60, countdown.secondsLeft());}. Run it before you touch {@code Countdown.java}: it fails with {@code expected:<60> but was:<58>}.
 * 2. Once {@code tick} has changed {@code seconds}, the starting value is gone, so the countdown needs a second instance variable, say {@code start}, set in the constructor. Then {@code reset()} is {@code this.seconds = this.start;}.
 */
public class CountdownTest {
    @Test
    public void startsWithItsSeconds() {
        Countdown countdown = new Countdown(90);
        assertEquals(90, countdown.secondsLeft());
    }

    @Test
    public void tickTakesOneSecond() {
        Countdown countdown = new Countdown(90);
        countdown.tick();
        assertEquals(89, countdown.secondsLeft());
    }

    @Test
    public void stopsAtZero() {
        Countdown countdown = new Countdown(1);
        countdown.tick();
        countdown.tick();
        assertEquals(0, countdown.secondsLeft());
    }
}
