// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step02_a_list_of_your_own_ai.challenge01_ai;

public class Main {
    /**
     * An event keeps its guest list in an array. In {@code GuestList.java}, write the class {@code GuestList} with:
     * <ul>
     * <li>a constructor with no parameters, which creates a {@code String} array with room for 2 names
     * <li>{@code add(String name)}, which adds a name at the end; when the array is full, it first moves the names into an array twice as long
     * <li>{@code size()}, which returns the number of names added
     * <li>{@code toString()}, which returns the names in the order they were added, separated by a comma and a space, without brackets; a list without names gives the empty String
     * </ul>
     * <p>Keep the names in the array, not in an ArrayList. The check runs:
     * <pre>{@code
     * GuestList guests = new GuestList();
     * guests.add("Amara");
     * guests.add("Bruno");
     * guests.add("Chen");
     * System.out.println(guests.size());
     * System.out.println(guests);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * Amara, Bruno, Chen
     * }</pre>
     * Hints
     * 1. Two instance variables, as in Playlist: {@code private String[] names;} and {@code private int size;}. The constructor sets {@code this.names = new String[2];}.
     * 2. In {@code add}, check {@code if (this.size == this.names.length)} first, and then grow: a new array of twice the length, a loop that copies the names, and {@code this.names = bigger;}. After that, {@code this.names[this.size] = name;} and {@code this.size++;}.
     */
    public static void main(String[] args) {
        GuestList guests = new GuestList();
        guests.add("Amara");
        guests.add("Bruno");
        guests.add("Chen");
        System.out.println(guests.size());
        System.out.println(guests);
    }
}
