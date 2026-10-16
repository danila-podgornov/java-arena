// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step04_record_patterns_ai.challenge03_ai;

public class Main {
    /**
     * A small calculator stores an expression such as {@code (2 + 3) * 4} as a tree of records. An {@code Expr} is a number, {@code Num(int value)}, or the sum or the product of two smaller expressions, {@code Add(Expr left, Expr right)} and {@code Mul(Expr left, Expr right)}. The method {@code show} in {@code Main.java} already turns an expression into text, with a switch over record patterns that calls itself for the parts. Write {@code eval(Expr expr)} in the same way: it returns the expression's value. Use a case with a record pattern for each of the three records, and no {@code default}. The check runs:
     * <pre>{@code
     * Expr sum = new Add(new Num(2), new Num(3));
     * Expr product = new Mul(sum, new Num(4));
     * System.out.println(show(sum) + " = " + eval(sum));
     * System.out.println(show(product) + " = " + eval(product));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * (2 + 3) = 5
     * ((2 + 3) * 4) = 20
     * }</pre>
     * Hints
     * 1. Copy the shape of {@code show}: {@code return switch (expr) { ... };} with the same three case labels.
     * 2. A Num's value is its {@code value}. For an Add, evaluate both parts and add them: {@code eval(left) + eval(right)}. A Mul multiplies them.
     */
    public static void main(String[] args) {
        Expr sum = new Add(new Num(2), new Num(3));
        Expr product = new Mul(sum, new Num(4));
        System.out.println(show(sum) + " = " + eval(sum));
        System.out.println(show(product) + " = " + eval(product));
    }

    public static String show(Expr expr) {
        return switch (expr) {
            case Num(int value) -> String.valueOf(value);
            case Add(Expr left, Expr right) -> "(" + show(left) + " + " + show(right) + ")";
            case Mul(Expr left, Expr right) -> "(" + show(left) + " * " + show(right) + ")";
        };
    }

    public static int eval(Expr expr) {
        return 0;
    }
}
