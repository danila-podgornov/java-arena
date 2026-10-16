// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge01_ai;

import java.util.ArrayList;

public class TipJar {
    private ArrayList<Integer> tips;

    public TipJar() {
        this.tips = new ArrayList<>();
    }

    public void add(int cents) {
        this.tips.add(cents);
    }

    public int count() {
        return this.tips.size();
    }

    public int total() {
        int sum = 0;
        for (int tip : this.tips) {
            sum = sum + tip;
        }
        return sum;
    }

    public int biggest() {
        int biggest = 0;
        for (int tip : this.tips) {
            if (tip > biggest) {
                biggest = tip;
            }
        }
        return biggest;
    }
}
