// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge01_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ToolLibrary library;

    public UserInterface(Scanner scanner, ToolLibrary library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye");
                break;
            }
            if (command.equals("borrow")) {
                String name = this.scanner.nextLine();
                String person = this.scanner.nextLine();
                Tool tool = this.library.find(name);
                // Add the checks here.
                tool.lendTo(person);
                System.out.println(person + " borrowed the " + name);
            } else if (command.equals("return")) {
                String name = this.scanner.nextLine();
                Tool tool = this.library.find(name);
                if (tool == null) {
                    System.out.println("No tool called " + name);
                } else {
                    tool.giveBack();
                    System.out.println("The " + name + " is back on the shelf");
                }
            } else if (command.equals("tools")) {
                for (Tool tool : this.library.tools()) {
                    System.out.println(tool);
                }
            }
            // Answer unknown commands here.
        }
    }
}
