// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step02_extends_a_class_built_on_another_ai.challenge02_ai;

public class Main {
    /**
     * {@code Drum} and {@code Violin} both extend {@code Instrument}, which has a {@code toString} of its own. What does this program print?
     * Hints
     * 1. Drum has no {@code toString} of its own, so it inherits Instrument's, and {@code println(drum)} uses that one, not Object's.
     * 2. Each Drum object has its own minutes and its own broken sticks: {@code spare} was played only once, and it broke nothing. {@code getClass().getName()} gives the class the object was made from.
     */
    public static void main(String[] args) {
        Drum drum = new Drum();
        Drum spare = new Drum();
        drum.practice(20);
        drum.practice(25);
        spare.practice(5);
        drum.breakStick();
        System.out.println(drum);
        System.out.println(spare.getMinutesPlayed() + " " + spare.getSticksBroken());
        System.out.println(drum.getClass().getName());
    }
}
