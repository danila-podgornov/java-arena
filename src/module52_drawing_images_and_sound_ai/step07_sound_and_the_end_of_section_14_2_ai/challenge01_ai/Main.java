// AI-Generated
package module52_drawing_images_and_sound_ai.step07_sound_and_the_end_of_section_14_2_ai.challenge01_ai;

public class Main {
    /**
     * The quiz buzzer from above gets seven answers. What does this program print?
     * Hints
     * 1. A right answer sets the count of wrong answers in a row back to 0. So after the first {@code true}, the count starts over.
     * 2. Count the wrong answers after the {@code true}: the third one in a row plays {@code out.wav} and sets the count to 0, so the fourth is an ordinary wrong answer again.
     */
    public static void main(String[] args) {
        Buzzer buzzer = new Buzzer();
        boolean[] answers = {false, false, true, false, false, false, false};
        for (boolean answer : answers) {
            System.out.println(buzzer.clipFor(answer));
        }
    }
}
