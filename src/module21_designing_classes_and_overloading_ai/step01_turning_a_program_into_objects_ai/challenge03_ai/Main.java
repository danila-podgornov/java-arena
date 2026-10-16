// AI-Generated
package module21_designing_classes_and_overloading_ai.step01_turning_a_program_into_objects_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? It uses the {@code Hero} class from the first challenge, with two heroes.
     * Hints
     * 1. Follow each hero on their own. Aria goes from 100 to 60, and then a hit of 80 would take her below 0.
     * 2. Bram goes from 100 to 30, and healing 50 takes him to 80, which is still under the limit of 100.
     */
    public static void main(String[] args) {
        Hero aria = new Hero("Aria");
        Hero bram = new Hero("Bram");
        aria.hit(40);
        bram.hit(70);
        bram.heal(50);
        aria.hit(80);
        aria.heal(10);
        System.out.println(aria);
        System.out.println(bram);
    }
}
