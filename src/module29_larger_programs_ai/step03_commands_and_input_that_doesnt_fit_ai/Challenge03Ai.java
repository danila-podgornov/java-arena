// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A music school books its practice rooms with commands. {@code book} should read a room's name and then a number of hours. What does this program print? Follow each line of input: which part of the program reads it?
     * Hints
     * 1. There's no room called {@code cellar}, so {@code continue} starts the next round before the hours are read. What's the next line in the input then?
     * 2. The next round reads {@code 3} as a command. That's why a command should read all of its lines before checking any of them.
     */
    public static void main(String[] args) {
        ArrayList<String> rooms = new ArrayList<>();
        rooms.add("studio");
        rooms.add("attic");
        Scanner scanner = new Scanner("book\ncellar\n3\nbook\nattic\n2\nquit\n");
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                break;
            }
            if (command.equals("book")) {
                String room = scanner.nextLine();
                if (!rooms.contains(room)) {
                    System.out.println("No room called " + room);
                    continue;
                }
                int hours = Integer.valueOf(scanner.nextLine());
                System.out.println(room + " booked for " + hours + " hours");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
