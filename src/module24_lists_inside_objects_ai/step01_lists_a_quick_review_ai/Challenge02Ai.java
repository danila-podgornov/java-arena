// AI-Generated
package module24_lists_inside_objects_ai.step01_lists_a_quick_review_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print? A list is an object, so a list variable holds a reference to it, just like a variable of your own classes (module 22).
     * Hints
     * 1. {@code ArrayList<String> tuesday = monday;} makes no new list. It copies the reference, so {@code monday} and {@code tuesday} refer to the one list, and all three {@code add} calls on them go to that list.
     * 2. {@code friday} is a new list of its own, made with {@code new}. It holds only {@code swim}. {@code ==} asks whether two variables refer to the same object.
     */
    public static void main(String[] args) {
        ArrayList<String> monday = new ArrayList<>();
        monday.add("swim");
        ArrayList<String> tuesday = monday;
        tuesday.add("run");
        monday.add("yoga");
        ArrayList<String> friday = new ArrayList<>();
        friday.add("swim");
        System.out.println(monday.size() + " " + tuesday.size() + " " + friday.size());
        System.out.println(tuesday);
        System.out.println(monday == tuesday);
        System.out.println(monday == friday);
    }
}
