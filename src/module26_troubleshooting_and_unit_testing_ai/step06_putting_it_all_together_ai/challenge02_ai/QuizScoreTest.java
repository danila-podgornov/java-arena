// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge02_ai;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuizScoreTest {
    private QuizScore score;

    @Before
    public void setUp() {
        this.score = new QuizScore();
    }

    @Test
    public void rightAnswerGivesTenPoints() {
        this.score.answer(true);
        assertEquals(10, this.score.getPoints());
    }

    @Test
    public void wrongAnswerGivesNothing() {
        this.score.answer(false);
        assertEquals(0, this.score.getPoints());
    }

    @Test
    public void threeInARowGiveABonus() {
        this.score.answer(true);
        this.score.answer(true);
        this.score.answer(true);
        assertEquals(35, this.score.getPoints());
    }

    @Test
    public void wrongAnswerEndsTheStreak() {
        this.score.answer(true);
        this.score.answer(true);
        this.score.answer(false);
        this.score.answer(true);
        this.score.answer(true);
        assertEquals(40, this.score.getPoints());
    }
}
