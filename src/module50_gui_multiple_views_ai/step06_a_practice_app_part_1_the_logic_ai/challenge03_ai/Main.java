// AI-Generated
package module50_gui_multiple_views_ai.step06_a_practice_app_part_1_the_logic_ai.challenge03_ai;

public class Main {
    /**
     * The card box and the round together, with a card added in the middle of the training. What does the program print? {@code CardBox} is the class of this step's text, and {@code PracticeRound} the one from the first task.
     * Hints
     * 1. After two answers the turn has gone past Ghana, the last card at that time, so it's back at Spain. Adding Spain a second time is refused, so Spain's capital is still Madrid; Cuba joins the box as its third card.
     * 2. {@code answer} trims the text and ignores upper and lower case, so {@code " MADRID "} is right. Then the turn moves to Ghana, and after the answer about Ghana to Cuba.
     */
    public static void main(String[] args) {
        CardBox box = new CardBox();
        box.add("Spain", "Madrid");
        box.add("Ghana", "Accra");
        PracticeRound round = new PracticeRound(box);
        System.out.println(round.answer("Barcelona") + " " + round.question());
        round.answer("accra");
        box.add("Spain", "Seville");
        box.add("Cuba", "Havana");
        System.out.println(round.answer(" MADRID ") + " " + round.question());
        round.answer("Havana");
        System.out.println(round.question() + " " + round.getRight() + " " + round.getWrong());
    }
}
