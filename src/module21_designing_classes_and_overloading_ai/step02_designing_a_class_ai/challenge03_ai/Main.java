// AI-Generated
package module21_designing_classes_and_overloading_ai.step02_designing_a_class_ai.challenge03_ai;

public class Main {
    /**
     * A parcel locker at a station has a number of compartments, each for one parcel. Write the class {@code ParcelLocker}:
     * <ul>
     * <li>{@code ParcelLocker(int compartments)} makes an empty locker with that many compartments.
     * <li>{@code free()} returns how many compartments are empty.
     * <li>{@code store()} puts a parcel in an empty compartment and returns {@code true}. When no compartment is free, it returns {@code false} and nothing changes. Use {@code free()} to check.
     * <li>{@code pickUp()} takes a parcel out. When the locker is empty, nothing changes.
     * <li>{@code toString()} returns how many compartments are in use, as in the output below.
     * </ul>
     * <p>Decide the instance variables yourself: what must a locker remember? The check makes a locker of 2 compartments, tries to store three parcels (printing what {@code store()} returns each time), prints the locker, picks up a parcel and prints {@code free()}: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * 2 of 2 compartments in use
     * 1
     * }</pre>
     * Hints
     * 1. A locker must remember how many compartments it has and how many parcels are in it. The free compartments follow from those two, so {@code free()} works them out: {@code return this.compartments - this.parcels;}.
     * 2. {@code store()} starts with {@code if (this.free() == 0) { return false; }}. After that there's room, so it adds a parcel and returns {@code true}. {@code pickUp()} takes one off only when there's at least one.
     */
    public static void main(String[] args) {
        ParcelLocker locker = new ParcelLocker(2);
        System.out.println(locker.store());
        System.out.println(locker.store());
        System.out.println(locker.store());
        System.out.println(locker);
        locker.pickUp();
        System.out.println(locker.free());
    }
}
