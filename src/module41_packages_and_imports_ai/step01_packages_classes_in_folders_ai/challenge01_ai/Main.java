// AI-Generated
package module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge01_ai;

public class Main {
    /**
     * A shoe store's program keeps its classes in the package {@code shoestore.domain}. {@code Main.java} is ready: it uses the class {@code Shoe} by its full name. In {@code shoestore/domain/Shoe.java}, start with the package line, and then write the class {@code Shoe}, with:
     * <ul>
     * <li>a constructor {@code Shoe(String model, int size)}
     * <li>{@code getSize()}, which returns the size
     * <li>{@code toString()}, which returns the model and the size, like {@code Trail runner, size 42}
     * </ul>
     * <p>The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Trail runner, size 42
     * 42
     * shoestore.domain.Shoe
     * }</pre>
     * Hints
     * 1. The file is in the folder {@code shoestore/domain/}, so its first line is {@code package shoestore.domain;}. After it comes the class, written as always: <code>public class Shoe {</code>.
     * 2. Give Shoe two instance variables, the model and the size, and set them in the constructor. {@code toString} returns {@code this.model + ", size " + this.size}.
     */
    public static void main(String[] args) {
        module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge01_ai.shoestore.domain.Shoe shoe = new module41_packages_and_imports_ai.step01_packages_classes_in_folders_ai.challenge01_ai.shoestore.domain.Shoe("Trail runner", 42);
        System.out.println(shoe);
        System.out.println(shoe.getSize());
        System.out.println(shoe.getClass().getName());
    }
}
