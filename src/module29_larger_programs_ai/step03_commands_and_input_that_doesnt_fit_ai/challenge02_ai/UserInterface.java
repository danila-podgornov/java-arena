// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge02_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private CakeCounter counter;

    public UserInterface(Scanner scanner, CakeCounter counter) {
        this.scanner = scanner;
        this.counter = counter;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Closed");
                break;
            }
            if (command.equals("sell")) {
                // Write the sell command here.
            } else if (command.equals("cakes")) {
                for (Cake cake : this.counter.cakes()) {
                    System.out.println(cake);
                }
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
