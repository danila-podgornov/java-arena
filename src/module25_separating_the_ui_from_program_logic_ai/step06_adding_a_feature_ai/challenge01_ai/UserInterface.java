// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge01_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private WaterLog log;

    public UserInterface(Scanner scanner, WaterLog log) {
        this.scanner = scanner;
        this.log = log;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            if (command.equals("drink")) {
                int ml = Integer.valueOf(this.scanner.nextLine());
                this.log.drink(ml);
                System.out.println("Total: " + this.log.total() + " ml");
            } else if (command.equals("total")) {
                System.out.println("Total: " + this.log.total() + " ml");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
