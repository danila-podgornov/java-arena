// AI-Generated
package module11_return_values_and_the_call_stack_ai.step05_methods_that_call_methods_ai;

public class Challenge02Ai {
    /**
     * Write {@code priceWithTax(double price)}, which returns the price plus its tax. Use the {@code tax} method that's already there. The check runs {@code System.out.println(priceWithTax(100));} and expects: see the expected output below.
     * Expected output
     * {@code 125.0}
     * Hints
     * 1. {@code tax(price)} returns the tax on the price.
     * 2. {@code return price + tax(price);}
     */
    public static void main(String[] args) {
        System.out.println(priceWithTax(100));
    }

    public static double tax(double price) {
        return price * 0.25;
    }

    // Write the priceWithTax method here.
}
