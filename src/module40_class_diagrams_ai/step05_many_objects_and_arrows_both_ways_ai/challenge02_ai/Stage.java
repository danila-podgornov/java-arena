// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge02_ai;

import java.util.ArrayList;

public class Stage {
    private String name;
    private ArrayList<Act> acts;

    public Stage(String name) {
        this.name = name;
        this.acts = new ArrayList<>();
    }

    public void add(Act act) {
        this.acts.add(act);
        act.setStage(this);
    }

    public String getName() {
        return this.name;
    }

    public int count() {
        return this.acts.size();
    }
}
