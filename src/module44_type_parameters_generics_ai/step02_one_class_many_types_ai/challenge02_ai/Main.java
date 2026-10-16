// AI-Generated
package module44_type_parameters_generics_ai.step02_one_class_many_types_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A scout troop packs for a camping trip. {@code Box} is the class from this module. Look at the types, and at which list each box holds. What does this program print?
     * Hints
     * 1. {@code tents} is a {@code Box<Integer>}, so {@code getContent() / 2} divides two whole numbers, and the decimals are dropped. {@code water} is a {@code Box<Double>}, so its division keeps them.
     * 2. {@code red} and {@code blue} are two boxes, but both hold the same list, {@code gear}: a box keeps a reference to the list, not a copy (module 22). Both {@code add}s go into that one list.
     */
    public static void main(String[] args) {
        Box<Integer> tents = new Box<>(5);
        Box<Double> water = new Box<>(5.0);
        tents.setContent(tents.getContent() / 2);
        water.setContent(water.getContent() / 2);
        System.out.println(tents.getContent() + " " + water.getContent());

        ArrayList<String> gear = new ArrayList<>();
        Box<ArrayList<String>> red = new Box<>(gear);
        Box<ArrayList<String>> blue = new Box<>(gear);
        red.getContent().add("rope");
        blue.getContent().add("stakes");
        System.out.println(red.getContent().size() + " " + blue.getContent());
    }
}
