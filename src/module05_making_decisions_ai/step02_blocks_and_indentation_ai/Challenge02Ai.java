// AI-Generated
package module05_making_decisions_ai.step02_blocks_and_indentation_ai;

import java.util.Scanner;

public class Challenge02Ai {
  /**
   * Re-indent this program too. It reads a number and checks it twice. For the input {@code 250} the output stays: see the expected output below.
   * Expected output
   * <pre>{@code
   * Big number
   * Checked
   * }</pre>
   * Hints
   * 1. Inside main (2 blocks deep) lines have 8 spaces; inside an {@code if} in main, 12.
   * 2. Both {@code if} statements are at the same level, so they start in the same column.
   */
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
    int number = Integer.valueOf(scanner.nextLine());
    if (number > 100) {
    System.out.println("Big number");
    }
        if (number < 0) {
            System.out.println("Negative number");
        }
    System.out.println("Checked");
  }
}
