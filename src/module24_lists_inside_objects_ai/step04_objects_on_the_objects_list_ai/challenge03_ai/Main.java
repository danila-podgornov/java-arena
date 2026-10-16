// AI-Generated
package module24_lists_inside_objects_ai.step04_objects_on_the_objects_list_ai.challenge03_ai;

public class Main {
    /**
     * An orchestra keeps a list of its musicians. {@code Musician.java} is ready: a musician has a name and an instrument, with the getters {@code getName()} and {@code getInstrument()}. {@code Orchestra.java} has the list. Write two methods in it:
     * <ul>
     * <li>{@code hire(String name, String instrument)} makes a new Musician of those values and adds it to the list.
     * <li>{@code count(String instrument)} returns how many musicians play that instrument.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Orchestra orchestra = new Orchestra();
     * orchestra.hire("Ines", "violin");
     * orchestra.hire("Karl", "cello");
     * orchestra.hire("Lena", "violin");
     * System.out.println(orchestra.count("violin"));
     * System.out.println(orchestra.count("flute"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2
     * 0
     * }</pre>
     * Hints
     * 1. {@code hire} makes the object and adds it in one line: {@code this.musicians.add(new Musician(name, instrument));}.
     * 2. {@code count} goes through {@code this.musicians} and adds one to a counter when {@code musician.getInstrument().equals(instrument)}. It returns the counter after the loop.
     */
    public static void main(String[] args) {
        Orchestra orchestra = new Orchestra();
        orchestra.hire("Ines", "violin");
        orchestra.hire("Karl", "cello");
        orchestra.hire("Lena", "violin");
        System.out.println(orchestra.count("violin"));
        System.out.println(orchestra.count("flute"));
    }
}
