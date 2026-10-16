// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge03_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Elevator elevator;

    public UserInterface(Scanner scanner, Elevator elevator) {
        this.scanner = scanner;
        this.elevator = elevator;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Out of service");
                break;
            }
            if (command.equals("go")) {
                int target = Integer.valueOf(this.scanner.nextLine());
                if (this.elevator.goTo(target)) {
                    System.out.println("Floor " + this.elevator.getFloor());
                } else {
                    System.out.println("No floor " + target);
                }
            } else if (command.equals("where")) {
                System.out.println("Floor " + this.elevator.getFloor());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
