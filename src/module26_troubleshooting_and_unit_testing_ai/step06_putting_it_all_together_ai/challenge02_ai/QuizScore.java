// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge02_ai;

/**
 * A quiz gives 10 points for a right answer and nothing for a wrong one. Three right answers in a row give 5 bonus points, and then the count starts over. A wrong answer ends the streak. {@code QuizScoreTest} is right, but two of its tests fail on {@code QuizScore}.
 * <p>Run the tests and read the report: each failing test's name says which rule is broken. Fix {@code QuizScore} one bug at a time, running the tests after each fix. The checks run the tests of {@code QuizScoreTest} as they are given here (changing them won't help), and more tests of their own.
 * Hints
 * 1. {@code threeInARowGiveABonus} says {@code expected:<35> but was:<30>}: no bonus after three right answers. Look at the comparison that decides when the bonus comes: {@code this.streak > 3} is only true on the fourth.
 * 2. {@code wrongAnswerEndsTheStreak} fails because nothing happens to {@code streak} on a wrong answer. Use {@code this.streak == 3} for the bonus, and add {@code else { this.streak = 0; }} to the {@code if (correct)}.
 */
public class QuizScore {
    private int points;
    private int streak;

    public QuizScore() {
        this.points = 0;
        this.streak = 0;
    }

    public void answer(boolean correct) {
        if (correct) {
            this.points += 10;
            this.streak++;
            if (this.streak > 3) {
                this.points += 5;
                this.streak = 0;
            }
        }
    }

    public int getPoints() {
        return this.points;
    }
}
