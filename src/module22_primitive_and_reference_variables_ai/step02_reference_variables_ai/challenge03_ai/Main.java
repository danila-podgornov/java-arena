// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * In a quiz, two teams answer in turns, red first. The program reads the points for each answer, one per line, until {@code end}: the first answer is red's, the second blue's, the third red's again, and so on. {@code Main} already has a variable {@code current} that points at the team whose turn it is. For each answer, add the points with {@code current.addPoints(...)}, then point {@code current} at the other team, using {@code ==} to see which team it points at now. At the end, print both teams. For the input {@code 3}, {@code 2}, {@code 4}, {@code 1} and {@code end}, one per line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Red: 7 points
     * Blue: 3 points
     * }</pre>
     * Hints
     * 1. In a {@code while (true)} loop: read a line, {@code break} at {@code end}, and otherwise {@code current.addPoints(Integer.valueOf(line));}. The points go to whichever team {@code current} points at.
     * 2. Then pass the turn: {@code if (current == red) { current = blue; } else { current = red; }}. That only changes where {@code current} points, and both teams keep their points.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Team red = new Team("Red");
        Team blue = new Team("Blue");
        Team current = red;

        System.out.println(red);
        System.out.println(blue);
    }
}
