// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? {@code Toy} has no {@code equals} of its own, and the toybox's {@code remove} passes the toy on to the list's {@code remove}.
     * Hints
     * 1. Without its own {@code equals}, a Toy equals only itself. {@code new Toy("kite")} in the remove call is a different object from the kite in the box, so nothing is removed.
     * 2. {@code box.remove(ball)} gives the very object that {@code ball} refers to, the first toy in the box, so that one goes. The other ball is a different object and stays. {@code empty()} clears the list.
     */
    public static void main(String[] args) {
        Toybox box = new Toybox();
        Toy ball = new Toy("ball");
        box.add(ball);
        box.add(new Toy("kite"));
        box.add(new Toy("ball"));
        box.remove(new Toy("kite"));
        System.out.println(box.count());
        box.remove(ball);
        System.out.println(box);
        box.empty();
        System.out.println(box.count());
    }
}
