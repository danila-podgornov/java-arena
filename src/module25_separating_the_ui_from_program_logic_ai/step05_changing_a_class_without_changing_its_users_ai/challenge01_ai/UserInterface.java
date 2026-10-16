// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge01_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TipJar jar;

    public UserInterface(Scanner scanner, TipJar jar) {
        this.scanner = scanner;
        this.jar = jar;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Closed");
                break;
            }
            if (command.equals("tip")) {
                this.jar.add(Integer.valueOf(this.scanner.nextLine()));
                System.out.println("Thank you!");
            } else if (command.equals("count")) {
                System.out.println(this.jar.count() + " tips");
            } else if (command.equals("total")) {
                System.out.println("Total: " + this.jar.total() + " cents");
            } else if (command.equals("biggest")) {
                System.out.println("Biggest: " + this.jar.biggest() + " cents");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
