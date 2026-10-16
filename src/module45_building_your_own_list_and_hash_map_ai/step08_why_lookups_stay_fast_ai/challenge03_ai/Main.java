// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step08_why_lookups_stay_fast_ai.challenge03_ai;

public class Main {
    /**
     * To end the module: Java's HashSet keeps each value once, and finds it fast. Build your own, the way SimpleMap works, only with values and no pairs. A word game uses it for the words already played: each word may be played only once.
     * <p>In {@code SimpleSet.java}, write the generic class {@code SimpleSet<T>}, with an array of buckets that are {@code ArrayList<T>} lists:
     * <ul>
     * <li>a constructor with no parameters: 8 buckets, each an empty list
     * <li>{@code add(T value)}: if the set has the value already, it returns {@code false} and changes nothing. Otherwise it puts the value in its bucket and returns {@code true}. After adding, when the size is more than 0.75 times the number of buckets, the buckets become twice as many, with every value put again in its new bucket.
     * <li>{@code contains(T value)}, which returns whether the set has the value
     * <li>{@code remove(T value)}, which removes the value and returns {@code true}, or returns {@code false} when the set doesn't have it
     * <li>{@code size()}, the number of values in the set
     * <li>{@code bucketCount()}, the number of buckets, so that the check can watch the set grow
     * </ul>
     * <p>Pick a value's bucket as SimpleMap does, with its hash code. The check runs:
     * <pre>{@code
     * SimpleSet<String> played = new SimpleSet<>();
     * System.out.println(played.add("maple") + " " + played.add("otter") + " " + played.add("maple"));
     * System.out.println(played.contains("otter") + " " + played.contains("cedar") + " " + played.size());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true true false
     * true false 2
     * }</pre>
     * Hints
     * 1. Start from SimpleMap: {@code private ArrayList<T>[] buckets;} and a size, the same constructor (with {@code new ArrayList[8]}), and a {@code bucketFor(T value)} that picks the bucket from {@code value.hashCode()}. A bucket is a short ArrayList, so its own {@code contains} and {@code remove} can do the searching inside it.
     * 2. {@code add} returns {@code false} when {@code bucketFor(value).contains(value)}. Otherwise it adds, counts, grows when {@code this.size > 0.75 * this.buckets.length}, and returns {@code true}. {@code grow} is SimpleMap's, with values instead of pairs. In {@code remove}, the bucket's {@code remove(value)} returns whether it removed something.
     */
    public static void main(String[] args) {
        SimpleSet<String> played = new SimpleSet<>();
        System.out.println(played.add("maple") + " " + played.add("otter") + " " + played.add("maple"));
        System.out.println(played.contains("otter") + " " + played.contains("cedar") + " " + played.size());
    }
}
