// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge03_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Thermometer thermometer;

    public UserInterface(Scanner scanner, Thermometer thermometer) {
        this.scanner = scanner;
        this.thermometer = thermometer;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Station off");
                break;
            }
            if (command.equals("add")) {
                int degrees = Integer.valueOf(this.scanner.nextLine());
                this.thermometer.record(degrees);
                System.out.println("Recorded " + degrees);
            } else if (command.equals("low") || command.equals("high")) {
                if (this.thermometer.count() == 0) {
                    System.out.println("No readings yet");
                } else if (command.equals("low")) {
                    System.out.println("Lowest: " + this.thermometer.lowest());
                } else {
                    System.out.println("Highest: " + this.thermometer.highest());
                }
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
