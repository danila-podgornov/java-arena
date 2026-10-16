// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step01_every_class_inherits_from_object_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A museum stores fossils in drawers. {@code Fossil} has its own {@code toString}, but no {@code equals}. What does this program print?
     * Hints
     * 1. {@code println(tooth)} calls Fossil's own {@code toString}. {@code getClass().getName()} gives the class's name.
     * 2. Fossil has no {@code equals} of its own, so it has Object's, which is the same as {@code ==}. {@code tooth} and {@code other} are two different objects, and {@code contains} compares with {@code equals}.
     */
    public static void main(String[] args) {
        Fossil tooth = new Fossil("Shark tooth", 15);
        Fossil other = new Fossil("Shark tooth", 15);
        ArrayList<Fossil> drawer = new ArrayList<>();
        drawer.add(tooth);
        System.out.println(tooth);
        System.out.println(tooth.equals(other));
        System.out.println(drawer.contains(other));
        System.out.println(drawer.contains(tooth));
        System.out.println(other.getClass().getName());
    }
}
