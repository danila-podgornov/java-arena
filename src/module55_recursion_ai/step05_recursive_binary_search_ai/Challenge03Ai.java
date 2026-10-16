// AI-Generated
package module55_recursion_ai.step05_recursive_binary_search_ai;

public class Challenge03Ai {
    /**
     * A school's lost-and-found keeps the names on its labels in a sorted array, in alphabetical order (as {@code compareTo} orders them, module 38). Write two methods named {@code findLabel}:
     * <ul>
     * <li>{@code findLabel(String[] labels, String name, int low, int high)}: the recursive binary search between {@code low} and {@code high}, returning the index of {@code name}, or -1. Strings are compared with {@code compareTo}: {@code name.compareTo(labels[middle])} is 0 when they are equal, below 0 when {@code name} comes first, and above 0 when it comes after.
     * <li>{@code findLabel(String[] labels, String name)}: searches the whole array, by calling the first one.
     * </ul>
     * <p>The check calls only the second one. It runs:
     * <pre>{@code
     * String[] labels = {"Aino", "Bilal", "Chen", "Dara", "Emil", "Freya", "Gus"};
     * System.out.println(findLabel(labels, "Emil"));
     * System.out.println(findLabel(labels, "Bo"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 4
     * -1
     * }</pre>
     * Hints
     * 1. The two-parameter method is one line: {@code return findLabel(labels, name, 0, labels.length - 1);}
     * 2. In the recursive one, compare once and keep the result: {@code int order = name.compareTo(labels[middle]);}. If it's above 0, the name comes after the middle, so search from {@code middle + 1} to {@code high}.
     */
    public static void main(String[] args) {
        String[] labels = {"Aino", "Bilal", "Chen", "Dara", "Emil", "Freya", "Gus"};
        System.out.println(findLabel(labels, "Emil"));
        System.out.println(findLabel(labels, "Bo"));
    }

    public static int findLabel(String[] labels, String name) {
        return -1;
    }

    // Write the recursive findLabel here.
}
