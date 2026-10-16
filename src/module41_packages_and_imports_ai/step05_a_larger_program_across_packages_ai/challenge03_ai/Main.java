// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge03_ai;

import java.util.Scanner;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge03_ai.shoestore.logic.Stock;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge03_ai.shoestore.ui.TextUI;

public class Main {
    /**
     * The shoe store's program gets its user interface. {@code Shoe.java} now also has {@code getModel()}, and {@code Stock.java} is the one from step 2. {@code Main.java} is ready. Two parts are yours:
     * <ul>
     * <li>In {@code Stock.java}, add {@code sell(String model, int size)}: if the stock has a pair of that model (exactly as written) and size, it removes one such pair and returns {@code true}; otherwise it returns {@code false}. Stock prints nothing.
     * <li>In {@code shoestore/ui/TextUI.java}, write the class {@code TextUI}, in the package {@code shoestore.ui}. Its constructor takes a {@code Scanner} and a {@code Stock}, and {@code start()} reads commands, with the prompt {@code > } before each one:
     * <li>{@code add}: the next two lines are a model and a size. Add the pair to the stock, and print {@code Added } and the shoe, like {@code Added Loafer, size 42}.
     * <li>{@code sell}: the next two lines are a model and a size. Sell a pair and print {@code Sold Loafer, size 42}, or print {@code Not in stock: Loafer, size 42} if the stock has none.
     * <li>{@code size}: the next line is a size. Print {@code Pairs in size 42: } and the number of pairs of that size.
     * <li>{@code quit}: print {@code Pairs left: } and the number of pairs in the stock, and return.
     * <li>Anything else: print {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Added Trail runner, size 42
     * > Added Loafer, size 42
     * > Added Trail runner, size 39
     * > Pairs in size 42: 2
     * > Not in stock: Loafer, size 40
     * > Sold Loafer, size 42
     * > Pairs in size 42: 1
     * > Pairs left: 2
     * }</pre>
     * Hints
     * 1. {@code sell} goes through the shoes and compares both the model, with {@code equals}, and the size. At the first match it removes that shoe with {@code this.shoes.remove(shoe)} and returns {@code true} right away; after the loop, it returns {@code false}.
     * 2. TextUI imports {@code java.util.Scanner}, {@code shoestore.domain.Shoe} and {@code shoestore.logic.Stock}. Read a size with {@code Integer.valueOf(this.scanner.nextLine())}. Private methods such as {@code add()} and {@code sell()} keep {@code start()} short, as in the lesson's quiz.
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI(new Scanner(System.in), new Stock());
        ui.start();
    }
}
