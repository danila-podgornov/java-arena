// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step02_getters_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? Watch what changes the pencil and what doesn't.
     * Hints
     * 1. {@code getLength()} returns the value 20, and {@code main} stores it in a variable of its own. Changing that variable doesn't touch the pencil.
     * 2. {@code sharpen(30)} takes {@code 30 / 10}, which is 3, off the pencil's own length.
     */
    public static void main(String[] args) {
        Pencil pencil = new Pencil(20);
        int length = pencil.getLength();
        length = length - 5;
        System.out.println(length);
        System.out.println(pencil.getLength());
        pencil.sharpen(30);
        System.out.println(pencil.getLength());
    }
}
