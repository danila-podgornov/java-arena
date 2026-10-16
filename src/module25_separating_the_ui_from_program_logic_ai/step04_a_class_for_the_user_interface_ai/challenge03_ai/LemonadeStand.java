// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge03_ai;

public class LemonadeStand {
    private int cups;
    private int sold;

    public LemonadeStand(int cups) {
        this.cups = cups;
        this.sold = 0;
    }

    public boolean sell(int count) {
        if (count > this.cups) {
            return false;
        }
        this.cups = this.cups - count;
        this.sold = this.sold + count;
        return true;
    }

    public int cupsLeft() {
        return this.cups;
    }

    public int cupsSold() {
        return this.sold;
    }
}
