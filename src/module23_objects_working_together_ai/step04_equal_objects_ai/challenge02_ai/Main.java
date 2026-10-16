// AI-Generated
package module23_objects_working_together_ai.step04_equal_objects_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Here two members are equal when their membership numbers are the same.
     * Hints
     * 1. {@code equals} compares only the numbers, so the names don't matter at all. {@code a} and {@code b} have the same number, {@code a} and {@code c} don't.
     * 2. {@code ==} still asks whether two variables refer to the same object, and {@code a} and {@code b} were made by two {@code new}s.
     */
    public static void main(String[] args) {
        Member a = new Member(1042, "Ana Silva");
        Member b = new Member(1042, "A. Silva");
        Member c = new Member(2077, "Ana Silva");
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a == b);
        System.out.println(b.equals(a));
    }
}
