// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge03_ai;

public class Main {
    /**
     * The ward's program has grown: a bed now holds a {@code Patient} object instead of a name, and a free bed holds none.
     * <pre>{@code
     * class Patient
     * - name: String
     * - room: int
     * - temperature: double
     * + Patient(name: String, room: int, temperature: double)
     * + getName(): String
     * + toString(): String
     *
     * class Bed
     * - number: int
     * + Bed(number: int)
     * + getPatient(): Patient
     * + assign(patient: Patient): boolean
     * + release(): void
     * + toString(): String
     *
     * Bed --> 0..1 Patient : patient
     * }</pre>
     * <p>{@code Patient.java} is ready. Write the class {@code Bed} in {@code Bed.java}:
     * <ul>
     * <li>A new bed is free: its patient is {@code null}.
     * <li>{@code assign} puts the patient in the bed and returns {@code true}, but only if the bed is free. A bed that has a patient keeps them, and {@code assign} returns {@code false}.
     * <li>{@code release} makes the bed free, and {@code getPatient} returns the bed's patient, or {@code null} for a free bed.
     * <li>{@code toString} returns {@code Bed 3: free}, or {@code Bed 3: Ines Moreau} with the patient's name.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Bed bed = new Bed(3);
     * Patient ines = new Patient("Ines Moreau", 12, 38.4);
     * Patient oskar = new Patient("Oskar Lund", 12, 36.9);
     * System.out.println(bed);
     * System.out.println(bed.assign(ines) + " " + bed.assign(oskar));
     * System.out.println(bed);
     * bed.release();
     * System.out.println(bed.getPatient() == null);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bed 3: free
     * true false
     * Bed 3: Ines Moreau
     * true
     * }</pre>
     * Hints
     * 1. The arrow with {@code 0..1} is a field that may be {@code null}: {@code private Patient patient;}, set to {@code null} in the constructor.
     * 2. {@code assign} checks {@code this.patient != null} first and returns {@code false} if the bed is taken. {@code toString} must check for {@code null} too, before it calls {@code this.patient.getName()}.
     */
    public static void main(String[] args) {
        Bed bed = new Bed(3);
        Patient ines = new Patient("Ines Moreau", 12, 38.4);
        Patient oskar = new Patient("Oskar Lund", 12, 36.9);
        System.out.println(bed);
        System.out.println(bed.assign(ines) + " " + bed.assign(oskar));
        System.out.println(bed);
        bed.release();
        System.out.println(bed.getPatient() == null);
    }
}
