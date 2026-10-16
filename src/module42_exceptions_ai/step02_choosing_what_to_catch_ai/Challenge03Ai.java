// AI-Generated
package module42_exceptions_ai.step02_choosing_what_to_catch_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * An online course shows your progress written as {@code done/total}, such as {@code 7/20} for 7 lessons done out of 20. The program should print {@code 35% done} for {@code 7/20}, {@code The total can't be 0} when the total is 0, {@code Use whole numbers, like 7/20} when a part isn't a whole number, and {@code Write it as done/total, like 7/20} for any other problem. It doesn't compile. Read javac's messages and fix the program, without changing what any block prints. With the input {@code 7/0} it prints: see the expected output below.
     * Expected output
     * {@code The total can't be 0}
     * Hints
     * 1. javac says that the exceptions of the later blocks {@code have already been caught}. {@code catch (Exception e)} comes first, and it catches every exception, so the blocks after it could never run.
     * 2. Move the {@code catch (Exception e)} block to the end, after the ArithmeticException and NumberFormatException blocks.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        try {
            String[] parts = line.split("/");
            int done = Integer.parseInt(parts[0]);
            int total = Integer.parseInt(parts[1]);
            System.out.println(done * 100 / total + "% done");
        } catch (Exception e) {
            System.out.println("Write it as done/total, like 7/20");
        } catch (ArithmeticException e) {
            System.out.println("The total can't be 0");
        } catch (NumberFormatException e) {
            System.out.println("Use whole numbers, like 7/20");
        }
    }
}
