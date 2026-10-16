// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step03_get_indexof_and_contains_ai.challenge03_ai;

public class Main {
    /**
     * {@code Playlist.java} has the methods from this step. Add two more, like the ones ArrayList has:
     * <ul>
     * <li>{@code set(int index, String song)}, which puts the song at that index in place of the one there, and returns the song it replaced. A bad index is refused just as {@code get} refuses it, with the same exception and message.
     * <li>{@code lastIndexOf(String song)}, which returns the index of the last song that equals the given one, or -1 if there's none.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Playlist list = new Playlist();
     * list.add("Night Train");
     * list.add("Paper Boats");
     * list.add("Night Train");
     * System.out.println(list.lastIndexOf("Night Train") + " " + list.lastIndexOf("Copper Sky"));
     * String old = list.set(1, "Slow River");
     * System.out.println(old + " -> " + list.get(1));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 -1
     * Paper Boats -> Slow River
     * }</pre>
     * Hints
     * 1. {@code set} can let {@code get} do the checking: {@code String old = get(index);} throws for a bad index, and otherwise gives the song to return. Then put the new song at {@code this.songs[index]}.
     * 2. {@code lastIndexOf} searches from the end: {@code for (int i = this.size - 1; i >= 0; i--)}. The first match it meets is the last one in the list.
     */
    public static void main(String[] args) {
        Playlist list = new Playlist();
        list.add("Night Train");
        list.add("Paper Boats");
        list.add("Night Train");
        System.out.println(list.lastIndexOf("Night Train") + " " + list.lastIndexOf("Copper Sky"));
        String old = list.set(1, "Slow River");
        System.out.println(old + " -> " + list.get(1));
    }
}
