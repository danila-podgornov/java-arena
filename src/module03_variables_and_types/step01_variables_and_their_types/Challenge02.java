package module03_variables_and_types.step01_variables_and_their_types;

public class Challenge02 {
    /**
     * Choose the right type for each of the four variables, so the program compiles and prints {@code Oslo, 2026: -3.5 degrees, raining: false}.
     * Expected output
     * {@code Oslo, 2026: -3.5 degrees, raining: false}
     */
    public static void main(String[] args) {
        int year = 2026;
        double temperature = -3.5;
        boolean raining = false;
        String city = "Oslo";
        System.out.println(city + ", " + year + ": " + temperature + " degrees, raining: " + raining);
    }
}
