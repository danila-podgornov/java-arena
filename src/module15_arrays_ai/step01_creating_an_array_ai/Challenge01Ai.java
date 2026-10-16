// AI-Generated
package module15_arrays_ai.step01_creating_an_array_ai;

public class Challenge01Ai {
    /**
     * A parking garage has four levels, numbered 0 to 3. Fill in the blanks: make the array big enough for the four levels, and give level 3 its 20 free spots. Level 2 is never assigned, so it keeps the default value. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Level 0: 12 free
     * Level 1: 5 free
     * Level 2: 0 free
     * Level 3: 20 free
     * }</pre>
     * Hints
     * 1. The number in {@code new int[...]} is how many elements the array has: one for each level.
     * 2. The levels are 0, 1, 2 and 3, so the size is 4, and the second blank is the index 3.
     */
    public static void main(String[] args) {
        int[] freeSpots = new int[___];
        freeSpots[0] = 12;
        freeSpots[1] = 5;
        freeSpots[___] = 20;
        System.out.println("Level 0: " + freeSpots[0] + " free");
        System.out.println("Level 1: " + freeSpots[1] + " free");
        System.out.println("Level 2: " + freeSpots[2] + " free");
        System.out.println("Level 3: " + freeSpots[3] + " free");
    }
}
