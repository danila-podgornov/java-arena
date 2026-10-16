// AI-Generated
package module23_objects_working_together_ai.step05_equals_and_lists_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? {@code Tag} has no {@code equals} of its own.
     * Hints
     * 1. Without an {@code equals} of its own, Tag uses the one every class gets, which does the same as {@code ==}: an object is equal only to itself.
     * 2. {@code urgent} is the very object in the list, at index 0, so it's found. Each {@code new Tag(...)} is a new object that isn't in the list, so it's never found.
     */
    public static void main(String[] args) {
        ArrayList<Tag> tags = new ArrayList<>();
        Tag urgent = new Tag("urgent");
        tags.add(urgent);
        tags.add(new Tag("home"));
        System.out.println(tags.contains(urgent));
        System.out.println(tags.contains(new Tag("home")));
        System.out.println(tags.indexOf(urgent));
        System.out.println(tags.indexOf(new Tag("urgent")));
    }
}
