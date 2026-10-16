// AI-Generated
package module40_class_diagrams_ai.step02_constructors_and_methods_in_a_box_ai.challenge01_ai;

public class Main {
    /**
     * The ward gives each of its beds an object. Write the class {@code Bed} in {@code Bed.java}, as this box shows:
     * <pre>{@code
     * class Bed
     * - number: int
     * - patient: String
     * + Bed(number: int)
     * + isFree(): boolean
     * + assign(name: String): void
     * + release(): void
     * + toString(): String
     * }</pre>
     * <ul>
     * <li>A new bed is free: its patient is {@code null}.
     * <li>{@code assign} puts the patient's name in the bed, and {@code release} makes the bed free again.
     * <li>{@code isFree} says whether the bed is free.
     * <li>{@code toString} returns {@code Bed 4: free} for a free bed and {@code Bed 4: Ines Moreau} for a bed with a patient, with the bed's own number and patient.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Bed bed = new Bed(4);
     * System.out.println(bed + " " + bed.isFree());
     * bed.assign("Ines Moreau");
     * System.out.println(bed + " " + bed.isFree());
     * bed.release();
     * System.out.println(bed);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Bed 4: free true
     * Bed 4: Ines Moreau false
     * Bed 4: free
     * }</pre>
     * Hints
     * 1. Start with the two instance variables from the box's fields, then the constructor {@code public Bed(int number)}. Each method line becomes a header: {@code +assign(name: String): void} is {@code public void assign(String name)}.
     * 2. {@code isFree} returns {@code this.patient == null}, and {@code release} sets the patient back to {@code null}. {@code toString} checks {@code isFree()} and returns one text or the other.
     */
    public static void main(String[] args) {
        Bed bed = new Bed(4);
        System.out.println(bed + " " + bed.isFree());
        bed.assign("Ines Moreau");
        System.out.println(bed + " " + bed.isFree());
        bed.release();
        System.out.println(bed);
    }
}
