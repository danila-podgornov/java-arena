// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step04_removing_and_moving_the_rest_along_ai.challenge02_ai;

public class Main {
    /**
     * This loop should remove every song whose title starts with B, but it removes while it goes forward through the list. {@code Playlist.java} has the methods from this step. What does the program print?
     * Hints
     * 1. When {@code i} is 1, Ballad is removed, and every song after it moves one place to the left: Blues is now at index 1. The loop then goes on with {@code i} = 2.
     * 2. Write the list down after each removal and follow {@code i}. Blues is never looked at, and the loop stops when {@code i} reaches the new size.
     */
    public static void main(String[] args) {
        Playlist list = new Playlist();
        list.add("Anthem");
        list.add("Ballad");
        list.add("Blues");
        list.add("Carol");
        list.add("Bolero");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("B")) {
                list.remove(i);
            }
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
