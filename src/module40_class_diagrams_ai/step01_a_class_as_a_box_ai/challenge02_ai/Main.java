// AI-Generated
package module40_class_diagrams_ai.step01_a_class_as_a_box_ai.challenge02_ai;

public class Main {
    /**
     * The ward's nurses have a class too. {@code Nurse.java} has a constructor and two methods, but its instance variables are missing, so it doesn't compile. Add them, as this box shows:
     * <pre>{@code
     * class Nurse
     * - name: String
     * - nightShift: boolean
     * - patients: int
     * }</pre>
     * <p>Leave the constructor and the methods as they are. The program should print: see the expected output below.
     * Expected output
     * {@code Tomas Berg (night shift): 2 patients}
     * Hints
     * 1. Put the three instance variables at the top of the class, one for each line of the box, in the same order.
     * 2. {@code -nightShift: boolean} is {@code private boolean nightShift;}. Do the same for {@code name} and {@code patients}.
     */
    public static void main(String[] args) {
        Nurse nurse = new Nurse("Tomas Berg", true);
        nurse.takePatient();
        nurse.takePatient();
        System.out.println(nurse);
    }
}
