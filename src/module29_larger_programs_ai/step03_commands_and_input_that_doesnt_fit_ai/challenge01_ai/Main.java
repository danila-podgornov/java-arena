// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * Neighbors share tools through a tool library. {@code Tool.java}, {@code ToolLibrary.java} and {@code Main.java} are ready: the library has a drill, a ladder and a saw, {@code find} returns the tool with the given name or {@code null}, and {@code isAvailable()} tells whether a tool is on the shelf. In {@code UserInterface.java}, {@code return} already checks its tool. {@code borrow} reads two lines, the tool and the person, but it has no checks yet, and unknown commands get no answer. Add:
     * <ul>
     * <li>in {@code borrow}, when there's no tool by that name: {@code No tool called } and the name,
     * <li>in {@code borrow}, when the tool is lent out: {@code The }, the name and {@code  is lent out},
     * <li>otherwise lend it, as now,
     * <li>an answer to unknown commands: {@code Unknown command: } and the command.
     * </ul>
     * <p>For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Ana borrowed the ladder
     * > The ladder is lent out
     * > No tool called hammer
     * > The ladder is back on the shelf
     * > Ben borrowed the ladder
     * > Unknown command: fix
     * > drill: on the shelf
     * ladder: lent to Ben
     * saw: on the shelf
     * > Bye
     * }</pre>
     * Hints
     * 1. Follow the model of {@code return}: {@code if (tool == null)} comes first, since calling a method of {@code null} crashes. Then {@code else if (!tool.isAvailable())}, and the lending goes in the last {@code else}.
     * 2. The answer to unknown commands is one more {@code else} at the end of the chain, after the {@code tools} branch: {@code else { System.out.println("Unknown command: " + command); }}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToolLibrary library = new ToolLibrary();
        library.add(new Tool("drill"));
        library.add(new Tool("ladder"));
        library.add(new Tool("saw"));
        UserInterface ui = new UserInterface(scanner, library);
        ui.start();
    }
}
