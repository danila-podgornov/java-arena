// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step02_the_same_program_with_objects_ai.challenge03_ai;

public class TurnTimer {
    private int seconds;

    public TurnTimer(int seconds) {
        this.seconds = seconds;
    }

    public void tick(int passed) {
        this.seconds = this.seconds - passed;
        if (this.seconds < 0) {
            this.seconds = 0;
        }
    }

    public boolean isOver() {
        return this.seconds == 0;
    }

    public int getSeconds() {
        return this.seconds;
    }
}
