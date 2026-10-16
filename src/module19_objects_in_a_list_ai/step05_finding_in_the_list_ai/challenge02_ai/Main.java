// AI-Generated
package module19_objects_in_a_list_ai.step05_finding_in_the_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? Watch the two comparisons when two pets are the same age.
     * Hints
     * 1. {@code >=} also replaces {@code oldest} with a pet of the same age, so of Misty and Kiwi (both 7), the later one wins.
     * 2. {@code <} replaces {@code youngest} only with a pet that's really younger. Bo (2) replaces Rex, but Nala (also 2) doesn't replace Bo.
     */
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 7));
        pets.add(new Pet("Kiwi", 7));
        pets.add(new Pet("Bo", 2));
        pets.add(new Pet("Nala", 2));

        Pet oldest = pets.get(0);
        Pet youngest = pets.get(0);
        for (Pet pet : pets) {
            if (pet.getAge() >= oldest.getAge()) {
                oldest = pet;
            }
            if (pet.getAge() < youngest.getAge()) {
                youngest = pet;
            }
        }
        System.out.println(oldest.getName());
        System.out.println(youngest.getName());
    }
}
