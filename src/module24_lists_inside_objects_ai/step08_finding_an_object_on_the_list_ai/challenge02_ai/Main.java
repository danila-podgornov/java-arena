// AI-Generated
package module24_lists_inside_objects_ai.step08_finding_an_object_on_the_list_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? {@code find} and {@code oldest} both return a Horse from the stable's list, or {@code null}.
     * Hints
     * 1. {@code find} returns the Horse object on the list, not a copy. So the two birthdays through {@code pepper} make the stable's Pepper 8, older than Storm.
     * 2. There's no horse called Ghost, so {@code find} returns {@code null}, and printing it prints {@code null}. Storm isn't the oldest any more, so the two calls return different objects.
     */
    public static void main(String[] args) {
        Stable stable = new Stable();
        stable.add(new Horse("Storm", 7));
        stable.add(new Horse("Pepper", 6));
        Horse pepper = stable.find("Pepper");
        pepper.birthday();
        pepper.birthday();
        System.out.println(stable.oldest());
        System.out.println(stable.find("Ghost"));
        System.out.println(stable.find("Storm") == stable.oldest());
    }
}
