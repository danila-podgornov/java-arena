// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge03_ai;

import java.util.Scanner;

public class UserInterface {
    // Write the instance variables and the constructor here.

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Closing the stand");
                break;
            }
            if (command.equals("sell")) {
                int cups = Integer.valueOf(this.scanner.nextLine());
                if (this.stand.sell(cups)) {
                    System.out.println("Sold " + cups + " cups");
                } else {
                    System.out.println("Only " + this.stand.cupsLeft() + " cups left");
                }
            } else if (command.equals("left")) {
                System.out.println("Cups left: " + this.stand.cupsLeft());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
