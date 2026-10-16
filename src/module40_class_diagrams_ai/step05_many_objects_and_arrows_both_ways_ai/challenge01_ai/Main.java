// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge01_ai;

public class Main {
    /**
     * The ward keeps its patients in a list. {@code Patient.java} is ready. Write the class {@code Ward} in {@code Ward.java}, as the diagram shows:
     * <pre>{@code
     * class Patient
     * - name: String
     * - room: int
     * - temperature: double
     * + Patient(name: String, room: int, temperature: double)
     * + getName(): String
     * + getTemperature(): double
     * + toString(): String
     *
     * class Ward
     * - name: String
     * + Ward(name: String)
     * + admit(patient: Patient): void
     * + withFever(): ArrayList<Patient>
     * + toString(): String
     *
     * Ward --> * Patient : patients
     * }</pre>
     * <ul>
     * <li>A new ward has no patients. {@code admit} adds a patient to the ward.
     * <li>{@code withFever} returns a new list of the patients whose temperature is 38.0 or more, in the order they were admitted.
     * <li>{@code toString} returns {@code Ward 5B: 3 patients}, with the ward's own name and number of patients.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Ward ward = new Ward("Ward 5B");
     * ward.admit(new Patient("Ines Moreau", 12, 38.4));
     * ward.admit(new Patient("Oskar Lund", 12, 36.9));
     * ward.admit(new Patient("Mei Tan", 14, 38.0));
     * System.out.println(ward);
     * for (Patient patient : ward.withFever()) {
     *     System.out.println(patient.getName());
     * }
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ward 5B: 3 patients
     * Ines Moreau
     * Mei Tan
     * }</pre>
     * Hints
     * 1. Ward's instance variables are its {@code name} and, for the arrow with the star, {@code private ArrayList<Patient> patients;}, created in the constructor with {@code new ArrayList<>()}. {@code Ward.java} needs {@code import java.util.ArrayList;} at the top.
     * 2. {@code withFever} makes a new list, adds each patient whose {@code getTemperature()} is at least 38.0, and returns it. {@code toString} uses the size of the ward's list.
     */
    public static void main(String[] args) {
        Ward ward = new Ward("Ward 5B");
        ward.admit(new Patient("Ines Moreau", 12, 38.4));
        ward.admit(new Patient("Oskar Lund", 12, 36.9));
        ward.admit(new Patient("Mei Tan", 14, 38.0));
        System.out.println(ward);
        for (Patient patient : ward.withFever()) {
            System.out.println(patient.getName());
        }
    }
}
