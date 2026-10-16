// AI-Generated
package module19_objects_in_a_list_ai.step01_a_list_of_objects_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? {@code Pet} is the class from the lesson.
     * Hints
     * 1. {@code get(1)} is the second pet, and {@code getName()} gives only its name.
     * 2. {@code remove(0)} takes Rex out, so Misty moves to index 0. Printing a whole pet prints what its {@code toString} returns.
     */
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 2));
        pets.add(new Pet("Kiwi", 11));
        System.out.println(pets.size());
        System.out.println(pets.get(1).getName());
        pets.remove(0);
        System.out.println(pets.get(0));
        System.out.println(pets.size());
    }
}
