// AI-Generated
package module24_lists_inside_objects_ai.step02_a_list_as_an_instance_variable_ai.challenge02_ai;

public class Main {
    /**
     * Now a whole class of your own. {@code Mailbox.java} is empty: write the class {@code Mailbox} in it, from the first line. A mailbox has an owner and a list of letters, which are Strings.
     * <ul>
     * <li>The constructor {@code Mailbox(String owner)} keeps the owner and makes a new, empty list for the letters.
     * <li>{@code deliver(String letter)} adds a letter to the list.
     * <li>{@code count()} returns how many letters there are.
     * <li>{@code toString()} returns the owner, a colon and the list, like {@code Ana: [bill, magazine]}. Joining the list to a String writes it out in brackets, just as printing it does.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Mailbox ana = new Mailbox("Ana");
     * Mailbox leo = new Mailbox("Leo");
     * ana.deliver("bill");
     * leo.deliver("postcard");
     * ana.deliver("magazine");
     * System.out.println(ana.count() + " " + leo.count());
     * System.out.println(ana);
     * System.out.println(leo);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 2 1
     * Ana: [bill, magazine]
     * Leo: [postcard]
     * }</pre>
     * Hints
     * 1. Start with {@code import java.util.ArrayList;} and <code>public class Mailbox {</code>, then two private instance variables: a String for the owner and an {@code ArrayList<String>} for the letters. The recipe above has the same shape.
     * 2. The constructor sets {@code this.owner = owner;} and {@code this.letters = new ArrayList<>();}. {@code deliver} calls {@code this.letters.add(letter);}, {@code count} returns {@code this.letters.size();}, and toString returns {@code this.owner + ": " + this.letters;}.
     */
    public static void main(String[] args) {
        Mailbox ana = new Mailbox("Ana");
        Mailbox leo = new Mailbox("Leo");
        ana.deliver("bill");
        leo.deliver("postcard");
        ana.deliver("magazine");
        System.out.println(ana.count() + " " + leo.count());
        System.out.println(ana);
        System.out.println(leo);
    }
}
