// AI-Generated
package module51_data_visualization_ai.step04_series_from_a_formula_ai.challenge01_ai;

public class Main {
    /**
     * A café stacks paper cups into a pyramid for its window: one cup on top, two under it, three under those, and so on. Write the class {@code CupPyramid} in {@code CupPyramid.java}, with the method {@code public static List<Integer> cups(int maxRows)}. It returns a list of {@code maxRows + 1} numbers: at index {@code r}, the number of cups that a pyramid of {@code r} rows needs (so 0 at index 0, then 1, then 1 + 2, then 1 + 2 + 3, ...). No JavaFX in it: a chart can use it later.
     * <p>The check runs {@code System.out.println(CupPyramid.cups(5));} and expects: see the expected output below.
     * Expected output
     * {@code [0, 1, 3, 6, 10, 15]}
     * Hints
     * 1. Keep a running total. A pyramid of {@code r} rows has the cups of {@code r - 1} rows plus a bottom row of {@code r} cups.
     * 2. Add 0 to the list first (a pyramid of no rows), then loop {@code row} from 1 to {@code maxRows}: add {@code row} to the total, and the total to the list.
     */
    public static void main(String[] args) {
        System.out.println(CupPyramid.cups(5));
    }
}
