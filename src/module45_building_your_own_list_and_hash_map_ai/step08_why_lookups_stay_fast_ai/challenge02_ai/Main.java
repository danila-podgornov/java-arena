// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step08_why_lookups_stay_fast_ai.challenge02_ai;

public class Main {
    /**
     * A seed library keeps its seed packets in drawers. A drawer is named by its cabinet, a letter, and its number, like C-117, and the library finds packets with a SimpleMap from Drawer to packet. {@code Drawer.java} has an {@code equals} that compares both, but its {@code hashCode} uses only the cabinet, so all the drawers of a cabinet share one bucket, however many buckets the map has.
     * <p>{@code SimpleMap.java} is the counting map from this step. {@code Main.java} puts the 300 drawers of cabinet C in the map, finds each of them once, and prints {@code fast} when that took fewer than 600 comparisons, or {@code slow} and the count. Right now it prints {@code slow: 45150 comparisons}. Write a better {@code hashCode} in {@code Drawer.java}, one that uses both the cabinet and the number, so that equal drawers still get equal hash codes. Then the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * fast
     * C-117: tomatoes
     * }</pre>
     * Hints
     * 1. Combine both values the way module 32's Seat did, using exactly the two values that {@code equals} compares.
     * 2. {@code return 31 * this.cabinet.hashCode() + this.number;} (or {@code Objects.hash(this.cabinet, this.number)}, with {@code import java.util.Objects;}). Just adding the two isn't enough: then A-12 and B-11 would share a hash code, since B's code is one more than A's. And the hash code must not depend on anything {@code equals} doesn't compare, or equal drawers could get different hash codes.
     */
    public static void main(String[] args) {
        SimpleMap<Drawer, String> packets = new SimpleMap<>();
        for (int i = 1; i <= 300; i++) {
            packets.put(new Drawer("C", i), "packet " + i);
        }
        packets.put(new Drawer("C", 117), "tomatoes");
        for (int i = 1; i <= 300; i++) {
            packets.get(new Drawer("C", i));
        }
        if (packets.getComparisons() < 600) {
            System.out.println("fast");
        } else {
            System.out.println("slow: " + packets.getComparisons() + " comparisons");
        }
        Drawer wanted = new Drawer("C", 117);
        System.out.println(wanted + ": " + packets.get(wanted));
    }
}
