// AI-Generated
package module55_recursion_ai.step04_when_recursion_goes_wrong_ai;

public class Challenge01Ai {
    /**
     * A ball is dropped from a height in centimeters, and each bounce reaches half the height of the one before, in whole centimeters ({@code / 2} on an int). From 40 it reaches 40, 20, 10, 5, 2 and 1, and then it lies still. {@code heights(height)} should return how many of those heights are above 0, the first drop included: 6 for 40. The method below has no base case: after 1 it calls {@code heights(0)}, and {@code heights(0)} calls {@code heights(0)} again and again ({@code 0 / 2} is 0), until the StackOverflowError. Add a base case: for a height of 0 there is nothing left to count, so it returns 0 without calling itself. Keep the method recursive. The check runs {@code System.out.println(heights(40));} and expects: see the expected output below.
     * Expected output
     * {@code 6}
     * Hints
     * 1. The base case goes at the start of the method, before the recursive call.
     * 2. {@code if (height == 0) { return 0; }} stops the calls when the ball doesn't bounce any more: from 1, the call {@code heights(0)} then adds nothing, and {@code heights(1)} returns 1 + 0.
     */
    public static void main(String[] args) {
        System.out.println(heights(40));
    }

    public static int heights(int height) {
        return 1 + heights(height / 2);
    }
}
