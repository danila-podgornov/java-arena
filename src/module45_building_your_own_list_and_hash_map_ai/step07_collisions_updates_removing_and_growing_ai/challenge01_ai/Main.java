// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step07_collisions_updates_removing_and_growing_ai.challenge01_ai;

public class Main {
    /**
     * A parking office keeps its permits in a SimpleMap, from a car's plate to the holder's name. Java's HashMap's {@code put} returns the value the key had before, or {@code null} for a new key, so a program can tell a renewal from a new permit. {@code SimpleMap.java} has step 6's {@code put}, which returns nothing. Rewrite it to return a {@code V}:
     * <ul>
     * <li>when the key is in its bucket already, give its pair the new value, and return the old one
     * <li>otherwise, add a new pair, count it, and return {@code null}
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * SimpleMap<String, String> permits = new SimpleMap<>();
     * System.out.println(permits.put("KX-482", "Ines"));
     * System.out.println(permits.put("BT-907", "Theo"));
     * System.out.println(permits.put("KX-482", "Rafael"));
     * System.out.println(permits.get("KX-482") + ", " + permits.size() + " permits");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * null
     * null
     * Ines
     * Rafael, 2 permits
     * }</pre>
     * Hints
     * 1. The header becomes {@code public V put(K key, V value)}. Go through {@code bucketFor(key)} first, as the lesson's {@code put} does.
     * 2. When a pair's key equals the key, keep {@code pair.getValue()} in a variable {@code V old}, call {@code pair.setValue(value)}, and {@code return old;}. After the loop, add the new pair, count it, and {@code return null;}.
     */
    public static void main(String[] args) {
        SimpleMap<String, String> permits = new SimpleMap<>();
        System.out.println(permits.put("KX-482", "Ines"));
        System.out.println(permits.put("BT-907", "Theo"));
        System.out.println(permits.put("KX-482", "Rafael"));
        System.out.println(permits.get("KX-482") + ", " + permits.size() + " permits");
    }
}
