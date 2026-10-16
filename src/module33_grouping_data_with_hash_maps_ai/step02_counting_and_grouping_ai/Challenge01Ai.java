// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step02_counting_and_grouping_ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A restaurant's kitchen gets the orders of an evening, one per line: a table number and a dish, separated by a comma, like {@code 4,soup}. An empty line ends the evening. Group the orders by dish in a {@code HashMap<String, ArrayList<Integer>>}: each dish's list holds the table of every order of it, in the order read. Then print each dish with how many times it was ordered (the size of its list) and its tables, like {@code soup: 2, tables [4, 9]}, with the dishes in alphabetical order. Sort the dish names with {@code Collections.sort}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * curry: 3, tables [9, 4, 4]
     * salad: 1, tables [2]
     * soup: 2, tables [4, 9]
     * }</pre>
     * Hints
     * 1. Read in a {@code while (true)} loop that stops with {@code break} at the empty line. {@code line.split(",")} gives the table in {@code parts[0]}, to turn into a number with {@code Integer.valueOf}, and the dish in {@code parts[1]}. Add the table to the dish's list, and create the list the first time the dish comes up.
     * 2. After the loop, copy the keys into a list with {@code new ArrayList<>(tablesByDish.keySet())} and sort it with {@code Collections.sort}. For each dish, {@code tablesByDish.get(dish)} is its list of tables, and its {@code size()} is the count.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> tablesByDish = new HashMap<>();

    }
}
