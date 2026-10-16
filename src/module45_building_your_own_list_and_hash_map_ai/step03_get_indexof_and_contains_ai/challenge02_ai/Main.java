// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step03_get_indexof_and_contains_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? {@code Playlist.java} has the methods from this step.
     * Hints
     * 1. {@code indexOf} returns the index of the first match. {@code equals} tells capitals from small letters, so {@code copper sky} isn't in the list.
     * 2. The array has 4 places, but the size is 3, so {@code get(3)} throws. Its {@code println} never happens, and the {@code catch} block prints the message. A failed {@code get} changes nothing.
     */
    public static void main(String[] args) {
        Playlist list = new Playlist();
        list.add("Slow River");
        list.add("Copper Sky");
        list.add("Slow River");
        System.out.println(list.indexOf("Slow River") + " " + list.contains("copper sky"));
        try {
            System.out.println(list.get(2));
            System.out.println(list.get(3));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list.size());
    }
}
