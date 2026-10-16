// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge02_ai;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private League league;

    public UserInterface(Scanner scanner, League league) {
        this.scanner = scanner;
        this.league = league;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Good night");
                break;
            }
            if (command.equals("leader")) {
                Player leader = this.league.leader();
                if (leader == null) {
                    System.out.println("No players yet");
                } else {
                    System.out.println("Leader: " + leader);
                }
            } else if (command.equals("add")) {
                // Write the add command here.
            } else if (command.equals("compare")) {
                // Write the compare command here.
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private int toNumber(String text) {
        try {
            return Integer.valueOf(text);
        } catch (Exception e) {
            return -1;
        }
    }
}
