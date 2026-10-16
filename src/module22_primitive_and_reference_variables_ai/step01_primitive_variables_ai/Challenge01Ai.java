// AI-Generated
package module22_primitive_and_reference_variables_ai.step01_primitive_variables_ai;

public class Challenge01Ai {
    /**
     * What does this program print? Keep track of each variable's value on paper, line by line.
     * Hints
     * 1. {@code int second = first;} copies 7 into {@code second}. Doubling {@code first} afterwards doesn't change {@code second}, and {@code second++} makes it 8.
     * 2. {@code sum} is worked out once, from 14 and 8. Setting {@code first} to 1 later doesn't change it. The chars work the same way: {@code copy} keeps the {@code 'B'} it was given.
     */
    public static void main(String[] args) {
        int first = 7;
        int second = first;
        first = first * 2;
        second++;
        int sum = first + second;
        first = 1;
        char grade = 'B';
        char copy = grade;
        grade = 'A';
        System.out.println(first);
        System.out.println(second);
        System.out.println(sum);
        System.out.println(grade + " " + copy);
    }
}
