// AI-Generated
package module50_gui_multiple_views_ai.step06_a_practice_app_part_1_the_logic_ai.challenge02_ai;

public class Main {
    /**
     * A trainer should help with the capitals that went wrong. Add a method {@code missed()} to {@code PracticeRound} (the class from the first task): it returns an {@code ArrayList<String>} of the countries whose capital was answered wrong, each country once, in the order of their first wrong answer. A country stays on the list even when it's answered right later. With an empty box, {@code answer} counts nothing, so nothing is added to the list either. The check runs:
     * <pre>{@code
     * CardBox box = new CardBox();
     * box.add("Peru", "Lima");
     * box.add("Kenya", "Nairobi");
     * PracticeRound round = new PracticeRound(box);
     * round.answer("Cusco");
     * round.answer("Nairobi");
     * round.answer("Arequipa");
     * System.out.println(round.missed());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Peru]}
     * Hints
     * 1. Add an instance variable {@code private ArrayList<String> missed;}, create the list in the constructor, and import {@code java.util.ArrayList}.
     * 2. In {@code answer}, in the branch of a wrong answer, add the country only {@code if (!this.missed.contains(country))}. {@code missed()} returns the list.
     */
    public static void main(String[] args) {
        CardBox box = new CardBox();
        box.add("Peru", "Lima");
        box.add("Kenya", "Nairobi");
        PracticeRound round = new PracticeRound(box);
        round.answer("Cusco");
        round.answer("Nairobi");
        round.answer("Arequipa");
        System.out.println(round.missed());
    }
}
