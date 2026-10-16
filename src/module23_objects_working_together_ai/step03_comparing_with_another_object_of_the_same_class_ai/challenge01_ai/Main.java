// AI-Generated
package module23_objects_working_together_ai.step03_comparing_with_another_object_of_the_same_class_ai.challenge01_ai;

public class Main {
    /**
     * In {@code Mountain.java}, write the method {@code isHigherThan(Mountain other)}. It returns {@code true} when this mountain is higher than the other one, and {@code false} otherwise (also when both are equally high). The check runs:
     * <pre>{@code
     * Mountain grayPeak = new Mountain("Gray Peak", 2410);
     * Mountain redHill = new Mountain("Red Hill", 980);
     * System.out.println(grayPeak.isHigherThan(redHill));
     * System.out.println(redHill.isHigherThan(grayPeak));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. The parameter is a Mountain: <code>public boolean isHigherThan(Mountain other) {</code>.
     * 2. Compare this mountain's meters with the other's. The method is in the Mountain class, so it may read {@code other.meters}: {@code return this.meters > other.meters;}.
     */
    public static void main(String[] args) {
        Mountain grayPeak = new Mountain("Gray Peak", 2410);
        Mountain redHill = new Mountain("Red Hill", 980);
        System.out.println(grayPeak.isHigherThan(redHill));
        System.out.println(redHill.isHigherThan(grayPeak));
    }
}
