// AI-Generated
package module19_objects_in_a_list_ai.step04_choosing_from_the_list_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? Check the condition for each pet in turn.
     * Hints
     * 1. With {@code ||}, a pet is printed when it's older than 3, or when its name starts with M. Misty is only 2, but her name starts with M.
     * 2. Bo is 3, which isn't more than 3, and his name doesn't start with M. So three pets are printed, and the count is 3 of the 4.
     */
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 2));
        pets.add(new Pet("Kiwi", 11));
        pets.add(new Pet("Bo", 3));

        int count = 0;
        for (Pet pet : pets) {
            if (pet.getAge() > 3 || pet.getName().startsWith("M")) {
                System.out.println(pet.getName());
                count++;
            }
        }
        System.out.println(count + " of " + pets.size());
    }
}
