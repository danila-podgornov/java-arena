// AI-Generated
package module31_hash_maps_ai.step04_a_hash_map_inside_a_class_ai.challenge03_ai;

public class Main {
    /**
     * A museum's audio guide keeps two maps with the same keys, the stop numbers: one for the title of each stop, and one for how many times each stop has been played. Write the class {@code AudioGuide}:
     * <ul>
     * <li>The constructor creates both maps.
     * <li>{@code addStop(int number, String title)} adds a stop.
     * <li>{@code play(int number)} returns the stop's title and counts one more play of the stop. For a number with no stop, it returns {@code No stop } and the number, and counts nothing.
     * <li>{@code playsOf(int number)} returns how many times the stop has been played: 0 for a stop that hasn't been played yet, and for a number with no stop.
     * </ul>
     * <p>The test drive in {@code Main.java} prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bronze Horse
     * Bronze Horse
     * No stop 72
     * 2 0 0
     * }</pre>
     * Hints
     * 1. In the constructor, create both maps with {@code new HashMap<>()}. {@code addStop} puts the title in {@code this.titles}, under the number.
     * 2. In {@code play}, check {@code this.titles.containsKey(number)} first, and return the message when the stop is missing. Otherwise count the play the way {@code record} does above, {@code this.plays.put(number, this.plays.getOrDefault(number, 0) + 1);}, and return the title. {@code playsOf} is a {@code getOrDefault} with 0.
     */
    public static void main(String[] args) {
        AudioGuide guide = new AudioGuide();
        guide.addStop(12, "The Harbor at Dawn");
        guide.addStop(27, "Bronze Horse");
        System.out.println(guide.play(27));
        System.out.println(guide.play(27));
        System.out.println(guide.play(72));
        System.out.println(guide.playsOf(27) + " " + guide.playsOf(12) + " " + guide.playsOf(72));
    }
}
