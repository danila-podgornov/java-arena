// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge02_ai.cowork.logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * In a real project, a class's tests are in the same package as the class, so they can test its package-private methods too. Here the test class is simply one more file in the package's folder.
 * <p>{@code DeskFee.java}, in the package {@code cowork.logic}, works out what a desk in a coworking space costs. {@code price(int minutes)} is public, and it uses the package-private helper {@code startedHours(int minutes)}, which counts every hour that has started: 1 to 60 minutes is 1 hour, 61 to 120 minutes are 2 hours, and so on. The price is the started hours times the price of an hour, but never more than the daily maximum.
 * <p>{@code DeskFeeTest.java} is in the same package and has one test. Add two more, with {@code assertEquals}:
 * <ul>
 * <li>a test of {@code startedHours}: 1 minute is 1 hour, 60 minutes are 1 hour, and 61 minutes are 2 hours
 * <li>a test of the daily maximum: with 4 dollars an hour and a maximum of 25 dollars, 600 minutes cost 25 dollars
 * </ul>
 * <p>The checks run your tests on the DeskFee as it is, where every test should pass, and on versions of DeskFee with a bug, where at least one of your tests should fail.
 * Hints
 * 1. Copy the shape of {@code priceIsPerStartedHour}: {@code @Test}, then {@code public void} and a name that says what the test checks. DeskFeeTest is in {@code cowork.logic} too, so it may call {@code fee.startedHours(61)} although the method isn't public.
 * 2. One test has three lines like {@code assertEquals(2, fee.startedHours(61));}, with the expected value first. The other makes {@code new DeskFee(4, 25)} and checks {@code assertEquals(25, fee.price(600));}.
 */
public class DeskFeeTest {
    @Test
    public void priceIsPerStartedHour() {
        DeskFee fee = new DeskFee(4, 25);
        assertEquals(8, fee.price(90));
    }

    // Write the tests of startedHours and of the daily maximum here.
}
