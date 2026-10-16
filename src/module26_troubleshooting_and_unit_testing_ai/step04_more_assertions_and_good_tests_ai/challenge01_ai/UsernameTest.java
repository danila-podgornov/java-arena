// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge01_ai;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A sign-up form accepts a username of 3 to 12 characters, with no spaces, and {@code Username} checks it with {@code isValid()}. {@code UsernameTest} has one test, for an ordinary name. Write more tests with {@code assertTrue} and {@code assertFalse}, so they catch a mistake at either limit, and a forgotten rule. The checks run your tests on the Username as it is, where all of them should pass, and on three versions with a bug, where at least one should fail. One of them is shown: a Username that turns away names of exactly 3 characters.
 * Hints
 * 1. Test each limit from both sides: a name of exactly 3 characters (valid) and one of 2 (too short), a name of exactly 12 (valid) and one of 13 (too long). Then a name with a space in it.
 * 2. For example {@code assertTrue(new Username("ada").isValid());} and {@code assertFalse(new Username("al").isValid());}, each in a test of its own, with a name such as {@code threeCharactersIsLongEnough}. Count the characters of your long names carefully.
 */
public class UsernameTest {
    @Test
    public void ordinaryNameIsValid() {
        assertTrue(new Username("robin").isValid());
    }
}
