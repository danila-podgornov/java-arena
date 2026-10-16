// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step01_every_class_inherits_from_object_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A display case holds minerals, and {@code contains} and {@code indexOf} should find a mineral with the same name and hardness. Fill in the blank, a type, so that {@code equals} replaces Object's.
     * Hints
     * 1. The method must have the same header as Object's {@code equals}, and Object's {@code equals} can be given any object at all.
     * 2. The parameter's type is {@code Object}. With {@code Mineral} there, the program still compiles, but it's a second method next to Object's, and {@code contains} goes on calling Object's.
     */
    public static void main(String[] args) {
        ArrayList<Mineral> display = new ArrayList<>();
        display.add(new Mineral("Quartz", 7));
        display.add(new Mineral("Talc", 1));
        System.out.println(display.contains(new Mineral("Talc", 1)));
        System.out.println(display.indexOf(new Mineral("Quartz", 7)));
    }
}
