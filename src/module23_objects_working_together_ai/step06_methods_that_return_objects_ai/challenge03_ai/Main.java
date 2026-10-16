// AI-Generated
package module23_objects_working_together_ai.step06_methods_that_return_objects_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? A cutting is a small piece taken from a plant to grow a new one.
     * Hints
     * 1. {@code same = mother} copies the reference: {@code same} and {@code mother} are one plant, so {@code same.grow(10)} makes it 30 cm.
     * 2. {@code cutting()} makes a new, separate Plant of 5 cm each time it's called. {@code young} then grows 3 cm on its own, and the last line prints a brand-new cutting.
     */
    public static void main(String[] args) {
        Plant mother = new Plant("mint", 20);
        Plant same = mother;
        Plant young = mother.cutting();
        same.grow(10);
        young.grow(3);
        System.out.println(mother);
        System.out.println(young);
        System.out.println(mother.cutting());
    }
}
