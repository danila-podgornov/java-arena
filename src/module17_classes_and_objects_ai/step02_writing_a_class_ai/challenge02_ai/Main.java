// AI-Generated
package module17_classes_and_objects_ai.step02_writing_a_class_ai.challenge02_ai;

public class Main {
    /**
     * In {@code Kayak.java}, the instance variables have no {@code private}, so code outside the class can change them, and a line in {@code Main.java} gives the kayak -3 seats. Make both variables private. javac then stops at that line in {@code Main.java} ({@code seats has private access in Kayak}), because only the Kayak class may change its seats now: delete the line. The program then prints: see the expected output below.
     * Expected output
     * {@code Sea Otter, 2 seats}
     * Hints
     * 1. Put {@code private} in front of both instance variables in {@code Kayak.java}: {@code private String model;} and {@code private int seats;}.
     * 2. Then <b>Check</b> shows the error in {@code Main.java}, at {@code kayak.seats = -3;}. Delete that whole line: the kayak keeps the 2 seats its constructor gave it.
     */
    public static void main(String[] args) {
        Kayak kayak = new Kayak("Sea Otter", 2);
        kayak.seats = -3;
        kayak.printInfo();
    }
}
