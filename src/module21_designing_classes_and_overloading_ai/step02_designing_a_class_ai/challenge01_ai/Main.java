// AI-Generated
package module21_designing_classes_and_overloading_ai.step02_designing_a_class_ai.challenge01_ai;

public class Main {
    /**
     * Here's a description. *A garden bed is a rectangle, with a length and a width in whole meters. Every square meter has room for 4 plants. We want to know a bed's area and how many plants it has room for, and to print it like {@code 3 x 2 m, room for 24 plants}.*
     * <p>Write the class {@code GardenBed}, with the constructor {@code GardenBed(int length, int width)} and the methods {@code area()}, {@code room()} and {@code toString()}. Keep only what a bed must remember in instance variables. {@code room()} should use {@code area()}, and {@code toString()} should use {@code room()}. The check creates {@code new GardenBed(3, 2)} and prints its area and then the bed: see the expected output below.
     * Expected output
     * <pre>{@code
     * 6
     * 3 x 2 m, room for 24 plants
     * }</pre>
     * Hints
     * 1. A bed must remember its length and its width: two private {@code int} instance variables. The area and the room follow from them, so they're methods: {@code public int area()} and {@code public int room()}.
     * 2. {@code area()} returns {@code this.length * this.width}, and {@code room()} returns {@code this.area() * 4}. {@code toString} builds the text with {@code this.room()}.
     */
    public static void main(String[] args) {
        GardenBed bed = new GardenBed(3, 2);
        System.out.println(bed.area());
        System.out.println(bed);
    }
}
