// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step03_get_indexof_and_contains_ai.challenge01_ai;

public class Main {
    /**
     * In {@code GuestList.java}, the guest list from step 2 is ready. Add two methods:
     * <ul>
     * <li>{@code get(int index)}, which returns the name at that index. For an index below 0, or at the size or above, it throws an IndexOutOfBoundsException with the message {@code Index 3 out of bounds for size 3} (with the index and the size in it).
     * <li>{@code contains(String name)}, which returns {@code true} if the name is on the list.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * GuestList guests = new GuestList();
     * guests.add("Amara");
     * guests.add("Bruno");
     * guests.add("Chen");
     * System.out.println(guests.get(1));
     * System.out.println(guests.contains("Chen") + " " + guests.contains("Dana"));
     * try {
     *     System.out.println(guests.get(3));
     * } catch (IndexOutOfBoundsException e) {
     *     System.out.println(e.getMessage());
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bruno
     * true false
     * Index 3 out of bounds for size 3
     * }</pre>
     * Hints
     * 1. Check the index against the size first, as Playlist's {@code get} does, and refuse a bad one before reading the array. GuestList has no {@code indexOf}, so {@code contains} loops the way Playlist's {@code indexOf} does.
     * 2. {@code get} starts with {@code if (index < 0 || index >= this.size) { throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size); }} and then returns {@code this.names[index]}. {@code contains} loops from 0 up to {@code this.size}, not {@code this.names.length}: the places after the size hold {@code null}. Compare with {@code this.names[i].equals(name)}, and return {@code false} after the loop.
     */
    public static void main(String[] args) {
        GuestList guests = new GuestList();
        guests.add("Amara");
        guests.add("Bruno");
        guests.add("Chen");
        System.out.println(guests.get(1));
        System.out.println(guests.contains("Chen") + " " + guests.contains("Dana"));
        try {
            System.out.println(guests.get(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
