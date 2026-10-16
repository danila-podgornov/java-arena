// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step02_a_list_of_your_own_ai.challenge02_ai;

public class Main {
    /**
     * This Playlist's constructor takes the length of its first array. What does this program print?
     * Hints
     * 1. The array grows only when a song arrives and every place is taken. The first two songs fit in the 3 places.
     * 2. The fourth song finds 3 of 3 places used, so the array becomes 6 long. The seventh song finds 6 of 6 used. A song added twice still takes a place of its own.
     */
    public static void main(String[] args) {
        Playlist party = new Playlist(3);
        party.add("Copper Sky");
        party.add("Night Train");
        System.out.println(party.size() + " " + party.capacity());
        party.add("Paper Boats");
        party.add("Slow River");
        System.out.println(party.size() + " " + party.capacity());
        party.add("Morning Rain");
        party.add("Lantern Light");
        party.add("Copper Sky");
        System.out.println(party.size() + " " + party.capacity());
    }
}
