// AI-Generated
package module44_type_parameters_generics_ai.step05_putting_it_together_what_the_compiler_checks_ai.challenge02_ai;

public class Main {
    /**
     * A game keeps a player's last few scores in this step's History. Look closely at what {@code remove(0)} removes. What does this program print?
     * Hints
     * 1. {@code remove(0)} removes the element at index 0, the oldest one, not an element whose value is 0. Inside History, {@code 0} is an int, so it's the index version of {@code remove}, whatever T is.
     * 2. After the fourth score, the list is {@code [10, 0, 7, 0]}, longer than 3, so the 10 at index 0 goes. The history of pages keeps only 1 item.
     */
    public static void main(String[] args) {
        History<Integer> scores = new History<>(3);
        scores.add(10);
        scores.add(0);
        scores.add(7);
        scores.add(0);
        System.out.println(scores + " " + scores.latest());
        History<String> pages = new History<>(1);
        pages.add("home");
        pages.add("cart");
        System.out.println(pages);
    }
}
