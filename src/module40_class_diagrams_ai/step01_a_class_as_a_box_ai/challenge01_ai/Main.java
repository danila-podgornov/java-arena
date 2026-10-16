// AI-Generated
package module40_class_diagrams_ai.step01_a_class_as_a_box_ai.challenge01_ai;

public class Main {
    /**
     * A hospital ward keeps track of its patients. Here's the box of a patient:
     * <pre>{@code
     * class Patient
     * - name: String
     * - room: int
     * - temperature: double
     * }</pre>
     * <p>Fill in the blanks in {@code Patient.java}, so that its instance variables match the box. The constructor and {@code toString} are ready.
     * Hints
     * 1. Each line of the box is one instance variable, with the name first in the box and the type first in Java: {@code -room: int} is {@code private int room;}.
     * 2. {@code -} stands for {@code private}. The blanks are {@code private}, {@code int}, {@code double} and {@code temperature}.
     */
    public static void main(String[] args) {
        Patient patient = new Patient("Ines Moreau", 12, 38.4);
        System.out.println(patient);
    }
}
