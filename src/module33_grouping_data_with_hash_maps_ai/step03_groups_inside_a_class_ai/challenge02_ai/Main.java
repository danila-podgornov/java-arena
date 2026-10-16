// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step03_groups_inside_a_class_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A garden keeps the plants of each bed, and {@code plantsIn} returns the list that's in the map, as ClubRegister's {@code members} does. What does this program print?
     * Hints
     * 1. {@code plantsIn("North")} returns the North bed's list itself, so {@code north} refers to the list in the map, and the nettles go into the garden too.
     * 2. {@code herbs} and the second {@code plantsIn("Herb")} are the same list, the one in the map, so {@code clear()} empties it for both. The Herb bed is still a key, now with an empty list: nothing in Garden removed it.
     */
    public static void main(String[] args) {
        Garden garden = new Garden();
        garden.plant("North", "kale");
        garden.plant("North", "leeks");
        garden.plant("Herb", "mint");
        garden.plant("Herb", "sage");

        ArrayList<String> north = garden.plantsIn("North");
        north.add("nettles");
        ArrayList<String> herbs = garden.plantsIn("Herb");
        garden.plantsIn("Herb").clear();

        System.out.println(garden.plantsIn("North"));
        System.out.println(herbs.size() + " " + garden.totalPlants());
        System.out.println(garden.bedCount());
    }
}
