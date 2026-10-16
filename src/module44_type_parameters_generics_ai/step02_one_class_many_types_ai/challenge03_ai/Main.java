// AI-Generated
package module44_type_parameters_generics_ai.step02_one_class_many_types_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The storeroom keeps screws in several boxes, each a {@code Box<Integer>} holding how many screws it has. {@code Box.java} is ready. In {@code Main.java}, write two methods:
     * <ul>
     * <li>{@code total(ArrayList<Box<Integer>> boxes)}, which returns the number of screws in all the boxes together
     * <li>{@code fullest(ArrayList<Box<Integer>> boxes)}, which returns the box with the most screws, the first of them if several have the most. The list has at least one box.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * ArrayList<Box<Integer>> boxes = new ArrayList<>();
     * boxes.add(new Box<>(120));
     * boxes.add(new Box<>(450));
     * boxes.add(new Box<>(80));
     * System.out.println(total(boxes));
     * Box<Integer> most = fullest(boxes);
     * System.out.println(most.getContent());
     * most.setContent(0);
     * System.out.println(total(boxes));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 650
     * 450
     * 200
     * }</pre>
     * Hints
     * 1. The headers are {@code public static int total(ArrayList<Box<Integer>> boxes)} and {@code public static Box<Integer> fullest(ArrayList<Box<Integer>> boxes)}. A for-each loop goes through the boxes: {@code for (Box<Integer> box : boxes)}.
     * 2. In {@code total}, add each {@code box.getContent()} to an int sum: Java turns the Integer into an int. In {@code fullest}, start with {@code boxes.get(0)} and replace it only when a box has strictly more, {@code >}, so the first of several fullest boxes stays.
     */
    public static void main(String[] args) {
        ArrayList<Box<Integer>> boxes = new ArrayList<>();
        boxes.add(new Box<>(120));
        boxes.add(new Box<>(450));
        boxes.add(new Box<>(80));
        System.out.println(total(boxes));
        Box<Integer> most = fullest(boxes);
        System.out.println(most.getContent());
        most.setContent(0);
        System.out.println(total(boxes));
    }

    // Write the methods total and fullest here.
}
