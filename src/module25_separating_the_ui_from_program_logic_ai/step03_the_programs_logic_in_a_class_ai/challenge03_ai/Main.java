// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step03_the_programs_logic_in_a_class_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * Here's the deli counter of the previous step, with everything in {@code main}. It works, but the list and the work on it are tangled with the talking. Move the logic into {@code DeliLine.java}, so that {@code main} keeps only the prompt, the reading and the printing. The class needs:
     * <ul>
     * <li>{@code DeliLine()}: an empty line.
     * <li>{@code take(String name)}: adds the name to the end of the line and returns their place in it, 1 for the first.
     * <li>{@code isEmpty()}: returns {@code true} when nobody is waiting.
     * <li>{@code next()}: takes the first name off the line and returns it. {@code main} only calls it when someone is waiting.
     * <li>{@code toString()}: returns the names in line, like {@code [Ben, Cleo]}.
     * </ul>
     * <p>Then change {@code main} to use a DeliLine instead of the list. The program prints exactly what it did. For the input shown: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Ana, you're number 1
     * > Ben, you're number 2
     * > Now serving Ana
     * > Cleo, you're number 2
     * > In line: [Ben, Cleo]
     * > Now serving Ben
     * > Now serving Cleo
     * > Nobody is waiting
     * > Closed for today
     * }</pre>
     * Hints
     * 1. The list becomes an instance variable of DeliLine, created in its constructor. Each method does what {@code main} did with the list: {@code take} adds and returns {@code this.names.size()}, {@code next} keeps {@code this.names.get(0)} in a variable, removes it and returns it.
     * 2. {@code toString()} can return {@code this.names.toString()}, the list's own text. In {@code main}, create {@code DeliLine line = new DeliLine();} and replace each use of the list with a call, such as {@code line.take(name)}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Closed for today");
                break;
            }
            if (command.equals("take")) {
                String name = scanner.nextLine();
                names.add(name);
                System.out.println(name + ", you're number " + names.size());
            } else if (command.equals("next")) {
                if (names.isEmpty()) {
                    System.out.println("Nobody is waiting");
                } else {
                    System.out.println("Now serving " + names.get(0));
                    names.remove(0);
                }
            } else if (command.equals("queue")) {
                System.out.println("In line: " + names);
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
