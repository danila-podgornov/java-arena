// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge03_ai;

import java.util.ArrayList;

public class PracticeRound {
    private CardBox box;
    private int next;
    private int right;
    private int wrong;
    private ArrayList<String> missed;

    public PracticeRound(CardBox box) {
        this.box = box;
        this.missed = new ArrayList<>();
    }

    public String question() {
        if (this.box.size() == 0) {
            return null;
        }
        return this.box.countryAt(this.next);
    }

    public boolean answer(String text) {
        String country = this.question();
        if (country == null) {
            return false;
        }
        boolean correct = text.trim().equalsIgnoreCase(this.box.capitalOf(country));
        if (correct) {
            this.right++;
        } else {
            this.wrong++;
            if (!this.missed.contains(country)) {
                this.missed.add(country);
            }
        }
        this.next++;
        if (this.next >= this.box.size()) {
            this.next = 0;
        }
        return correct;
    }

    public int getRight() {
        return this.right;
    }

    public int getWrong() {
        return this.wrong;
    }

    public ArrayList<String> missed() {
        return this.missed;
    }
}
