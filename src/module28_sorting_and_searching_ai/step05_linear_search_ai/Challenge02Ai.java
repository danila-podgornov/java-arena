// AI-Generated
package module28_sorting_and_searching_ai.step05_linear_search_ai;

public class Challenge02Ai {
    /**
     * This search has a common mistake in it. What does the program print?
     * Hints
     * 1. In the first round of the loop, {@code i} is 0. The {@code if} compares the first code with the wanted one, and both of its branches end the method with {@code return}.
     * 2. So the method only ever looks at {@code codes[0]}. It returns 0 when the first code matches, and -1 for anything else, even for codes that are in the array.
     */
    public static void main(String[] args) {
        int[] codes = {40, 15, 72, 15};
        System.out.println(find(codes, 40));
        System.out.println(find(codes, 72));
        System.out.println(find(codes, 15));
    }

    public static int find(int[] codes, int wanted) {
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] == wanted) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
