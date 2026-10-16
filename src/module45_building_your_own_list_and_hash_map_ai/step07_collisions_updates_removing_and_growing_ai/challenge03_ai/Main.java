// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step07_collisions_updates_removing_and_growing_ai.challenge03_ai;

public class Main {
    /**
     * {@code SimpleMap.java} has everything from this step except the body of {@code grow}, so the map never gets more than its 8 buckets. {@code put} already calls {@code grow} when the size goes above 0.75 times the number of buckets. Write {@code grow}: it makes the array of buckets twice as long, with an empty list in each place, and puts every pair into its bucket in the new array. The check runs:
     * <pre>{@code
     * SimpleMap<Integer, String> map = new SimpleMap<>();
     * for (int i = 1; i <= 7; i++) {
     *     map.put(i * 5, "value " + i);
     * }
     * System.out.println(map.size() + " keys in " + map.bucketCount() + " buckets");
     * System.out.println(map.get(5) + ", " + map.get(10) + ", " + map.get(35) + ", " + map.get(40));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 7 keys in 16 buckets
     * value 1, value 2, value 7, null
     * }</pre>
     * Hints
     * 1. Keep the old array in a variable, {@code ArrayList<KeyValue<K, V>>[] old = this.buckets;}, then set {@code this.buckets = new ArrayList[old.length * 2];} and fill it with empty lists, as the constructor does.
     * 2. Then go through every bucket of {@code old}, and every pair in it, and add the pair to {@code bucketFor(pair.getKey())}. That picks its bucket in the new array, since {@code bucketFor} divides by {@code this.buckets.length}. Copying old bucket 2 to new bucket 2 would lose keys: 10 % 8 is 2, but 10 % 16 is 10.
     */
    public static void main(String[] args) {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        for (int i = 1; i <= 7; i++) {
            map.put(i * 5, "value " + i);
        }
        System.out.println(map.size() + " keys in " + map.bucketCount() + " buckets");
        System.out.println(map.get(5) + ", " + map.get(10) + ", " + map.get(35) + ", " + map.get(40));
    }
}
