// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge03_ai;

public class Elevator {
    private int topFloor;
    private int floor;

    public Elevator(int topFloor) {
        this.topFloor = topFloor;
        this.floor = 0;
    }

    public boolean goTo(int target) {
        if (target < 0 || target > this.topFloor) {
            return false;
        }
        this.floor = target;
        return true;
    }

    public int getFloor() {
        return this.floor;
    }
}
