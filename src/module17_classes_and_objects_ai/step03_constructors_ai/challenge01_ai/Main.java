// AI-Generated
package module17_classes_and_objects_ai.step03_constructors_ai.challenge01_ai;

public class Main {
    /**
     * {@code Parcel.java} has its instance variables and a method that prints them. Write the constructor, so that {@code new Parcel("Amir", 1200)} makes a parcel for Amir that weighs 1200 grams. The check runs:
     * <pre>{@code
     * Parcel parcel = new Parcel("Amir", 1200);
     * parcel.printInfo();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Parcel for Amir, 1200 g}
     * Hints
     * 1. The constructor has the class's name and no {@code void}: <code>public Parcel(String recipient, int grams) {</code>.
     * 2. Inside it, store each parameter in its instance variable: {@code this.recipient = recipient;} and {@code this.grams = grams;}.
     */
    public static void main(String[] args) {
        Parcel parcel = new Parcel("Amir", 1200);
        parcel.printInfo();
    }
}
