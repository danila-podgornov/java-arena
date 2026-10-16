// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge01_ai;

public class WaterLog {
    private int goal;
    private int total;

    public WaterLog(int goal) {
        this.goal = goal;
        this.total = 0;
    }

    public void drink(int ml) {
        this.total = this.total + ml;
    }

    public int total() {
        return this.total;
    }
}
