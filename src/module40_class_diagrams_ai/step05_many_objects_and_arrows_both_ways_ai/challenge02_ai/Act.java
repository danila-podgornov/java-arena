// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge02_ai;

public class Act {
    private String name;
    private int minutes;
    private Stage stage;

    public Act(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
        this.stage = null;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        if (this.stage == null) {
            return this.name + ", " + this.minutes + " min, no stage yet";
        }
        return this.name + ", " + this.minutes + " min, " + this.stage.getName();
    }
}
