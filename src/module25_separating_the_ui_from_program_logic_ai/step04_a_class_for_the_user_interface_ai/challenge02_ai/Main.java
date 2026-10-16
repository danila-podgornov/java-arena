// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * Here's the thermostat of the previous step, with its user interface in {@code main}. Move the user interface into {@code UserInterface.java}: a constructor that takes a {@code Scanner} and a {@code Thermostat}, and a method {@code start()} with the command loop. Then {@code main} only creates the Scanner, the thermostat with the target 21, and the user interface, and calls {@code start()}. The program prints exactly what it did. For the input shown: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Target: 21 degrees
     * > Target: 22 degrees
     * > Target: 23 degrees
     * > Target: 22 degrees
     * > Unknown command: heat
     * > Thermostat off
     * }</pre>
     * Hints
     * 1. {@code UserInterface} gets two instance variables, the Scanner and the Thermostat, set in its constructor. The whole {@code while} loop moves into {@code public void start()}.
     * 2. In the moved loop, {@code scanner} becomes {@code this.scanner} and {@code thermostat} becomes {@code this.thermostat}. {@code main} keeps its first two lines and then does {@code UserInterface ui = new UserInterface(scanner, thermostat);} and {@code ui.start();}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Thermostat thermostat = new Thermostat(21);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("off")) {
                System.out.println("Thermostat off");
                break;
            }
            if (command.equals("up")) {
                if (thermostat.warmer()) {
                    System.out.println("Target: " + thermostat.getTarget() + " degrees");
                } else {
                    System.out.println("Already at the maximum");
                }
            } else if (command.equals("down")) {
                if (thermostat.cooler()) {
                    System.out.println("Target: " + thermostat.getTarget() + " degrees");
                } else {
                    System.out.println("Already at the minimum");
                }
            } else if (command.equals("show")) {
                System.out.println("Target: " + thermostat.getTarget() + " degrees");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
