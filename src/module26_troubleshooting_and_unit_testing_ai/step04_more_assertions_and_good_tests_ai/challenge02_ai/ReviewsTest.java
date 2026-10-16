// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge02_ai;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Reviews on a recipe site give 1 to 5 stars, and anything else is ignored. {@code average()} returns the average of the stars, and 0.0 when there are none. {@code ReviewsTest} has one test, which passes even on the broken versions.
 * <p>Write tests that catch a version whose average drops the decimals (giving 4.0 for the stars 4 and 5, instead of 4.5), and two hidden versions with other bugs. Think about the edges: no reviews at all, and stars just outside 1 to 5, 0 and 6. Compare doubles with a delta, as in {@code assertEquals(4.5, reviews.average(), 0.001)}.
 * Hints
 * 1. One test with stars whose average isn't a whole number, like 4 and 5. One with no reviews at all. And one that adds stars outside 1 to 5, such as 0 and 6, next to a normal one, and checks {@code count()} or the average.
 * 2. For example: {@code reviews.add(4); reviews.add(5);} and then {@code assertEquals(4.5, reviews.average(), 0.001);}. With no reviews, {@code assertEquals(0.0, reviews.average(), 0.001);}.
 */
public class ReviewsTest {
    @Test
    public void oneReviewIsItsOwnAverage() {
        Reviews reviews = new Reviews();
        reviews.add(4);
        assertEquals(4.0, reviews.average(), 0.001);
    }
}
