// AI-Generated
package module15_arrays_ai.step01_creating_an_array_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Keep track of each element, and remember the default value.
     * Hints
     * 1. {@code points[3]} is set while {@code points[1]} is still 5, so it becomes 10. Only after that does {@code points[1]} go up to 6.
     * 2. {@code points[2]} is never assigned, so it still holds the default 0.
     */
    public static void main(String[] args) {
        int[] points = new int[4];
        points[1] = 5;
        points[3] = points[1] * 2;
        points[1]++;
        points[0] = points[3] - points[1];
        System.out.println(points[0]);
        System.out.println(points[1]);
        System.out.println(points[2]);
        System.out.println(points[3]);
    }
}
