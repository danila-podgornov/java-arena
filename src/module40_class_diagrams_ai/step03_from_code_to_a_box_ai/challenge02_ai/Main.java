// AI-Generated
package module40_class_diagrams_ai.step03_from_code_to_a_box_ai.challenge02_ai;

public class Main {
    /**
     * Another team wrote a compactor too. Its box is exactly the same as the one in the lesson, but it's a different class: this {@code load} refuses a load that would take the compactor over 150 cans, and this {@code press} makes at most one block per call and returns the number of cans it pressed. What does this program print?
     * Hints
     * 1. The first load of 90 fits. The second would make 180 cans, over 150, so {@code load} refuses it and the compactor keeps 90.
     * 2. Each {@code press} makes one block of 40 cans and returns 40: 90 cans become 50, then 10. The same box as the lesson's class, and different answers.
     */
    public static void main(String[] args) {
        Compactor compactor = new Compactor(40);
        compactor.load(90);
        compactor.load(90);
        System.out.println(compactor.press());
        System.out.println(compactor.press());
        System.out.println(compactor);
    }
}
