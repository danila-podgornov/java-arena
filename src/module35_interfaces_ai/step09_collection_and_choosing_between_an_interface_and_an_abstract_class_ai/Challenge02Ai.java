// AI-Generated
package module35_interfaces_ai.step09_collection_and_choosing_between_an_interface_and_an_abstract_class_ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Challenge02Ai {
    /**
     * A party's guest list has a name twice. What does this program print?
     * Hints
     * 1. A HashSet made from the list keeps each name once, and {@code describe} counts whatever collection it's given.
     * 2. The list keeps Ada twice: 3 names, 9 letters. The set has Ada and Ben, 6 letters. The set is a new object, made from the list's values, so adding Cy to the set doesn't change the list.
     */
    public static void main(String[] args) {
        List<String> guests = new ArrayList<>();
        guests.add("Ada");
        guests.add("Ben");
        guests.add("Ada");
        Set<String> names = new HashSet<>(guests);
        System.out.println(describe(guests) + " / " + describe(names));
        names.add("Cy");
        System.out.println(guests.size() + " " + names.size());
    }

    public static String describe(Collection<String> people) {
        int letters = 0;
        for (String person : people) {
            letters += person.length();
        }
        return people.size() + " people, " + letters + " letters";
    }
}
