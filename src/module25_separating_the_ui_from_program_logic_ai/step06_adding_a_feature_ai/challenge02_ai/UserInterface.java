// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step06_adding_a_feature_ai.challenge02_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Train train;

    public UserInterface(Scanner scanner, Train train) {
        this.scanner = scanner;
        this.train = train;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("End of the line");
                break;
            }
            if (command.equals("attach")) {
                this.train.attach(this.scanner.nextLine());
                System.out.println(this.train);
            } else if (command.equals("detach")) {
                if (this.train.detach()) {
                    System.out.println(this.train);
                } else {
                    System.out.println("No cars to detach");
                }
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
