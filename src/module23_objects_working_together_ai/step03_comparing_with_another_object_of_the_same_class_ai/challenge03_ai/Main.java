// AI-Generated
package module23_objects_working_together_ai.step03_comparing_with_another_object_of_the_same_class_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? A racer beats another one with a smaller time, and the loop keeps the best racer so far.
     * Hints
     * 1. The winner starts as Joe (61 s). Ida's 58 beats it, so Ida becomes the winner. Kai's 58 doesn't beat Ida's 58: {@code <} is false for equal times. Liv's 60 doesn't either.
     * 2. The last line asks whether the winner, Ida, beats {@code racers.get(2)}, which is Kai. Both have 58 seconds.
     */
    public static void main(String[] args) {
        ArrayList<Racer> racers = new ArrayList<>();
        racers.add(new Racer("Joe", 61));
        racers.add(new Racer("Ida", 58));
        racers.add(new Racer("Kai", 58));
        racers.add(new Racer("Liv", 60));

        Racer winner = racers.get(0);
        for (Racer racer : racers) {
            if (racer.beats(winner)) {
                winner = racer;
            }
        }
        System.out.println(winner);
        System.out.println(winner.beats(racers.get(2)));
    }
}
