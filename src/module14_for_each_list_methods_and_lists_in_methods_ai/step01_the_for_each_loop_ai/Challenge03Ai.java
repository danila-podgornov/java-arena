// AI-Generated
package module14_for_each_list_methods_and_lists_in_methods_ai.step01_the_for_each_loop_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * Things come out of a moving box in the opposite order to how they went in. Read items until the line {@code close}. Print {@code Packed: } and each item in order with a for-each loop. Then print {@code Unpacked: } and each item from the last to the first, with an index loop that counts down. For the input {@code books}, {@code lamp}, {@code mugs} the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Packed: books
     * Packed: lamp
     * Packed: mugs
     * Unpacked: mugs
     * Unpacked: lamp
     * Unpacked: books
     * }</pre>
     * Hints
     * 1. The for-each loop does the packing. A for-each loop can only go forwards, so unpacking needs an index.
     * 2. The last index is {@code box.size() - 1}: {@code for (int i = box.size() - 1; i >= 0; i--)}, with {@code box.get(i)} inside.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> box = new ArrayList<>();

    }
}
