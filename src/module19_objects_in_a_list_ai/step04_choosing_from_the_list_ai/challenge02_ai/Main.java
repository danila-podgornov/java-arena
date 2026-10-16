// AI-Generated
package module19_objects_in_a_list_ai.step04_choosing_from_the_list_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * A yearly bird count. Each line of the input holds a species, last year's count and this year's count, separated by commas, like {@code robin,15,12}. The input ends with an empty line. {@code BirdCount.java} is ready. Read the lines into the list {@code counts}. Then print every species that was seen less this year than last year, with how many fewer birds, like {@code robin: 3 fewer}, in the order they were read. Last, print how many of the species went down, like {@code 2 of 4 species went down}. For the input {@code robin,15,12}, {@code heron,4,6}, {@code sparrow,40,31}, {@code owl,2,2} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * robin: 3 fewer
     * sparrow: 9 fewer
     * 2 of 4 species went down
     * }</pre>
     * Hints
     * 1. Read the lines as in the last step: {@code split(",")} gives the species in {@code parts[0]} and the two counts, as text, in {@code parts[1]} and {@code parts[2]}.
     * 2. The condition compares two getters of the same object: {@code count.getThisYear() < count.getLastYear()}. The difference is {@code count.getLastYear() - count.getThisYear()}. Count the species you print, and print the last line after the loop.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BirdCount> counts = new ArrayList<>();

    }
}
