// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step07_collisions_updates_removing_and_growing_ai.challenge02_ai;

public class Main {
    /**
     * An office mailroom's map from pigeonhole numbers to the people who use them is the SimpleMap of this step, with one change: its constructor takes the number of buckets to start with. An Integer's hash code is its own value. What does this program print?
     * Hints
     * 1. With 4 buckets, the map grows when the size goes above 0.75 * 4 = 3. Three people don't make it grow; the fourth does, and then there are 8 buckets.
     * 2. Putting pigeonhole 12 again changes the person in it but not the size. {@code remove} returns the removed value, or {@code null} for a pigeonhole that isn't in the map.
     */
    public static void main(String[] args) {
        SimpleMap<Integer, String> pigeonholes = new SimpleMap<>(4);
        pigeonholes.put(11, "Kenji");
        pigeonholes.put(12, "Marisol");
        pigeonholes.put(13, "Olu");
        System.out.println(pigeonholes.size() + " " + pigeonholes.bucketCount());
        pigeonholes.put(14, "Farida");
        System.out.println(pigeonholes.size() + " " + pigeonholes.bucketCount());
        pigeonholes.put(12, "Rasmus");
        System.out.println(pigeonholes.size() + " " + pigeonholes.get(12));
        System.out.println(pigeonholes.remove(13) + " " + pigeonholes.remove(15) + " " + pigeonholes.size());
    }
}
