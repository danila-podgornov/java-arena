// AI-Generated
package module22_primitive_and_reference_variables_ai.step04_null_and_nullpointerexception_ai.challenge03_ai;

public class Main {
    /**
     * A small car park keeps its spots in an array: {@code spots[0]} is spot 1, {@code spots[1]} is spot 2, and so on, and an empty spot is {@code null}. {@code Car.java} is ready. In {@code Main}, write a method {@code printSpots(Car[] spots)} that prints every spot, with the plate of the car in it or {@code free}. The check runs:
     * <pre>{@code
     * Car[] spots = new Car[4];
     * spots[0] = new Car("KLM-204");
     * spots[2] = new Car("XT-9981");
     * printSpots(spots);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Spot 1: KLM-204
     * Spot 2: free
     * Spot 3: XT-9981
     * Spot 4: free
     * }</pre>
     * Hints
     * 1. Loop over the indexes, {@code for (int i = 0; i < spots.length; i++)}, so you know each spot's number: {@code i + 1}.
     * 2. Check {@code spots[i] == null} before calling {@code getPlate()}: on an empty spot the call would crash. Put {@code (i + 1)} in parentheses in the printed line, or {@code +} joins the digits as text.
     */
    public static void main(String[] args) {
        Car[] spots = new Car[4];
        spots[0] = new Car("KLM-204");
        spots[2] = new Car("XT-9981");
        printSpots(spots);
    }

    // Write the printSpots method here.
}
