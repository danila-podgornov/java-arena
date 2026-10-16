// AI-Generated
package module44_type_parameters_generics_ai.step03_several_type_parameters_and_a_list_of_t_ai.challenge02_ai;

public class Main {
    /**
     * Two lifeguards share the lake with this step's Rotation and Duo: each day one sits in the tower and the other walks the shore. Look at where the rotation's turn is after two calls to {@code next()}. What does this program print?
     * Hints
     * 1. The two {@code next()} calls give Abena and then Joaquin, and {@code swapped()} makes a new Duo the other way around. {@code today} itself doesn't change.
     * 2. After Joaquin, the turn reached the size of the list, 2, so it went back to 0. Adding Leilani doesn't move the turn: the next two are Abena and Joaquin again.
     */
    public static void main(String[] args) {
        Rotation<String> guards = new Rotation<>();
        guards.add("Abena");
        guards.add("Joaquin");
        Duo<String, String> today = new Duo<>(guards.next(), guards.next());
        Duo<String, String> tomorrow = today.swapped();
        System.out.println(today.getFirst() + " takes the tower, " + today.getSecond() + " walks the shore");
        System.out.println(tomorrow);
        guards.add("Leilani");
        System.out.println(guards.next() + " " + guards.next());
    }
}
