// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step06_a_hash_map_of_your_own_ai.challenge01_ai;

public class Main {
    /**
     * {@code SimpleMap.java} is the map from this step, without its {@code get}. Write {@code get(K key)}: it returns the value of the key, or {@code null} when the map doesn't have the key. Look only in the key's own bucket. The check runs:
     * <pre>{@code
     * SimpleMap<String, Integer> extensions = new SimpleMap<>();
     * extensions.put("Amara", 214);
     * extensions.put("Bo", 102);
     * extensions.put("Carmen", 305);
     * System.out.println(extensions.get("Bo"));
     * System.out.println(extensions.get("Frank"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 102
     * null
     * }</pre>
     * Hints
     * 1. {@code bucketFor(key)} gives the key's bucket, a list of KeyValue pairs. Go through it with {@code for (KeyValue<K, V> pair : bucketFor(key))}.
     * 2. Compare with {@code pair.getKey().equals(key)}, and return {@code pair.getValue()} when they're equal. After the loop, return {@code null}.
     */
    public static void main(String[] args) {
        SimpleMap<String, Integer> extensions = new SimpleMap<>();
        extensions.put("Amara", 214);
        extensions.put("Bo", 102);
        extensions.put("Carmen", 305);
        System.out.println(extensions.get("Bo"));
        System.out.println(extensions.get("Frank"));
    }
}
