// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step06_enums_with_fields_a_constructor_and_methods_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A cash register gives change in four kinds of US bills: ones, fives, tens and twenties. Write:
     * <ul>
     * <li>in {@code Bill.java}, the enum {@code Bill}, with the constants {@code ONE}, {@code FIVE}, {@code TEN} and {@code TWENTY}, in that order, each with its value in dollars, and the method {@code getDollars()}
     * <li>in {@code Main.java}, the method {@code change(int dollars)}, which returns an {@code ArrayList<Bill>} that makes up the amount with as few bills as possible: as many twenties as fit, then as many tens as fit in what's left, then fives, then ones
     * </ul>
     * <p>Go through {@code Bill.values()} backwards with an index loop, as in step 1, so the largest bill comes first. The check runs:
     * <pre>{@code
     * System.out.println(change(68));
     * System.out.println(change(30));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [TWENTY, TWENTY, TWENTY, FIVE, ONE, ONE, ONE]
     * [TWENTY, TEN]
     * }</pre>
     * Hints
     * 1. The enum is like CupSize with one value: {@code ONE(1), FIVE(5), TEN(10), TWENTY(20);}, a private {@code int dollars}, a private constructor and {@code getDollars()}.
     * 2. In {@code change}, take {@code Bill[] kinds = Bill.values();} and loop {@code for (int i = kinds.length - 1; i >= 0; i--)}. Inside it, a {@code while} loop adds {@code kinds[i]} to the list and takes its dollars off the amount, as long as the bill still fits.
     */
    public static void main(String[] args) {
        System.out.println(change(68));
        System.out.println(change(30));
    }

    // Write the method change here.
}
