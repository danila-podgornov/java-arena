// AI-Generated
package module24_lists_inside_objects_ai.step02_a_list_as_an_instance_variable_ai.challenge03_ai;

public class Main {
    /**
     * This program crashes with a NullPointerException. Read the message, find the cause and fix it in {@code Choir.java}. Then add a method {@code isEmpty()} to Choir: it returns {@code true} when nobody has joined the choir yet. {@code Main.java} is ready, and when both are done it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * 2
     * }</pre>
     * Hints
     * 1. The message says {@code this.singers} is null: the constructor never makes the list. Add {@code this.singers = new ArrayList<>();} to it.
     * 2. {@code isEmpty} can ask the list: {@code public boolean isEmpty() { return this.singers.isEmpty(); }}. {@code this.singers.size() == 0} works too.
     */
    public static void main(String[] args) {
        Choir choir = new Choir("Harbor Voices");
        System.out.println(choir.isEmpty());
        choir.join("Mira");
        choir.join("Tom");
        System.out.println(choir.isEmpty());
        System.out.println(choir.size());
    }
}
