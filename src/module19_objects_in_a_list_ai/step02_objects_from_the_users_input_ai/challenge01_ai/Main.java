// AI-Generated
package module19_objects_in_a_list_ai.step02_objects_from_the_users_input_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * {@code NameTag.java} is ready. Read names until an empty line. For each name, create a {@code NameTag} and add it to the list {@code tags}. Then print the number of tags, followed by {@code  name tags}, and every tag with a for-each loop. For the input {@code Ines}, {@code Tom} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 name tags
     * Hello, my name is Ines
     * Hello, my name is Tom
     * }</pre>
     * Hints
     * 1. A {@code while (true)} loop reads a name, stops with {@code break} when {@code name.isEmpty()}, and otherwise runs {@code tags.add(new NameTag(name));}.
     * 2. After the loop, print {@code tags.size() + " name tags"}, and then each tag with {@code for (NameTag tag : tags)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NameTag> tags = new ArrayList<>();

    }
}
