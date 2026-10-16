// AI-Generated
package module50_gui_multiple_views_ai.step06_a_practice_app_part_1_the_logic_ai.challenge02_ai;

public class PracticeRound {
    private CardBox box;
    private int next;
    private int right;
    private int wrong;

    public PracticeRound(CardBox box) {
        this.box = box;
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
}
