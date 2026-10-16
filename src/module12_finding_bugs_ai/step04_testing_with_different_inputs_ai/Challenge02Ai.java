// AI-Generated
package module12_finding_bugs_ai.step04_testing_with_different_inputs_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * A swimming pool charges by age: under 7 swim free, 7 to 17 pay 3 euros, and 18 or older pay 6 euros. This program gets some ages wrong. Test it with the ages at the edges (6, 7, 17 and 18), then fix it. With the input {@code 17} it prints: see the expected output below.
     * Expected output
     * {@code Price: 3 euros}
     * Hints
     * 1. Work out by hand what the program does for 7 and for 17, and compare with the rules.
     * 2. "Under 7" is {@code age < 7}, and "7 to 17" includes 17: {@code age <= 17}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.valueOf(scanner.nextLine());
        int price;
        if (age <= 7) {
            price = 0;
        } else if (age < 17) {
            price = 3;
        } else {
            price = 6;
        }
        System.out.println("Price: " + price + " euros");
    }
}
