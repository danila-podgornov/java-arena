// AI-Generated
package module50_gui_multiple_views_ai.step06_a_practice_app_part_1_the_logic_ai.challenge01_ai;

public class Main {
    /**
     * Write the class {@code PracticeRound} in {@code PracticeRound.java}. {@code CardBox} is ready.
     * <ul>
     * <li>a constructor {@code PracticeRound(CardBox box)}
     * <li>{@code question()}: returns the country of the card whose turn it is, or {@code null} when the box is empty
     * <li>{@code answer(String text)}: when the box is empty, returns {@code false} and counts nothing. Otherwise the answer is right when {@code text}, trimmed, is the capital of the card whose turn it is, ignoring upper and lower case ({@code equalsIgnoreCase}). It counts the answer as right or wrong, moves the turn to the next card (after the last card, back to the first), and returns {@code true} for a right answer, {@code false} for a wrong one.
     * <li>{@code getRight()} and {@code getWrong()}: the numbers of right and wrong answers so far
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * CardBox box = new CardBox();
     * box.add("Peru", "Lima");
     * box.add("Kenya", "Nairobi");
     * PracticeRound round = new PracticeRound(box);
     * System.out.println(round.question());
     * System.out.println(round.answer(" lima"));
     * System.out.println(round.question());
     * System.out.println(round.answer("Mombasa"));
     * System.out.println(round.question() + " " + round.getRight() + " " + round.getWrong());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Peru
     * true
     * Kenya
     * false
     * Peru 1 1
     * }</pre>
     * Hints
     * 1. Four instance variables: the box, {@code next} (the index of the card whose turn it is), and the two counts. {@code question()} returns {@code null} when {@code this.box.size() == 0}, and otherwise {@code this.box.countryAt(this.next)}.
     * 2. In {@code answer}, get the country with {@code question()} first and return {@code false} if it's {@code null}. Compare with {@code text.trim().equalsIgnoreCase(this.box.capitalOf(country))}, add to the right count, add one to {@code next}, and set {@code next} back to 0 when it reaches {@code this.box.size()}.
     */
    public static void main(String[] args) {
        CardBox box = new CardBox();
        box.add("Peru", "Lima");
        box.add("Kenya", "Nairobi");
        PracticeRound round = new PracticeRound(box);
        System.out.println(round.question());
        System.out.println(round.answer(" lima"));
        System.out.println(round.question());
        System.out.println(round.answer("Mombasa"));
        System.out.println(round.question() + " " + round.getRight() + " " + round.getWrong());
    }
}
