// AI-Generated
package module47_two_dimensional_arrays_ai.step05_rows_of_different_lengths_and_grids_of_objects_ai.challenge03_ai;

public class Main {
    /**
     * A box of chocolates once more. {@code Chocolate.java} is ready: a chocolate has a name and a weight in grams, and its {@code toString} returns the name. In {@code ChocolateBox.java}, write the class {@code ChocolateBox}, which keeps its chocolates in a {@code Chocolate[][]}, with {@code null} for an empty place:
     * <ul>
     * <li>a constructor {@code ChocolateBox(int rows, int columns)}, which creates an empty box of that size
     * <li>{@code put(int row, int column, Chocolate chocolate)}, which puts the chocolate in that place
     * <li>{@code take(int row, int column)}, which returns the chocolate in that place and leaves the place empty, or returns {@code null} when the place is already empty
     * <li>{@code gramsLeft()}, which returns the total weight of the chocolates in the box
     * <li>{@code toString()}, which returns the grid as {@code Arrays.deepToString} writes it
     * </ul>
     * <p>{@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [[praline, null, truffle], [null, caramel, null]]
     * Grams left: 36
     * Took: truffle
     * Took: null
     * [[praline, null, null], [null, caramel, null]]
     * Grams left: 21
     * }</pre>
     * Hints
     * 1. The box needs one field, {@code private Chocolate[][] places;}, which the constructor creates with {@code new Chocolate[rows][columns]}. {@code take} keeps the chocolate in a variable, sets the place to {@code null}, and returns the variable.
     * 2. {@code gramsLeft} goes through every place, and adds {@code getGrams()} only for a place that isn't {@code null}: calling a method on {@code null} crashes. {@code toString} returns {@code Arrays.deepToString(this.places)}.
     */
    public static void main(String[] args) {
        ChocolateBox box = new ChocolateBox(2, 3);
        box.put(0, 0, new Chocolate("praline", 12));
        box.put(0, 2, new Chocolate("truffle", 15));
        box.put(1, 1, new Chocolate("caramel", 9));
        System.out.println(box);
        System.out.println("Grams left: " + box.gramsLeft());
        System.out.println("Took: " + box.take(0, 2));
        System.out.println("Took: " + box.take(0, 2));
        System.out.println(box);
        System.out.println("Grams left: " + box.gramsLeft());
    }
}
