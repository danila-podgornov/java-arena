// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step04_fast_lookups_and_the_end_of_part_8_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * A school library's desk scans student cards all day. {@code Student.java} is ready: a student has a card number and a name, with the getters {@code getCard()} and {@code getName()}. In {@code Main.java}, write the method {@code namesFor(ArrayList<Student> students, ArrayList<String> scans)}. It returns a new list with the name of the student for each scanned card, in the order of the scans, and {@code unknown} for a card that no student has. Build a {@code HashMap} from card number to student once, and then look up each scan in it. The check runs:
     * <pre>{@code
     * ArrayList<Student> students = new ArrayList<>();
     * students.add(new Student("S-104", "Amira"));
     * students.add(new Student("S-231", "Jonas"));
     * students.add(new Student("S-087", "Priya"));
     * ArrayList<String> scans = new ArrayList<>();
     * scans.add("S-231");
     * scans.add("S-500");
     * scans.add("S-104");
     * scans.add("S-231");
     * System.out.println(namesFor(students, scans));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [Jonas, unknown, Amira, Jonas]}
     * Hints
     * 1. First build the map, with one loop over the students: {@code HashMap<String, Student> byCard = new HashMap<>();}, and {@code byCard.put(student.getCard(), student);} for each one.
     * 2. Then go through the scans. {@code byCard.get(card)} gives the student, or {@code null} for a card no student has: add {@code "unknown"} then, and the student's {@code getName()} otherwise. Return the list of names at the end.
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S-104", "Amira"));
        students.add(new Student("S-231", "Jonas"));
        students.add(new Student("S-087", "Priya"));
        ArrayList<String> scans = new ArrayList<>();
        scans.add("S-231");
        scans.add("S-500");
        scans.add("S-104");
        scans.add("S-231");
        System.out.println(namesFor(students, scans));
    }

    // Write the method namesFor here.
}
