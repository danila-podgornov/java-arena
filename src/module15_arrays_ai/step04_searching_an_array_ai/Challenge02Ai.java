// AI-Generated
package module15_arrays_ai.step04_searching_an_array_ai;

import java.util.Scanner;

public class Challenge02Ai {
    /**
     * The program reads the number of students in a class, then each student's locker number: student 1's first, then student 2's, and so on. Then it reads one more locker number. Search the array for it, and print which student has that locker (the index plus one), or that the locker is free. For the input {@code 4}, {@code 17}, {@code 5}, {@code 42}, {@code 8} and then {@code 42} the program prints:
     * {@code Locker 42 belongs to student 3}
     * <p>For the locker {@code 99} it would print {@code Locker 99 is free}.
     * Hints
     * 1. Start with {@code int student = -1;} to mean "not found". In the loop, when {@code lockers[i] == wanted}, store {@code i + 1} and {@code break}.
     * 2. After the loop, {@code student == -1} means the locker number wasn't in the array.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.valueOf(scanner.nextLine());
        int[] lockers = new int[students];
        for (int i = 0; i < lockers.length; i++) {
            lockers[i] = Integer.valueOf(scanner.nextLine());
        }
        int wanted = Integer.valueOf(scanner.nextLine());

    }
}
