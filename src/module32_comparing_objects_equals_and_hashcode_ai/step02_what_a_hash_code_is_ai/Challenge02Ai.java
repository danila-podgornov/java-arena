// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step02_what_a_hash_code_is_ai;

public class Challenge02Ai {
    /**
     * Work out buckets the way the table above does. Write the method {@code bucketOf(String key, int buckets)}, which returns the bucket of a key in a map with the given number of buckets: the remainder of the key's hash code divided by the number of buckets. A hash code can be negative, and then so is the remainder, so return it without its minus sign ({@code Math.abs}, module 7). The check runs:
     * <pre>{@code
     * System.out.println(bucketOf("Ada", 8));
     * System.out.println(bucketOf("Ben", 8));
     * System.out.println(bucketOf("Cy", 8));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6
     * 3
     * 6
     * }</pre>
     * Hints
     * 1. {@code key.hashCode()} gives the hash code, and {@code %} gives the remainder: {@code key.hashCode() % buckets}.
     * 2. Put it inside {@code Math.abs(...)}, so that a negative remainder loses its minus sign: {@code return Math.abs(key.hashCode() % buckets);}.
     */
    public static void main(String[] args) {
        System.out.println(bucketOf("Ada", 8));
        System.out.println(bucketOf("Ben", 8));
        System.out.println(bucketOf("Cy", 8));
    }

    // Write the method bucketOf here.
}
