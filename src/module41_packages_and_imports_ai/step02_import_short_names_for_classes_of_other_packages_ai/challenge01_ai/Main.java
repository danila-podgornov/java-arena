// AI-Generated
package module41_packages_and_imports_ai.step02_import_short_names_for_classes_of_other_packages_ai.challenge01_ai;

public class Main {
    /**
     * The shoe store's program has grown a second package, {@code shoestore.logic}, with a class {@code Stock}, which uses {@code Shoe} from {@code shoestore.domain}. {@code Shoe.java} and {@code Stock.java} are ready, but {@code Main.java} doesn't compile: it uses both classes by their simple names without importing them. Add the import lines at the top of {@code Main.java}, one for each class (or one for each package with {@code *}), and don't change the rest. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 pairs
     * 2 pairs in size 42
     * }</pre>
     * Hints
     * 1. javac says {@code cannot find symbol} for {@code Stock} and {@code Shoe}: Main is in the default package, and the two classes are in other packages.
     * 2. The first lines of {@code Main.java} become {@code import shoestore.domain.Shoe;} and {@code import shoestore.logic.Stock;}, above {@code public class Main}.
     */
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.add(new Shoe("Trail runner", 42));
        stock.add(new Shoe("Winter boot", 39));
        stock.add(new Shoe("Loafer", 42));
        System.out.println(stock.count() + " pairs");
        System.out.println(stock.countSize(42) + " pairs in size 42");
    }
}
