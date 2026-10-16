// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step03_a_command_program_procedurally_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * What does this program print? A room of a museum lets in at most 50 visitors at a time. The commands come from a String, so the program reads no input: {@code in} and {@code out} are each followed by a line with the size of a group.
     * Hints
     * 1. Keep track of {@code inside} command by command. After {@code in 30} it's 30, and {@code out 40} asks for more visitors than are inside.
     * 2. A refused command changes nothing and prints a line. {@code in 25} would make 55, more than the 50 allowed. Then {@code out 10} leaves 20.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner("in\n30\nout\n40\nin\n25\nout\n10\nend\n");
        int capacity = 50;
        int inside = 0;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }
            int count = Integer.valueOf(scanner.nextLine());
            if (command.equals("in") && inside + count <= capacity) {
                inside = inside + count;
            } else if (command.equals("out") && count <= inside) {
                inside = inside - count;
            } else {
                System.out.println("refused: " + command + " " + count);
            }
        }
        System.out.println(inside);
    }
}
