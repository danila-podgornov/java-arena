// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step03_unit_tests_with_junit_ai.challenge02_ai;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A shopping cart adds up the prices of its products, in cents. Someone rewrote its {@code total()} with an index loop, and one version they tried skips the first product. {@code CartTest} has one test, but it can't tell the versions apart: an empty cart costs 0 either way.
 * <p>Write a second test: put a few products with different prices in a cart, and check {@code total()} with {@code assertEquals}. Your tests should pass on the Cart as it is, and fail on the version that skips the first product.
 * Hints
 * 1. A new test is a new method with {@code @Test} before it: {@code @Test public void totalAddsUpEveryPrice() { ... }}. In it, make a Cart, {@code add} a few prices, and check the total.
 * 2. For example {@code cart.add(250);}, {@code cart.add(400);} and {@code cart.add(99);}, then {@code assertEquals(749, cart.total());}. Different prices matter: with the same price twice, some wrong totals would still come out right.
 */
public class CartTest {
    @Test
    public void emptyCartCostsNothing() {
        Cart cart = new Cart();
        assertEquals(0, cart.total());
    }
}
