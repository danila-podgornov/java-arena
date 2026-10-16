// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge02_ai;

import java.util.ArrayList;

public class CakeCounter {
    private ArrayList<Cake> cakes;

    public CakeCounter() {
        this.cakes = new ArrayList<>();
    }

    public void add(Cake cake) {
        this.cakes.add(cake);
    }

    public Cake find(String name) {
        for (Cake cake : this.cakes) {
            if (cake.getName().equals(name)) {
                return cake;
            }
        }
        return null;
    }

    public ArrayList<Cake> cakes() {
        return this.cakes;
    }
}
