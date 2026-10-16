// AI-Generated
package module44_type_parameters_generics_ai.step02_one_class_many_types_ai.challenge01_ai;

public class Main {
    /**
     * The storeroom's app keeps three boxes: the number of screws left, the liters of paint left, and whether the box of fuses is still sealed. Fill in the three type arguments. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * The fuses are still sealed
     * 210 screws
     * 1.75 liters of paint
     * }</pre>
     * Hints
     * 1. A type argument must be a reference type (a class, an interface or an array type, never a primitive type), so {@code int}, {@code double} and {@code boolean} won't do. Each primitive type has a wrapper class, written with a capital letter.
     * 2. The screws are a whole number, {@code Integer}; the paint has decimals, {@code Double}; and sealed is true or false, {@code Boolean}.
     */
    public static void main(String[] args) {
        Box<___> screws = new Box<>(250);
        Box<___> paint = new Box<>(3.5);
        Box<___> sealed = new Box<>(true);

        screws.setContent(screws.getContent() - 40);
        paint.setContent(paint.getContent() / 2);
        if (sealed.getContent()) {
            System.out.println("The fuses are still sealed");
        }
        System.out.println(screws.getContent() + " screws");
        System.out.println(paint.getContent() + " liters of paint");
    }
}
