// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.ui;

import java.util.Scanner;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.domain.Garment;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge02_ai.tailor.logic.Workroom;

public class TextUI {
    private Scanner scanner;
    private Workroom workroom;

    public TextUI(Scanner scanner, Workroom workroom) {
        this.scanner = scanner;
        this.workroom = workroom;
    }

    public void start() {
        while (true) {
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println(this.workroom.count() + " garments waiting");
                break;
            }
            if (command.equals("drop")) {
                String customer = this.scanner.nextLine();
                String item = this.scanner.nextLine();
                System.out.println("Order " + this.workroom.drop(customer, item));
            } else if (command.equals("pickup")) {
                int number = Integer.valueOf(this.scanner.nextLine());
                Garment garment = this.workroom.pickUp(number);
                if (garment == null) {
                    System.out.println("Nothing for order " + number);
                } else {
                    System.out.println(garment.getItem() + " for " + garment.getCustomer());
                }
            }
        }
    }
}
