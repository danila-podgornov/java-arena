// AI-Generated
package module52_drawing_images_and_sound_ai.step07_sound_and_the_end_of_section_14_2_ai.challenge01_ai;

public class Buzzer {
    private int wrongInARow;

    public String clipFor(boolean correct) {
        if (correct) {
            this.wrongInARow = 0;
            return "right.wav";
        }
        this.wrongInARow++;
        if (this.wrongInARow == 3) {
            this.wrongInARow = 0;
            return "out.wav";
        }
        return "wrong.wav";
    }
}
