// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step05_calling_the_objects_own_methods_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? Follow each call into the class and back out.
     * Hints
     * 1. {@code hopMany(2)} calls {@code hop()} twice, and each {@code hop()} prints the new count. Only after the loop does {@code hopMany} print its own line.
     * 2. {@code main} then calls {@code hop()} directly, which makes it 3 hops.
     */
    public static void main(String[] args) {
        Frog frog = new Frog();
        frog.hopMany(2);
        frog.hop();
        System.out.println(frog.getHops());
    }
}
