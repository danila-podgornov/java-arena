// AI-Generated
package module24_lists_inside_objects_ai.step05_printing_an_object_that_holds_a_list_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? A necklace's toString joins the colors of its beads with dashes, using an index loop.
     * Hints
     * 1. The dash goes in front of every bead except the first one (index 0), so there's no dash at either end. An empty necklace skips the loop, and only the parentheses are left.
     * 2. Joining {@code a} to a String with {@code +} calls its toString, just as {@code println(a)} does.
     */
    public static void main(String[] args) {
        Necklace a = new Necklace();
        a.add("red");
        a.add("blue");
        a.add("red");
        Necklace b = new Necklace();
        System.out.println(a);
        System.out.println(b);
        b.add("gold");
        System.out.println(b);
        System.out.println("Necklace " + a + " has " + a.size() + " beads");
    }
}
