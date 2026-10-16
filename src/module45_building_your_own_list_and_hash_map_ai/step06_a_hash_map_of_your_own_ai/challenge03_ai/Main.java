// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step06_a_hash_map_of_your_own_ai.challenge03_ai;

public class Main {
    /**
     * Two more methods for {@code SimpleMap.java}, like HashMap's:
     * <ul>
     * <li>{@code containsKey(K key)}, which returns {@code true} if the map has the key. A key's value may be {@code null}, so look for the key itself, not its value.
     * <li>{@code keys()}, which returns a new {@code ArrayList<K>} with all the keys, bucket by bucket: first the keys in bucket 0, in the order they were put there, then the keys in bucket 1, and so on.
     * </ul>
     * <p>That's also why Java's HashMap lists its keys in an order that looks random: it goes through its buckets too. The check runs:
     * <pre>{@code
     * SimpleMap<String, Integer> extensions = new SimpleMap<>();
     * String[] names = {"Amara", "Bo", "Carmen", "Dev", "Elif"};
     * for (int i = 0; i < names.length; i++) {
     *     extensions.put(names[i], 100 + i);
     * }
     * System.out.println(extensions.keys());
     * System.out.println(extensions.containsKey("Elif") + " " + extensions.containsKey("Frank"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Carmen, Amara, Elif, Bo, Dev]
     * true false
     * }</pre>
     * Hints
     * 1. {@code containsKey} looks in the key's own bucket, like {@code get}, and returns {@code true} when a pair's key equals the key. Why not {@code return get(key) != null;}? It would say {@code false} for a key whose value is {@code null}.
     * 2. {@code keys()} needs two loops: one over the buckets, {@code for (ArrayList<KeyValue<K, V>> bucket : this.buckets)}, and inside it one over the pairs of that bucket, adding each {@code pair.getKey()} to a new {@code ArrayList<K>}.
     */
    public static void main(String[] args) {
        SimpleMap<String, Integer> extensions = new SimpleMap<>();
        String[] names = {"Amara", "Bo", "Carmen", "Dev", "Elif"};
        for (int i = 0; i < names.length; i++) {
            extensions.put(names[i], 100 + i);
        }
        System.out.println(extensions.keys());
        System.out.println(extensions.containsKey("Elif") + " " + extensions.containsKey("Frank"));
    }
}
