package module03_variables_and_types.step02_changing_a_value;

public class Challenge01 {
    /**
     * Change {@code weather} to {@code rainy} between the two prints, so the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Morning: sunny
     * Evening: rainy
     * }</pre>
     */
    public static void main(String[] args) {
        String weather = "sunny";
        System.out.println("Morning: " + weather);
        // Change weather to rainy here.
        weather = "rainy";
        System.out.println("Evening: " + weather);
    }
}
